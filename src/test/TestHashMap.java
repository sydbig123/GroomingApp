package test;

import controller.HashMapController;
import model.Address;
import model.Dog;
import model.Person;

import java.time.LocalDate;
import java.util.List;

public class TestHashMap {

    public TestHashMap() {
        testHashMap();
    }
    public void testHashMap() {
        HashMapController hashMapController = new HashMapController();

        Address address = new Address("123 House Rd.", "State College", Address.State.PA, "16801");
        Person newPerson = new Person("Glen", "Stanley", "1234567890", address, "email@email.com");
        Dog newDog = new Dog("Hobbes", Dog.Genders.Male , "Black Lab", "Black", Dog.Size.Large, LocalDate.of(2005, 01, 01), "None", Dog.Aggression.Yes, newPerson);
        hashMapController.addPerson(newPerson, newDog);
        System.out.println("\nadded new Instrument to inventory----");
        hashMapController.printCollection();

        Person person3 = new Person("Michael", "Heeg", "1234567890", address, "email@email.com");
        Dog newDog2 = new Dog("Sam", Dog.Genders.Male , "Papillion", "White", Dog.Size.Small, LocalDate.of(2010, 01, 01), "None", Dog.Aggression.No, person3);
        hashMapController.updateMap(person3, newDog2);


        String searchTerm = "mix";
        System.out.println("\nsearching for " + searchTerm + " ----------");
        List<Person> searchResults = hashMapController.searchCollection(searchTerm);
        System.out.println(searchResults);

        System.out.println("\ndeleting instrument ----------");
        //make sure to check null, empty, outOfBounds exception before accessing the searchResults collection element
        hashMapController.removePerson(searchResults.get(0));
        hashMapController.printCollection();

    }

}
