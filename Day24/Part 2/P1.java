import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P1 {
    public static void main(String[] args) throws Exception {
        String content = Files.readString(Paths.get("data.json"));
        JSONObject json = new JSONObject(content);

        for (String key : json.keySet()) {
            System.out.println(key + ": " + json.get(key));
        }
    }
}
