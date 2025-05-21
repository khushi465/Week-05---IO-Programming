import java.io.*;

public class P11 {
    public static void main(String[] args) {
        String file = "large_students.csv";
        int count = 0;
        int chunkSize = 100;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                if (count % chunkSize == 0) {
                    System.out.println("Processed " + chunkSize + " records...");
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

