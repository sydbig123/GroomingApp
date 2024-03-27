package test;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class TestHarness {

    public TestHarness() {
        testPerson();
        testDog();
        testClassHierarchy();
    }

    public void testPerson() {
        Address address = new Address("123 House Rd.", "State College", Address.State.PA, "16801");
        Person client = new Person("Sydney", "Biggar", "123-456-7890", address, "email@email.com");

        System.out.println(client.getFirstName());
        System.out.println(client.getLastName());
        System.out.println(client.getNumber());
        System.out.println(client.getAddress());
        System.out.println(client.getEmail());

        client.setFirstName("Abby");
        client.setLastName("Yamada");
        client.setNumber("321-321-3210");
        client.setAddress("123 House Rd.", "State College", Address.State.PA, "16801");
        client.setEmail("newemail@email.com");

        System.out.println(client.toString());
    }

    public void testDog() {
        Address address = new Address("123 House Rd.", "State College", Address.State.PA, "16801");
        Person client = new Person("Sydney", "Smith", "1234567890", address, "email@email.com");
        Dog dog = new Dog("Matthew", Dog.Genders.Female , "N/A", "Brown", Dog.Size.Medium, LocalDate.of(2011, 01, 01), "None", Dog.Aggression.Unknown, client);

        System.out.println(dog.getName());
        System.out.println(dog.getLastName());
        System.out.println(dog.getGender());
        System.out.println(dog.getBreed());
        System.out.println(dog.getColor());
        System.out.println(dog.getSize());
        System.out.println(dog.getDob());
        System.out.println(dog.getHealth_problems());
        System.out.println(dog.getAggressive());
        System.out.println(dog.getOwner());

        dog.setName("Tucker");
        dog.setGender(Dog.Genders.Male);
        dog.setBreed("Maltese/Poodle Mix");
        dog.setColor("Brown/white");
        dog.setSize(Dog.Size.Small);
        dog.setDob(LocalDate.of(07, 18, 2011));
        dog.setHealth_problems("Hip problems");
        dog.setAggressive(Dog.Aggression.No);
        Person client2 = new Person("Abby", "Biggar", "321-321-3210", address, "email@email.com");
        dog.setOwner(client2);

        System.out.println(dog.toString());
    }

    public void testClassHierarchy() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        Person client = new Person("Abby", "Biggar", "321-321-3210", new Address("123 House Rd.", "State College", Address.State.PA, "16801"), "email@email.com");
        Dog dog = new Dog("Tucker", Dog.Genders.Male, "Maltese/Poodle", "Brown/white", Dog.Size.Small, LocalDate.of(2011, 07, 17), "None", Dog.Aggression.No, client);

        Appointment app = new Appointment(dog, LocalDate.of(2023, 10, 5));
        ArrayList<String> grooming_services = new ArrayList<>();
        grooming_services.add("Bath");
        grooming_services.add("Brush");
        grooming_services.add("Trim nails");
        Appointment grooming = new Grooming(dog, LocalDate.of(2023, 10, 6), grooming_services);
        Appointment boarding = new Boarding(dog, LocalDate.of(2023, 10, 22), LocalDate.of(2023, 10, 27));
        appointments.add(app);
        appointments.add(grooming);
        appointments.add(boarding);
        for (Appointment a: appointments) {
            System.out.println(a.getAppointment_details());
        }
    }
}
