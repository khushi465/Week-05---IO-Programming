import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class TimerService {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {} // Light task
    }

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(500); // Simulated delay
        } catch (InterruptedException ignored) {}
    }
}

public class P3 {
    public static void main(String[] args) throws Exception {
        TimerService service = new TimerService();
        for (Method method : TimerService.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(service);
                long end = System.nanoTime();
                System.out.println(method.getName() + " executed in " + (end - start) / 1_000_000.0 + " ms");
            }
        }
    }
}
