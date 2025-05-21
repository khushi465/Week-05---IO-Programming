import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Person {
    @JsonField(name = "user_name")
    private String name;

    @JsonField(name = "user_age")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, Object> jsonMap = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jf = field.getAnnotation(JsonField.class);
                jsonMap.put(jf.name(), field.get(obj));
            }
        }
        return jsonMap.toString().replace("=", ": ");
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person("Alice", 28);
        System.out.println(toJson(person));
    }
}
