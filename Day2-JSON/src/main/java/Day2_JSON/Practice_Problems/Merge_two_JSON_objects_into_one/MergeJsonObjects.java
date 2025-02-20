package Day2_JSON.Practice_Problems.Merge_two_JSON_objects_into_one;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJsonObjects {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // JSON Strings
            String json1 = "{ \"name\": \"John\", \"age\": 30 }";
            String json2 = "{ \"email\": \"john@example.com\", \"city\": \"New York\" }";

            // Parse JSON strings into JsonNode
            JsonNode node1 = objectMapper.readTree(json1);
            JsonNode node2 = objectMapper.readTree(json2);

            // Merge JSON objects
            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) node1);
            mergedNode.setAll((ObjectNode) node2);

            // Convert merged JSON back to string
            String mergedJson = objectMapper.writeValueAsString(mergedNode);
            System.out.println("Merged JSON: " + mergedJson);
        } catch (Exception e) {
            System.out.println("Error merging JSON: " + e.getMessage());
        }
    }
}