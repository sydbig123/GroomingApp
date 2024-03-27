package model;

import java.io.Serializable;

public class Person implements Printable, Serializable {
    private String firstName;
    private String lastName;
    private String number;  //phone number
    private Address address;
    private String email;

    public Person() {
    }

    public Person(String firstName, String lastName, String number, Address address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.address = address;
        this.email = email;
    }

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }
    public Address setAddress(String street, String city, Address.State state, String zip) {
        return new Address(street, city, state, zip );
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public void BasicDetails() {
        System.out.println("Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone number='" + number + '\'' +
                '}');
    }

    @Override
    public void AllDetails() {
        System.out.println(this.toString());
    }

}

