import java.lang.reflect.*;

class SomeTask {
    public void doTask() {
        for (int i = 0; i < 1000000; i++) {} // dummy work
    }
}

class TimedExecutor {
    public static void execute(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        long start = System.nanoTime();
        method.invoke(obj);
        long end = System.nanoTime();
        System.out.println("Execution time (ns): " + (end - start));
    }
}

public class P12 {
    public static void main(String[] args) throws Exception {
        TimedExecutor.execute(new SomeTask(), "doTask");
    }
}
