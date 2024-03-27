package controller;

import model.Address;
import model.ClientTableModel;
import model.Person;
import view.ClientListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientListController implements ActionListener {
    private ClientListView clientListView;
    List<Person> clients = new ArrayList<>();
    ClientTableModel clientTableModel;
    ClientController clientController;
    PersonPersistenceController personPersistenceController;

    public ClientListController() {
        this.personPersistenceController = new PersonPersistenceController();
        clients = personPersistenceController.getClients();
        this.clientTableModel = new ClientTableModel(clients);
        this.clientListView = new ClientListView(this);
        addActionListeners();
    }

    public ClientTableModel getClientTableModel() {
        return clientTableModel;
    }

    public List<Person> getClients() {
        return clients;
    }

    public PersonPersistenceController getPersonPersistenceController() {
        return personPersistenceController;
    }

    /*public void createInitialElements() {
        Person client1 = new Person("Sydney", "Biggar", "123-456-7890", new Address("123 House Rd.", "State College", Address.State.PA, "16801"), "email@email.com");
        Person client2 = new Person("Abby", "Biggar", "321-321-3210", new Address("123 Address Rd.", "Georgetown", Address.State.MD, "20066"), "myemail@email.com");
        Person client3 = new Person("Adina", "Brenner", "301-521-5521", new Address("16 Pumpkin Rd.", "Newark", Address.State.DE, "54654"), "adinasemail@email.com");
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
    }*/

    public void addActionListeners() {
        clientListView.getNewClientBtn().addActionListener(this);
        clientListView.getDetailsBtn().addActionListener(this);
        clientListView.getDoneBtn().addActionListener(this);
        clientListView.getDogListBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clientListView.getNewClientBtn()) {
            this.clientController = new ClientController(this, 0);

            //make sure to clear the fields on the details view
            this.clientController.displayClient(-1);
        }
        if (e.getSource() == clientListView.getDetailsBtn()) {
            clientListView.dispose();
            //find the selected row

            int selectedRow = clientListView.getClientTable().getSelectedRow();
            if (selectedRow == -1) {
                selectedRow = 0;
            }
            System.out.println("selectedRow = " + selectedRow);
            //if no row is selected on the list, set it to show first element on the details view
            //show a detail view with the data for the selected element
            //pass the flow from list controller to details controller
            //do not instantiate the details view from this list controller
            this.clientController = new ClientController(this, selectedRow);

        }
        if (e.getSource() == clientListView.getDoneBtn()) {
            System.exit(0);
        }
        if (e.getSource() == clientListView.getDogListBtn()) {
            clientListView.dispose();
            //int selectedRow = clientListView.getClientTable().getSelectedRow();
            //Person selectedClient = clients.get(selectedRow);
            //DogController dogController = new DogController(selectedClient);
            new DogListController();
        }
    }

    //new method to show the list view
    public void showListView() {
        this.clientListView.setVisible(true);
    }

}
