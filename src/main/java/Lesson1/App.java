package Lesson1;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe", 30);

        // Сериализация в JSON
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(json);

        // Десериализация из JSON
        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println(deserializedPerson);
    }
}
