package controller;

import model.Address;
import model.Dog;
import model.Person;

import java.time.LocalDate;
import java.util.*;

public class HashMapController {
    Map<Person, List<Dog>> dogOwnerMap = new HashMap<>();

    public HashMapController() {
        createInitialCollection();
        printCollection();
    }

    private void createInitialCollection() {
        Address address = new Address("123 House Rd.", "State College", Address.State.PA, "16801");
        Person person1 = new Person("Lisa", "Mix", "567-567-5678", address, "lisa@gmail.com");
        Dog dog1 = new Dog("Mickey", Dog.Genders.Male , "Lab/Poodle Mix", "Black", Dog.Size.Large, LocalDate.of(2004, 01, 01), "None", Dog.Aggression.No, person1);
        ArrayList<Dog> dogs1 = new ArrayList<>();
        dogs1.add(dog1);
        dogOwnerMap.put(person1, dogs1);

        Person person2 = new Person("Sydney", "Biggar", "1234567890", address, "email@email.com");
        Dog dog2 = new Dog("Tucker", Dog.Genders.Male , "Maltese/Poodle Mix", "Brown", Dog.Size.Small, LocalDate.of(2011, 01, 17), "None", Dog.Aggression.Unknown, person2);
        ArrayList<Dog> dogs2 = new ArrayList<>();
        dogs2.add(dog2);
        dogOwnerMap.put(person2, dogs2);

        Person person3 = new Person("Michael", "Heeg", "1234567890", address, "email@email.com");
        Dog dog3 = new Dog("Scout", Dog.Genders.Female , "Yellow Lab", "Yellow", Dog.Size.Large, LocalDate.of(2007, 01, 01), "None", Dog.Aggression.No, person3);
        ArrayList<Dog> dogs3 = new ArrayList<>();
        dogs3.add(dog3);
        dogOwnerMap.put(person3, dogs3);
    }

    public void printCollection() {
        for (Map.Entry entry:dogOwnerMap.entrySet()) {
            System.out.println("entry: " + entry);
        }
    }

    public void addPerson(Person person, Dog dog) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog);
        dogOwnerMap.put(person, dogs);
    }

    public List<Person> searchCollection(String searchTerm) {
        List<Person> searchResults = new ArrayList<>();
        for (Map.Entry entry:dogOwnerMap.entrySet()) {
            Person person = (Person) entry.getKey();
            if (person.getLastName().toLowerCase().contains(searchTerm.toLowerCase()) || person.getFirstName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(person);
            }
        }
        return searchResults;
    }

    public void removePerson(Person person) {
        Iterator iterator = dogOwnerMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Person existingPerson = (Person)entry.getKey();
            if (existingPerson.getLastName().equals(person.getLastName()) && existingPerson.getLastName().equals(person.getLastName())) {
                iterator.remove();
            }
        }
    }

    public void updateMap(Person person, Dog dog) {
        Iterator iterator = dogOwnerMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Person existingPerson = (Person) entry.getKey();
            ArrayList<Dog> key = (ArrayList<Dog>) entry.getValue();
            if (person.getLastName().equals(existingPerson.getLastName()) && person.getFirstName().equals(existingPerson.getFirstName())) {
                ArrayList<Dog> dogs = new ArrayList<>();
                dogs.addAll(key);
                dogs.add(dog);

                dogOwnerMap.replace(existingPerson, key, dogs);
            }
        }
    }

}
