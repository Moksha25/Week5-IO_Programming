package Day2_JSON.Practice_Problems.Parse_JSON_and_filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonRecords {
    public static void main(String[] args) {

        String jsonArray = "["
                + "{ \"name\": \"Alice\", \"age\": 28 },"
                + "{ \"name\": \"Bob\", \"age\": 22 },"
                + "{ \"name\": \"Charlie\", \"age\": 30 }"
                + "]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonArray);
            List<JsonNode> filteredRecords = new ArrayList<>();

            for (JsonNode node : rootNode) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    filteredRecords.add(node);
                }
            }

            String filteredJson = objectMapper.writeValueAsString(filteredRecords);
            System.out.println("Filtered JSON: " + filteredJson);
        } catch (Exception e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
    }
}