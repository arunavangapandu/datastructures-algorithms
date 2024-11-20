package com.pass.by.value;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}
public class PassByReference {

    public static void modifyObject(Person person) {
        person.name = "new name";
    }

    public static void reassignObject(Person person) {
        person = new Person("I am new object");
    }

    public static void main(String[] args) {
        Person person = new Person("Raj");
        modifyObject(person);
        System.out.println(person.name);
        reassignObject(person);
        System.out.println(person.name);
    }
}
