package controller;

import model.Person;
import view.ClientView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientController implements ActionListener {

    private ClientView clientView;
    private List<Person> clients = new ArrayList<>();
    private ClientListController clientListController;
    int currentIndex;


    /*public ClientController() {
        this.clientView = new ClientView(this);
        addActionListerners();
        createInitialElements();
    }*/

    public ClientController(ClientListController clientListController, int selectedRow) {
        this.clientListController = clientListController;
        this.clients = clientListController.getClients();
        Person selectedClient = clients.get(selectedRow);
        this.clientView = new ClientView(this, selectedClient);
        this.currentIndex = selectedRow;
        addActionListeners();
    }
    public ClientController(ClientListController clientListController) {
        this.clientListController = clientListController;
        this.clients = clientListController.getClients();
        Person selectedClient = clients.get(0);
        this.clientView = new ClientView(this, selectedClient);
        this.currentIndex = 0;
        addActionListeners();
    }
    public void addActionListeners() {
        clientView.getAddButton().addActionListener(this);
        clientView.getNextButton().addActionListener(this);
        clientView.getPreviousButton().addActionListener(this);
        clientView.getUpdateButton().addActionListener(this);
        clientView.getDeleteButton().addActionListener(this);
        clientView.getClearButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionSource = (JButton)e.getSource();
        if (actionSource == clientView.getAddButton()) {
            //checkIndex();
            //clientView.displayButton("submit");
            clientView.clearFields();
            //clientView.hideButton("update");
            //clientView.hideButton("add");
        }

        if (actionSource == clientView.getSubmitButton()) {
            Person newClient = clientView.createClient();
            clients.add(newClient);
            System.out.println("There are " + clients.size() + " clients in the list");
            currentIndex = clients.indexOf(newClient);
            System.out.println("currentIndex = " + currentIndex );
            System.out.println(newClient);
            //display message indicating the 'add' operation was successful
            clientView.setDisplayMessage(String.format("ADDED %s %s. \ncurrent index = ", newClient.getFirstName(), newClient.getLastName()) + currentIndex);
            //clientView.hideButton("submit");
            //clientView.displayButton("update");
            //clientView.displayButton("add");
            //checkIndex();
            clientView.displayClient(clients.get(currentIndex));
        }

        if (actionSource == clientView.getNextButton()) {
            //checkIndex();
            //take care of indexoutofBoundException
            if (currentIndex < clients.size() - 1) {
                currentIndex = currentIndex + 1;
                clientView.displayClient(clients.get(currentIndex));
                clientView.setDisplayMessage("currentIndex = " + currentIndex);
            }
            else {
                clientView.displayClient(clients.get(currentIndex));
            }
        }
        if (actionSource == clientView.getPreviousButton()) {
            //checkIndex();
            //to avoid indexoutofBoundException, do not allow the navigation to go outside of the collection
            if (currentIndex > 0) {
                //navigate the collection
                currentIndex = currentIndex -1;
                clientView.displayClient(clients.get(currentIndex));
                clientView.setDisplayMessage("currentIndex = " + currentIndex);
            }
            else {
                clientView.displayClient(clients.get(currentIndex));
            }
        }

        if (actionSource == clientView.getUpdateButton()) {
            //checkIndex();
            //check for null, and other data validations
            Person updatedClient = clientView.createClient();
            clients.set(currentIndex, updatedClient);
            clientView.setDisplayMessage("updated client. \ncurrent index = " + currentIndex);
            //consider all scenarios when this button will be activated - eg. clear all fields and then update?
        }
        if (actionSource == clientView.getDeleteButton()) {
            //checkIndex();
            clients.remove(currentIndex);
            currentIndex = currentIndex -1;
            if (clients.size() >= 0) {
                clientView.displayClient(clients.get(currentIndex));
            }
            else {
                clientView.clearFields();
            }
            //be mindful of the current index
            clientView.setDisplayMessage("DELETED client. \ncurrent index = " + currentIndex);
        }
        //clear all the fields on ui before creating new instrument
        if (actionSource == clientView.getClearButton()) {
            clientView.clearFields();
        }
    }

    /*public void checkIndex() {
        if (currentIndex == 0) {
            clientView.hideButton("previous");
            clientView.displayButton("next");
        }
        else if (currentIndex == clients.size() - 1) {
            clientView.hideButton("next");
            clientView.displayButton("previous");
        }
        else if (currentIndex > 0 && currentIndex < clients.size() - 1) {
            clientView.displayButton("previous");
            clientView.displayButton("next");
        }
        else if (currentIndex == -1) {
            clientView.hideButton("previous");
            clientView.displayButton("next");
        }
    }*/

    public void displayClient(int index) {
        if (index == -1) {
            clientView.clearFields();
        }
        else {
            Person previousClient = clients.get(index);
            clientView.displayClient(previousClient);
            clientView.setDisplayMessage("");
        }
    }

    /*public void createInitialElements() {
        Person client1 = new Person("Abby", "Biggar", "1234567890", new Address("32 Road St.", "State College", Address.State.PA, "16801"), "abby@gmail.com");
        Person client2 = new Person("Adina", "Brenner", "3213213333", new Address("12 House Rd.", "State College", Address.State.PA, "16801"), "adina@gmail.com");
        Person client3 = new Person("Tommy", "Biggar", "4325567891", new Address("11 Frat Rd.", "State College", Address.State.PA, "16801"), "tommy@gmail.com");
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        currentIndex = 0;//go to the first element
        displayClient(0);
        clientView.setDisplayMessage("");
        clientView.hideButton("submit");
        clientView.hideButton("previous");

    }*/

}
