import org.json.JSONObject;

public class P4 {
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject().put("id", 1).put("name", "Alice");
        JSONObject obj2 = new JSONObject().put("age", 22).put("email", "alice@example.com");

        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        System.out.println(obj1.toString(2));
    }
}
