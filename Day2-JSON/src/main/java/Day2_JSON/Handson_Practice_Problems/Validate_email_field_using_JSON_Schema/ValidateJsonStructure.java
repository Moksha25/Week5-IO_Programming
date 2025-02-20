package Day2_JSON.Handson_Practice_Problems.Validate_email_field_using_JSON_Schema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJsonStructure {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Alice\", \"age\": 25 }";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(json);

            if (rootNode.has("name") && rootNode.has("age")) {
                System.out.println("Valid JSON structure.");
            } else {
                System.out.println("Invalid JSON structure: Missing required fields.");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + e.getMessage());
        }
    }
}