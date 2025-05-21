import com.google.gson.*;

public class P3 {
    public static void main(String[] args) {
        String jsonData = "[{\"name\":\"Alice\",\"age\":30},{\"name\":\"Bob\",\"age\":20}]";
        JsonArray array = JsonParser.parseString(jsonData).getAsJsonArray();

        for (JsonElement element : array) {
            JsonObject user = element.getAsJsonObject();
            if (user.get("age").getAsInt() > 25) {
                System.out.println(user);
            }
        }
    }
}
