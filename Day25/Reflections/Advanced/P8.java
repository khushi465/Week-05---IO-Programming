import java.lang.reflect.*;
import java.util.*;

class Student {
    public String name;
    public int age;
}

class ObjectMapper {
    public static <T> T toObject(Class<T> cls, Map<String, Object> map) throws Exception {
        T obj = cls.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> e : map.entrySet()) {
            Field f = cls.getDeclaredField(e.getKey());
            f.setAccessible(true);
            f.set(obj, e.getValue());
        }
        return obj;
    }
}

public class P8 {
    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of("name", "Alice", "age", 22);
        Student s = ObjectMapper.toObject(Student.class, data);
        System.out.println(s.name + " - " + s.age);
    }
}
