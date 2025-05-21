import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class P5 {
    public static void main(String[] args) throws Exception {
        MathOperations m = new MathOperations();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter method name (add, subtract, multiply): ");
        String method = sc.next();
        Method target = MathOperations.class.getMethod(method, int.class, int.class);
        int result = (int) target.invoke(m, 10, 5);
        System.out.println("Result: " + result);
    }
}
