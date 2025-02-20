package Day2_JSON.Handson_Practice_Problems.Read_JSON_file_and_print_all_keys_and_values;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/data.json"));

            printJsonKeysAndValues(rootNode, "");
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    private static void printJsonKeysAndValues(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<String> fieldNames = node.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                printJsonKeysAndValues(node.get(fieldName), prefix + fieldName + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJsonKeysAndValues(node.get(i), prefix + "[" + i + "].");
            }
        } else {
            System.out.println(prefix.substring(0, prefix.length() - 1) + " : " + node.asText());
        }
    }
}