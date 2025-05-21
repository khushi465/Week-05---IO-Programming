import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P5 {
    public static void main(String[] args) throws Exception {
        JSONObject json1 = new JSONObject(Files.readString(Paths.get("file1.json")));
        JSONObject json2 = new JSONObject(Files.readString(Paths.get("file2.json")));

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println(json1.toString(2));
    }
}
