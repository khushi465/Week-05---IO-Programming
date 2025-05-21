import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {

    @ImportantMethod
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void saveToDatabase() {
        System.out.println("Saving to DB...");
    }

    public void helperMethod() {
        System.out.println("Helper method");
    }
}


public class P1 {
    public static void main(String[] args) {
        Method[] methods = Service.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod im = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + ", Level: " + im.level());
            }
        }
    }
}
