import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Task completed.");
    }

    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo info = method.getAnnotation(TaskInfo.class);

        if (info != null) {
            System.out.println("Priority: " + info.priority());
            System.out.println("Assigned To: " + info.assignedTo());
        }

        new TaskManager().completeTask();
    }
}
