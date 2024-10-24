package org.example.practice;

public class ShallowDeepCopy {

    public static void main(String[] args) {
        // Original object
        Person originalPerson = new Person("John", new Address("123 Main St"));

        // Shallow copy using copy constructor
        Person shallowCopyPerson = new Person(originalPerson);

        // Modifying the shallow copy
        shallowCopyPerson.setName("Jane");
        shallowCopyPerson.getAddress().setStreet("456 Side St");

        // Original object remains unchanged
        System.out.println("Original Person: " + originalPerson);
        System.out.println("Shallow Copy Person: " + shallowCopyPerson);
    }
}
