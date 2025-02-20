package Day2_JSON.Practice_Problems.Create_JSON_object_for_Student;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson
{
    public static void main(String[] args) {
        try{
            JSONObject student=new JSONObject();
            student.put("name","moksh");
            student.put("age",21);

            JSONArray  subjects=new JSONArray();
            subjects.put("Hindi");
            subjects.put("English");
            subjects.put("Computer Science");

            student.put("subjects",subjects);
            System.out.println(student.toString(2));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
