package Day2_JSON.Practice_Problems.Convert_Java_object_into_JSON_format;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertCarToJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Toyota", "Camry", 2022);
        String json = objectMapper.writeValueAsString(car);
        System.out.println(json);
    }
}
