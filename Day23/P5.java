import java.io.*;
import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        String file = "employees.csv";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // Skip header
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equalsIgnoreCase(searchName)) {
                    System.out.printf("Department: %s, Salary: %s%n", data[2], data[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}