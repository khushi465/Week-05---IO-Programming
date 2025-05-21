import java.io.*;
import java.util.*;

class Student {
    String id, name;
    int age;
    double marks;

    public Student(String id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }
}

public class P9 {
    public static void main(String[] args) {
        String file = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}