import java.io.*;
import java.sql.*;

public class P13 {
    public static void main(String[] args) {
        String outputFile = "employees_report.csv";
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String header = "Employee ID,Name,Department,Salary";
            bw.write(header);
            bw.newLine();

            while (rs.next()) {
                String id = rs.getString("employee_id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                String row = id + "," + name + "," + department + "," + salary;
                bw.write(row);
                bw.newLine();
            }

            System.out.println("CSV report generated: " + outputFile);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
