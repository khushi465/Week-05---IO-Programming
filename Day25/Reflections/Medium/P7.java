import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "1234";
}

public class P7 {
    public static void main(String[] args) throws Exception {
        Field f = Configuration.class.getDeclaredField("API_KEY");
        f.setAccessible(true);
        System.out.println("Old API_KEY: " + f.get(null));
        f.set(null, "5678");
        System.out.println("New API_KEY: " + f.get(null));
    }
}
