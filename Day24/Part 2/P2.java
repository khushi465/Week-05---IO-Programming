import com.google.gson.Gson;
import java.util.*;

class User {
    String name;
    int age;
    User(String name, int age) { this.name = name; this.age = age; }
}

public class P2 {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User("Alice", 30),
            new User("Bob", 20)
        );

        Gson gson = new Gson();
        String json = gson.toJson(users);
        System.out.println(json);
    }
}
