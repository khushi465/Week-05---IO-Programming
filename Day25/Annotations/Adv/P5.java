import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void deleteAllUsers() {
        System.out.println("All users deleted.");
    }
}

class AccessController {
    public static void execute(String role, Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        if (method.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed ra = method.getAnnotation(RoleAllowed.class);
            if (!ra.value().equals(role)) {
                System.out.println("Access Denied!");
                return;
            }
        }
        method.invoke(obj);
    }

    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();
        execute("ADMIN", service, "deleteAllUsers"); // Allowed
        execute("USER", service, "deleteAllUsers");  // Denied
    }
}
