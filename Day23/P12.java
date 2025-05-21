import java.io.*;
import java.util.*;

public class P12 {
    public static void main(String[] args) {
        String file = "students.csv";
        Set<String> seenIds = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (!seenIds.add(id)) {
                    duplicates.add(line);
                }
            }

            System.out.println("Duplicate records:");
            duplicates.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
