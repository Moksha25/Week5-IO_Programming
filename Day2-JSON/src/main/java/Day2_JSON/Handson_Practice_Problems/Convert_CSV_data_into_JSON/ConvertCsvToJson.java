package Day2_JSON.Handson_Practice_Problems.Convert_CSV_data_into_JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConvertCsvToJson {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/data.csv";
        String line;
        String[] headers = null;
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode jsonArray = objectMapper.createArrayNode();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (isFirstLine) {
                    headers = values;
                    isFirstLine = false;
                } else {
                    ObjectNode jsonObject = objectMapper.createObjectNode();
                    for (int i = 0; i < headers.length; i++) {
                        jsonObject.put(headers[i], values[i]);
                    }
                    jsonArray.add(jsonObject);
                }
            }
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonArray));
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}