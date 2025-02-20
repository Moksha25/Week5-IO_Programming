package Day2_JSON.Handson_Practice_Problems.Generate_JSON_report_from_database_records;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;

public class GenerateJsonReport {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        String query = "SELECT id, name, email, department FROM employees";

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("email", rs.getString("email"));
                jsonObject.put("department", rs.getString("department"));
                jsonArray.add(jsonObject);
            }

            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray);
            System.out.println("Generated JSON Report:\n" + jsonOutput);


            File file = new File("employee_report.json");
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(jsonOutput);
                System.out.println("JSON Report saved as 'employee_report.json'");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
