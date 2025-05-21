import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import java.io.FileInputStream;
import java.io.InputStream;

public class P4 {
    public static void main(String[] args) throws Exception {
        InputStream schemaStream = new FileInputStream("email-schema.json");
        JSONObject rawSchema = new JSONObject(new java.util.Scanner(schemaStream).useDelimiter("\\A").next());
        Schema schema = SchemaLoader.load(rawSchema);

        JSONObject data = new JSONObject("{\"email\":\"user@example.com\"}");
        schema.validate(data); // Will throw ValidationException if invalid
        System.out.println("Email is valid!");
    }
}
