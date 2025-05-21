import com.fasterxml.jackson.databind.*;
import java.io.File;

public class P5 {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File("student.json"));
            if (root.has("name") && root.has("age")) {
                System.out.println("Valid JSON structure.");
            } else {
                System.out.println("Invalid JSON structure.");
            }
        } catch (IOException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}
