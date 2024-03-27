package controller;

import model.Address;
import model.Dog;
import model.Person;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DogPersistenceController {
    private List<Dog> dogs = new ArrayList<>();
    private String fileName = "DogFile.txt";

    public DogPersistenceController() {
        readDogFile();
        if (dogs.isEmpty()) {
            createInitialElements();
            writeDogFile();
        }
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void writeDogFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(dogs);
            out.close();
            System.out.println("successful in writing data to file");
        }
        catch (IOException e) {
            System.out.println("caught exception while writing to file: " + e.getMessage());
        }
    }

    public void readDogFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            dogs = (ArrayList) in.readObject();
            in.close();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("caught exception while reading from file: " + e.getMessage());
        }
        System.out.println("successful in reading from file");
    }

    public void createInitialElements() {
        Person charlie = new Person("Charlie", "Brown", "321-321-3210", new Address("123 House Rd.", "State College", Address.State.PA, "16801"), "charlie@email.com");
        Person shaggy = new Person("Shaggie", "Doo", "123-456-7890", new Address("123 College Rd.", "State College", Address.State.PA, "16801"), "shaggie@email.com");
        Person dorothy = new Person("Dorothy", "Gale", "301-111-2313", new Address("123 Home St.", "Newark", Address.State.KS, "19716"), "dorothy@email.com");

        Dog dog1 = new Dog("Snoopy", Dog.Genders.Male, "Beagle", "White", Dog.Size.Medium, LocalDate.of(2015, 8, 10), "None", Dog.Aggression.No, charlie);
        Dog dog2 = new Dog("Scooby", Dog.Genders.Male, "Great Dane", "Brown", Dog.Size.Large, LocalDate.of(2000, 01, 01), "None", Dog.Aggression.No, shaggy);
        Dog dog3 = new Dog("Toto", Dog.Genders.Male, "Terrier", "Black", Dog.Size.Small, LocalDate.of(2000, 01, 01), "None", Dog.Aggression.No, dorothy);
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
    }

}
