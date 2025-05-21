import org.json.CDL;
import org.json.JSONArray;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P7 {
    public static void main(String[] args) throws Exception {
        String csv = Files.readString(Paths.get("data.csv"));
        JSONArray jsonArray = CDL.toJSONArray(csv);
        System.out.println(jsonArray.toString(2));
    }
}
