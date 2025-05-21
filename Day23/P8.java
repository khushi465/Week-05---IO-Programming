import java.io.*;
import java.util.regex.*;

public class P8 {
    public static void main(String[] args) {
        String file = "contacts.csv";
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String email = data[2];
                String phone = data[3];
                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid email: " + line);
                } else if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid phone: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}