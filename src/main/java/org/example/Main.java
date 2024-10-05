package org.example;

public class Main {
    public static void main(String[] args) {
        // Создание объекта Person
        Person person = new Person("John", "Doe", 30);

        // Сериализация объекта Person в JSON
        String json = person.toJson();
        System.out.println("Serialized to JSON: " + json);

        // Десериализация JSON обратно в объект Person
        Person deserializedPerson = Person.fromJson(json);
        System.out.println("Deserialized from JSON: " + deserializedPerson);

        // Использование методов toString, equals и hashCode
        Person anotherPerson = new Person("John", "Doe", 30);
        System.out.println("Результат сравнения объектов до и после сериализации " + person.equals(anotherPerson));
        System.out.println("HashCode: " + person.hashCode());
        System.out.println("Person details: " + person);
    }
}
