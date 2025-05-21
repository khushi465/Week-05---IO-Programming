import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Khushi")
class Book {}

public class P6 {
    public static void main(String[] args) {
        Class<Book> cls = Book.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author a = cls.getAnnotation(Author.class);
            System.out.println("Author: " + a.name());
        }
    }
}
