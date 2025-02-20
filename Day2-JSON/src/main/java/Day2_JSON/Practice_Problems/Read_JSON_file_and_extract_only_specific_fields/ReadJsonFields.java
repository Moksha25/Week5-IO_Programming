package Day2_JSON.Practice_Problems.Read_JSON_file_and_extract_only_specific_fields;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJsonFields {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resource/data.json")); // Ensure data.json exists

            String name = rootNode.path("name").asText();
            String email = rootNode.path("email").asText();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
