package Day2_JSON.Handson_Practice_Problems.Filter_JSON_data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonWithJackson {
    public static void main(String[] args) {
        String jsonData = "["
                + "{\"id\": 1, \"name\": \"John Doe\", \"age\": 30},"
                + "{\"id\": 2, \"name\": \"Alice Smith\", \"age\": 22},"
                + "{\"id\": 3, \"name\": \"Bob Johnson\", \"age\": 28}"
                + "]";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(jsonData);

            List<JsonNode> filteredUsers = new ArrayList<>();

            for (JsonNode user : jsonArray) {
                if (user.get("age").asInt() > 25) {
                    filteredUsers.add(user);
                }
            }

            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredUsers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
