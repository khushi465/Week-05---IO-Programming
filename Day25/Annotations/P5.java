import java.lang.annotation.*;
import java.lang.reflect.Method;

// Container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport {
    String description();
}


class BugTracker {

    @BugReport(description = "NullPointerException on line 23")
    @BugReport(description = "Incorrect logic when value is zero")
    public void process() {
        System.out.println("Processing bugs...");
    }

    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("process");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }

        new BugTracker().process();
    }
}
