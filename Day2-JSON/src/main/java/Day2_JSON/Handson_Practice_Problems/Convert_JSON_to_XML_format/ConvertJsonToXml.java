package Day2_JSON.Handson_Practice_Problems.Convert_JSON_to_XML_format;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class ConvertJsonToXml {
    public static void main(String[] args) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode jsonNode = jsonMapper.readTree(new File("src/main/resources/resource.json"));

            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(jsonNode);

            System.out.println("Converted XML:\n" + xml);
        } catch (IOException e) {
            System.out.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
}