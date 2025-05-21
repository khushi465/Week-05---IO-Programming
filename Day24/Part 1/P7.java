import org.json.*;
import java.nio.file.*;

public class P7 {
    public static void main(String[] args) throws Exception {
        String content = Files.readString(Path.of("people.json"));
        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); i++) {
            JSONObject person = array.getJSONObject(i);
            if (person.getInt("age") > 25) {
                System.out.println(person.toString(2));
            }
        }
    }
}