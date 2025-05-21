import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

class Employee {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class P6 {
    public static void main(String[] args) {
        List<Employee> list = List.of(new Employee("John", 30), new Employee("Jane", 28));
        JSONArray arr = new JSONArray();

        for (Employee e : list) {
            JSONObject obj = new JSONObject();
            obj.put("name", e.name);
            obj.put("age", e.age);
            arr.put(obj);
        }

        System.out.println(arr.toString(2));
    }
}
