package controller;

import model.Address;
import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonPersistenceController {

    private List<Person> clients = new ArrayList<>();
    private String fileName = "PersonFile.txt";

    public PersonPersistenceController() {
        readClientFile();
        if (clients.isEmpty()) {
            createInitialElements();
            writeClientFile();
        }
    }

    public List<Person> getClients() {
        return clients;
    }

    public void writeClientFile() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(clients);
            out.close();
            System.out.println("successful in writing data to file");
        } catch (IOException e) {
            System.out.println("caught exception while writing to file: " + e.getMessage());
        }
    }

    public void readClientFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            clients = (ArrayList) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("caught exception while reading from file: " + e.getMessage());
        }
        System.out.println("successful in reading from file");
    }

    public void createInitialElements() {
        Person client1 = new Person("Abby", "Biggar", "321-321-3210", new Address("123 House Rd.", "State College", Address.State.PA, "16801"), "abby@email.com");
        Person client2 = new Person("Sydney", "Smith", "123-456-7890", new Address("123 College Rd.", "State College", Address.State.PA, "16801"), "sydney@email.com");
        Person client3 = new Person("Adina", "Brenner", "301-111-2313", new Address("123 Home St.", "Newark", Address.State.DE, "19716"), "adina@email.com");
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
    }

}
