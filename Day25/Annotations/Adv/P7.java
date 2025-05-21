import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveService {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int fibonacci(int n) {
        if (cache.containsKey(n)) {
            System.out.println("Returning cached result for " + n);
            return cache.get(n);
        }
        int result = (n <= 1) ? n : fibonacci(n - 1) + fibonacci(n - 2);
        cache.put(n, result);
        return result;
    }
}

public class P7 {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();
        System.out.println(service.fibonacci(10)); // Computed
        System.out.println(service.fibonacci(10)); // Cached
    }
}
