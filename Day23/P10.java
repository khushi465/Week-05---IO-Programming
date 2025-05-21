import java.io.*;
import java.util.*;

public class P10 {
    public static void main(String[] args) {
        String file1 = "students1.csv"; // ID, Name, Age
        String file2 = "students2.csv"; // ID, Marks, Grade
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentData = new HashMap<>();
        
        // Reading first file (students1.csv)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                studentData.put(data[0], data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading second file (students2.csv)
        try (BufferedReader br = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String header = "ID,Name,Age,Marks,Grade";
            bw.write(header);
            bw.newLine();
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (studentData.containsKey(id)) {
                    String[] studentDetails = studentData.get(id);
                    bw.write(String.join(",", studentDetails[0], studentDetails[1], studentDetails[2], data[1], data[2]));
                    bw.newLine();
                }
            }
            System.out.println("Merged file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
