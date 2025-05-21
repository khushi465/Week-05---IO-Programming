class Student {
    String name = "John";

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}

public class P4 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();
        System.out.println("Created: " + obj);
    }
}
