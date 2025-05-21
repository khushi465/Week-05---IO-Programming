import java.io.*;

public class P3 {
    public static void main(String[] args) {
        String file = "students.csv";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // Skip header
            while (br.readLine() != null) {
                count++;
            }
            System.out.println("Total records: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}