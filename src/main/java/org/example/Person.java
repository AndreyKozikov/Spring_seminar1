package org.example;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    //region commons-lang3
    // Используем commons-lang3 для методов toString, equals и hashCode
    //метод создает строковое представление объекта, включая значения всех его полей,
    // без необходимости вручную перечислять их в коде.
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false; //сравниваемый объект не является null
        if (obj == this) return true; //проверка ссылки на тот же объект в памяти
        if (obj.getClass() != getClass()) return false; //проверка, что сравниваемые объекты имеют один класс
        Person other = (Person) obj; //приводим объект к типу Person
        return new EqualsBuilder().append(firstName, other.firstName).append(lastName, other.lastName).append(age, other.age).isEquals(); //Сравнение по полям объектов
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder() //Создание объекта HashCodeBuilder
                .append(firstName) //Добавление полей
                .append(lastName)
                .append(age)
                .toHashCode(); //Генерация итогового хеша
    }
    //endregion

    //region Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //endregion

    //region Cериализация и десериализация Person
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    // Метод для десериализации JSON в объект Person
    public static Person fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Person.class);
    }

    //endregion
}
