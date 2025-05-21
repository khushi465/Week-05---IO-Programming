import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    public void doService() {
        System.out.println("Service is running...");
    }
}

class Client {
    @Inject
    Service service;
}

public class P11 {
    public static void main(String[] args) throws Exception {
        Client client = new Client();

        for (Field f : client.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(client, f.getType().getDeclaredConstructor().newInstance());
            }
        }

        client.service.doService(); // Should print if injected successfully
    }
}
