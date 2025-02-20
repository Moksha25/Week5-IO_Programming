package Day2_JSON.Handson_Practice_Problems.Convert_list_of_Java_objects_into_JSON_array;

class User {
    private int id;
    private String name;
    private String email;

    // Constructor
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters (Jackson requires getters to serialize)
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}