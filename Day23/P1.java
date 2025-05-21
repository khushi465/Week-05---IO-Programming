import java.io.*;

public class P1 {
    public static void main(String[] args) {
        String file = "students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n",
                                  data[0], data[1], data[2], data[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}