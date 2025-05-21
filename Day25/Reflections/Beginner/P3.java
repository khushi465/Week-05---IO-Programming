import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) { return a * b; }
}

public class P3 {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Method m = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        m.setAccessible(true);
        int result = (int) m.invoke(c, 4, 5);
        System.out.println("Result: " + result);
    }
}
