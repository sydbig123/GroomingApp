package controller;

import model.Dog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DogPersistenceController {
    private List<Dog> dogs = new ArrayList<>();
    private String fileName = "DogFile3.txt";

    public DogPersistenceController() {
        readDogFile();
        if (dogs.isEmpty()) {
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
        } catch (IOException e) {
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
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("caught exception while reading from file: " + e.getMessage());
        }
        System.out.println("successful in reading from file");
    }

}
