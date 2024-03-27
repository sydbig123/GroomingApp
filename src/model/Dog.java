package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Dog implements Serializable {
    private String name;
    private String lastName;
    private Genders gender;
    public enum Genders {Female, Male}
    private String breed;
    private String color;
    private LocalDate dob;
    private String health_problems;
    private Aggression aggressive;     //are they aggressive?
    public enum Aggression {Unknown, Yes, No}
    private Size size;      //size of dog
    public enum Size {Small, Medium, Large}
    private Person owner;

    public Dog(String name, Genders gender, String breed, String color, Size size, LocalDate dob, String health_problems, Aggression aggressive, Person owner) {
        this.name = name;
        this.lastName = owner.getLastName();
        this.gender = gender;
        this.breed = breed;
        this.color = color;
        this.size = size;
        this.dob = dob;
        this.health_problems = health_problems;
        this.aggressive = aggressive;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {        //is set by owner's last name - this is called in setOwner
        this.lastName = lastName;
    }

    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {return size;}

    public void setSize(Size size) {this.size = size;}

    public LocalDate getDob() { return dob; }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getHealth_problems() {
        return health_problems;
    }

    public void setHealth_problems(String health_problems) {
        this.health_problems = health_problems;
    }

    public Aggression getAggressive() {
        return aggressive;
    }

    public void setAggressive(Aggression aggressive) {
        this.aggressive = aggressive;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
        setLastName(owner.getLastName());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", breed='" + breed + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", dob=" + dob +
                ", health_problems='" + health_problems + '\'' +
                ", aggressive=" + aggressive +
                ", owner=" + owner.getFirstName() + " " + owner.getLastName() +
                '}';
    }
}

