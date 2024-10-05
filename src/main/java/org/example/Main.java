package org.example;

/*
Создать проект с использованием Maven или Gradle, добавить в него несколько
зависимостей и написать код, использующий эти зависимости.
Пример решения:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или
блока 2.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и
com.google.code.gson:gson:2.8.6.
3. Создайте класс Person с полями frstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString,
equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов
класса Person в формат JSON.
 */

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
