import java.io.*;

public class P4 {
    public static void main(String[] args) {
        String file = "students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // header
            System.out.println(line);
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Double.parseDouble(data[3]) > 80) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}