import org.json.*;
import java.nio.file.*;
import java.io.IOException;

public class P3 {
    public static void main(String[] args) throws IOException {
        String content = Files.readString(Path.of("users.json"));
        JSONArray array = new JSONArray(content);
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            System.out.println("Name: " + obj.getString("name") + ", Email: " + obj.getString("email"));
        }
    }
}