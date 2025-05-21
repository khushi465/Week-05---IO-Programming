import java.io.*;
import java.util.*;

public class P6 {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!isHeader && data[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    data[3] = String.valueOf(salary * 1.10);
                }
                isHeader = false;
                bw.write(String.join(",", data));
                bw.newLine();
            }
            System.out.println("Updated salaries written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}