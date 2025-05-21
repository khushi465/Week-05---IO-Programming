import java.lang.reflect.*;

class JsonStudent {
    public String name = "Alice";
    public int age = 22;
}

public class P9 {
    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        Class<?> cls = obj.getClass();
        for (Field f : cls.getDeclaredFields()) {
            f.setAccessible(true);
            sb.append("\"").append(f.getName()).append("\":\"").append(f.get(obj)).append("\",");
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        JsonStudent s = new JsonStudent();
        String json = toJson(s);
        System.out.println(json);
    }
}
