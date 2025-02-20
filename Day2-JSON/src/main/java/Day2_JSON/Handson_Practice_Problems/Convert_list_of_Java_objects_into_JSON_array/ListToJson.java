package Day2_JSON.Handson_Practice_Problems.Convert_list_of_Java_objects_into_JSON_array;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.ArrayList;
import java.util.List;

public class ListToJson {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe", "john@example.com"));
        users.add(new User(2, "Alice Smith", "alice@example.com"));

        try {
            // Convert List to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            String jsonArray = writer.writeValueAsString(users);

            // Print JSON
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}