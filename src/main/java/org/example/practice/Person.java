package org.example.practice;

public class Person {
    private String name;
    private Address address;

    public Person(Person originalPerson) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
