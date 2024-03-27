package test;

import controller.GroomingQueue;
import model.Address;
import model.Dog;
import model.Person;

import java.time.LocalDate;

public class TestLinkedList {
    public TestLinkedList() {
        testGroomingPriorities();
    }

    public void testGroomingPriorities() {
        GroomingQueue groomingQueue = new GroomingQueue(LocalDate.of(2023, 12, 6)); //add
        groomingQueue.searchItem("Tucker");     //get: searches for the name Tucker in the list

        groomingQueue.updateItem("Scout", "Heeg", 1);       //update: changes the priority for Scout Heeg
        System.out.println("\nNew order:");
        groomingQueue.printGroomingQueue();


        System.out.println("\n");
        groomingQueue.removeItem("Sam", "Heeg");        //removes the dog named Sam Heeg from the list
        groomingQueue.removeItem(Dog.Aggression.Yes);   //removes all the items where aggression = yes

        Person client = new Person("Lisa", "Mix", "567-567-5678", new Address("123 Dog Rd", "Bethesda", Address.State.MD, "34567"), "lisa@gmail.com");
        groomingQueue.addItem(new Dog("Mickey", Dog.Genders.Male , "Lab/Poodle Mix", "Black", Dog.Size.Large, LocalDate.of(2004, 01, 01), "None", Dog.Aggression.No, client));      //adds new dog to the list
        System.out.println("\nNew order:");
        groomingQueue.printGroomingQueue();
    }
}
