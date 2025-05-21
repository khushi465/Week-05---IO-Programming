import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class Hello implements Greeting {
    public void sayHello() {
        System.out.println("Hello World");
    }
}

public class P10 {
    public static void main(String[] args) {
        Greeting g = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[]{Greeting.class},
            (proxy, method, methodArgs) -> {
                System.out.println("Calling method: " + method.getName());
                return method.invoke(new Hello(), methodArgs);
            }
        );
        g.sayHello();
    }
}
