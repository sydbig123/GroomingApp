package controller;

import model.Address;
import model.Dog;
import model.Order;
import model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GroomingQueue {

    private LocalDate date; //The date that this queue will be groomed
    private LinkedList<Order> groomingOrder = new LinkedList<Order>();

    public GroomingQueue(LocalDate date){
        this.date = date;
        this.buildGroomingQueue();
        this.printGroomingQueue();
    }

    public void buildGroomingQueue() {

        Address address = new Address("123 House Rd.", "State College", Address.State.PA, "16801");
        Person client1 = new Person("Sydney", "Biggar", "1234567890", address, "email@email.com");
        Person client2 = new Person("Michael", "Heeg", "1234567890", address, "email@email.com");
        Person client3 = new Person("Dora", "Explorer", "1234567890", address, "email@email.com");
        Person client4 = new Person("Glen", "Stanley", "1234567890", address, "email@email.com");


        Dog dog1 = new Dog("Tucker", Dog.Genders.Male , "Maltese/Poodle Mix", "Brown", Dog.Size.Small, LocalDate.of(2011, 01, 17), "None", Dog.Aggression.Unknown, client1);
        Order order1 = new Order(dog1);

        Dog dog2 = new Dog("Scout", Dog.Genders.Female , "Yellow Lab", "Yellow", Dog.Size.Large, LocalDate.of(2007, 01, 01), "None", Dog.Aggression.No, client2);
        Order order2 = new Order(dog2);

        Dog dog3 = new Dog("Hobbes", Dog.Genders.Male , "Black Lab", "Black", Dog.Size.Large, LocalDate.of(2005, 01, 01), "None", Dog.Aggression.Yes, client4);
        Order order3 = new Order(dog3);

        Dog dog4 = new Dog("Sam", Dog.Genders.Female , "Papillion", "White", Dog.Size.Small, LocalDate.of(2010, 01, 01), "None", Dog.Aggression.No, client2);
        Order order4 = new Order(dog4);

        Dog dog5 = new Dog("Dunkin", Dog.Genders.Male , "Dachshund", "Brown", Dog.Size.Medium, LocalDate.of(2009, 01, 01), "None", Dog.Aggression.No, client3);
        Order order5 = new Order(dog5);

        Dog dog6 = new Dog("Buttons", Dog.Genders.Male , "Papullion", "White", Dog.Size.Small, LocalDate.of(2009, 01, 01), "None", Dog.Aggression.Yes, client2);
        Order order6 = new Order(dog6);

        addOrder(order1);
        addOrder(order2);
        addOrder(order3);
        addOrder(order4);
        addOrder(order5);
        addOrder(order6);
    }

    public void rebuildGroomingQueue() {
        LinkedList<Order> oldGroomingOrder = new LinkedList<>();
        oldGroomingOrder.addAll(groomingOrder);
        groomingOrder.clear();

        List<Order> results = new ArrayList<>();
        ListIterator<Order> orderIterator = oldGroomingOrder.listIterator();
        while(orderIterator.hasNext()){
            Order currentElement = orderIterator.next();
            addOrder(currentElement);
        }
    }

    public void printGroomingQueue() {
        ListIterator orderIterator = groomingOrder.listIterator();
        while(orderIterator.hasNext()){
            System.out.println(orderIterator.next().toString());
        }
    }

    public void addOrder(Order newOrder){
        boolean orderAdded = false;
        boolean insertDecision = false;
        ListIterator<Order> orderIterator = groomingOrder.listIterator();
        while(orderIterator.hasNext()){
            insertDecision = orderIterator.next().decideToInsert(newOrder);
            if (insertDecision) {
                groomingOrder.add(orderIterator.previousIndex(), newOrder);
                orderAdded = true;
                break;
            }
        }
        if(orderAdded == false){
            groomingOrder.add(newOrder);
        }
    }

    //add item
    public void addItem(Dog dog) {
        addOrder(new Order(dog));
        rebuildGroomingQueue();
    }


    //get item
    public List<Order> searchItem(String name) {
        List<Order> results = new ArrayList<>();
        ListIterator<Order> orderIterator = groomingOrder.listIterator();
        while(orderIterator.hasNext()){
            Order currentElement = orderIterator.next();
            if (currentElement.getDog().getName().equals(name)) {
                results.add(currentElement);
            }
        }
        System.out.println("Search results: " + results);
        return results;
    }


    //update
    public void updateItem(String fName, String lName, int priority) {
        List<Order> results = new ArrayList<>();
        Dog dog;
        boolean found = false;
        String msg = "Dog not found";
        ListIterator<Order> orderIterator = groomingOrder.listIterator();
        while(orderIterator.hasNext()){
            Order currentElement = orderIterator.next();
            if (currentElement.getDog().getName().equals(fName) && currentElement.getDog().getLastName().equals(lName)) {
                results.add(currentElement);
                found = true;
                currentElement.setOrderPriority(priority);
            }
        }
        if (found) {
            msg = String.format("Order priority updated to %d for %s %s", priority, fName, lName);
            rebuildGroomingQueue();
        }
        System.out.println(msg);
    }


    //remove
    public void removeItem(String fName, String lName) {
        ListIterator<Order> orderIterator = groomingOrder.listIterator();
        Object deleteThis = null;
        while(orderIterator.hasNext()){
            Order currentElement = orderIterator.next();

            if (currentElement.getDog().getName().equals(fName) && currentElement.getDog().getLastName().equals(lName)) {
                deleteThis = currentElement;
                System.out.println("Appointment removed: " + deleteThis);
                groomingOrder.remove(deleteThis);
                return;
            }
        }
        System.out.println("Dog name not found to remove");
    }

    public void removeItem(Dog.Aggression aggression) {
        List<Order> results = new ArrayList<>();
        ListIterator<Order> orderIterator = groomingOrder.listIterator();
        while(orderIterator.hasNext()){
            Order currentElement = orderIterator.next();
            if (currentElement.getDog().getAggressive().equals(aggression)) {
                results.add(currentElement);
            }
        }
        System.out.println("Appointment(s) removed: " + results);
        for (Object obj: results) {
            groomingOrder.remove(obj);
        }
    }


}
