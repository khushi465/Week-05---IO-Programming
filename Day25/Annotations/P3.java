import java.util.ArrayList;
import java.util.List;

public class P3 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List rawList = new ArrayList(); // No generics
        rawList.add("Hello");
        rawList.add(123);

        for (Object obj : rawList) {
            System.out.println(obj);
        }
    }
}
