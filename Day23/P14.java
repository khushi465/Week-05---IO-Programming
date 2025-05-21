import java.io.*;
import org.json.*;
import java.util.*;

public class P14 {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";

        // Convert JSON to CSV
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

            String jsonString = br.readLine();
            JSONArray jsonArray = new JSONArray(jsonString);

            // Write header
            bw.write("ID,Name,Age,Marks");
            bw.newLine();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject student = jsonArray.getJSONObject(i);
                bw.write(student.getString("id") + ","
                        + student.getString("name") + ","
                        + student.getInt("age") + ","
                        + student.getDouble("marks"));
                bw.newLine();
            }
            System.out.println("CSV file created from JSON.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        // Convert CSV to JSON
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter("students_back.json"))) {

            JSONArray jsonArray = new JSONArray();
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject student = new JSONObject();
                student.put("id", data[0]);
                student.put("name", data[1]);
                student.put("age", Integer.parseInt(data[2]));
                student.put("marks", Double.parseDouble(data[3]));
                jsonArray.put(student);
            }

            bw.write(jsonArray.toString());
            System.out.println("JSON file created from CSV.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}