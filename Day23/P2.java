
import java.io.*;
import java.util.*;

public class P2 {
    public static void main(String[] args) {
        String file = "employees.csv";
        List<String[]> data = Arrays.asList(
            new String[]{"ID", "Name", "Department", "Salary"},
            new String[]{"E01", "Alice", "HR", "60000"},
            new String[]{"E02", "Bob", "IT", "75000"},
            new String[]{"E03", "Charlie", "Finance", "68000"},
            new String[]{"E04", "Diana", "IT", "82000"},
            new String[]{"E05", "Eve", "Marketing", "72000"}
        );

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
