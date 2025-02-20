package Day2_JSON.Practice_Problems.Convert_list_of_Java_objects_into_JSON_array;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ListToJsonArray {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Person> people = new ArrayList<>();

            people.add(new Person("Alice", 28));
            people.add(new Person("Bob", 22));
            people.add(new Person("Charlie", 35));

            String jsonArray = objectMapper.writeValueAsString(people);


            System.out.println(jsonArray);
        } catch (Exception e) {
            System.out.println("Error converting list to JSON: " + e.getMessage());
        }
    }
}