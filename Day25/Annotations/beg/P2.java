import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class FeatureWork {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {
        // To be implemented
    }

    @Todo(task = "Validate user input", assignedTo = "Bob")
    public void inputValidation() {
        // To be implemented
    }

    public void utilityMethod() {
        System.out.println("No task here.");
    }
}

public class P2 {
    public static void main(String[] args) {
        Method[] methods = FeatureWork.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println("-------------------------");
            }
        }
    }
}
