import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength ml = field.getAnnotation(MaxLength.class);
                if (username.length() > ml.value()) {
                    throw new IllegalArgumentException("Username too long!");
                }
            }
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class P4 {
    public static void main(String[] args) {
        new User("Alice");         // OK
        new User("VeryLongUsername123"); // Throws exception
    }
}
