package model;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    Person client = new Person("Sydney", "Biggar", "123-456-7890", new Address("123 House Rd.", "State College", Address.State.PA, "16801"), "email@email.com");
    Dog dog = new Dog("Tucker", Dog.Genders.Male, "Maltese/Poodle Mix", "Brown", LocalDate.of(2011, 07, 18), "Hip problems", Dog.Aggression.No, client);
    ArrayList<String> grooming_services = new ArrayList<>();
    Appointment app = new Grooming(dog, LocalDate.of(2023, 9, 20), grooming_services);

    @Test
    @Order(1)
    void getDog() {
        assertEquals("Dog{name='Tucker', lastName='Biggar', gender='Male', breed='Maltese/Poodle Mix', color='Brown', dob=Fri Aug 18 00:00:00 EDT 3911, health_problems='Hip problems', aggressive=false, owner=Person{firstName='Sydney', lastName='Biggar', phone number='123-456-7890', address='123 House Rd.', email='email@email.com'}}", app.getDog().toString());
    }

    @Test
    @Order(3)
    void setDog() {
        Dog newDog = new Dog("Scout", Dog.Genders.Female, "Yellow Lab", "Yellow", LocalDate.of(2003, 01, 1), "None", Dog.Aggression.No, client);
        System.out.println(newDog.toString());
        app.setDog(newDog);
        assertEquals("Dog{name='Scout', lastName='Biggar', gender='Female', breed='Yellow Lab', color='Yellow', dob=1-1-2003, health_problems='None', aggressive=false, owner=Person{firstName='Sydney', lastName='Biggar', phone number='123-456-7890', address='123 House Rd.', email='email@email.com'}}", app.getDog().toString());
    }

    @Test
    @Order(2)
    void getDropOffDate() {
        assertEquals(LocalDate.of(2023, 9, 20), app.getDropOffDate());

    }

    @Test
    @Order(4)
    void setDropOffDate() {
        app.setDropOffDate(LocalDate.of(2023, 9, 22));
        assertEquals(LocalDate.of(2023, 9, 22), app.getDropOffDate());
    }

    @Test
    void testToString() {
        String expected = "Grooming{dog=Dog{name='Tucker', lastName='Biggar', gender='Male', breed='Maltese/Poodle Mix', color='Brown', dob=Fri Aug 18 00:00:00 EDT 3911, health_problems='Hip problems', aggressive=false, owner=Person{firstName='Sydney', lastName='Biggar', phone number='123-456-7890', address='123 House Rd.', email='email@email.com'}}, date=9-22-2023}";
        assertEquals(expected, app.toString());
    }
}