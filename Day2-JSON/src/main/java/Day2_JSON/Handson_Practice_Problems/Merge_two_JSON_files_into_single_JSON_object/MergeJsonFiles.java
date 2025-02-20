package Day2_JSON.Handson_Practice_Problems.Merge_two_JSON_files_into_single_JSON_object;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode json1 = objectMapper.readTree(new File("src/main/resources/file1.json")); // Ensure file1.json exists
            JsonNode json2 = objectMapper.readTree(new File("src/main/resources/file2.json")); // Ensure file2.json exists

            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            System.out.println("Merged JSON:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
        } catch (IOException e) {
            System.out.println("Error merging JSON files: " + e.getMessage());
        }
    }
}
