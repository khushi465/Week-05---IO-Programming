import org.json.JSONObject;

public class P1 {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Alice");
        student.put("age", 20);
        student.put("subjects", new String[]{"Math", "Science", "English"});

        System.out.println(student.toString(2));
    }
}