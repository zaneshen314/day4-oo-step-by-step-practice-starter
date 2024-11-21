package oo;

import java.util.Objects;

public class Person {
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.introduceWords = "My name is " + this.name + ". I am " + this.age + " years old.";
    }

    protected int id;

    public String getName() {
        return name;
    }

    protected String name;
    protected int age;
    protected String introduceWords;
    public String introduce() {
        return this.introduceWords;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
