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
    private ClientListView listView;
    List<Person> clients = new ArrayList<>();
    ClientTableModel clientTableModel;
    ClientController clientController;
    //PersonPersistenceController personPersistenceController;

    public ClientListController() {
        createInitialElements();
        this.clientTableModel = new ClientTableModel(clients);
        this.listView = new ClientListView(this);
        addActionListeners();
    }

    public ClientTableModel getClientTableModel() {
        return clientTableModel;
    }

    public List<Person> getClients() {
        return clients;
    }

    public void createInitialElements() {
        Person client1 = new Person("Sydney", "Biggar", "123-456-7890", new Address("123 House Rd.", "State College", Address.State.PA, "16801"), "email@email.com");
        Person client2 = new Person("Abby", "Biggar", "321-321-3210", new Address("123 Address Rd.", "Georgetown", Address.State.MD, "20066"), "myemail@email.com");
        Person client3 = new Person("Adina", "Brenner", "301-521-5521", new Address("16 Pumpkin Rd.", "Newark", Address.State.DE, "54654"), "adinasemail@email.com");
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
    }

    public void addActionListeners() {
        listView.getNewClientBtn().addActionListener(this);
        listView.getDetailsBtn().addActionListener(this);
        listView.getDoneBtn().addActionListener(this);
        listView.getPaymentListBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == listView.getNewClientBtn()) {
            //instantiate InstrumentController without the selectedRow
            //it may require new constructor in InstrumentController that accepts ListController as a parameter
            this.clientController = new ClientController(this);

            //make sure to clear the fields on the details view
            this.clientController.displayClient(-1);
        }
        if (e.getSource() == listView.getDetailsBtn()) {
            listView.dispose();
            //find the selected row

                int selectedRow = listView.getClientTable().getSelectedRow();
                if (selectedRow < 0) {
                    throw new NullPointerException();
                }
                System.out.println("selectedRow = " + selectedRow);
                //if no row is selected on the list, set it to show first element on the details view
                //show a detail view with the data for the selected element
                //pass the flow from list controller to details controller
                //do not instantiate the details view from this list controller
                this.clientController = new ClientController(this, selectedRow);


        }
        if (e.getSource() == listView.getDoneBtn()) {
            //implement functionality
            this.listView.dispose();
        }
        if (e.getSource() == listView.getPaymentListBtn()) {
            listView.dispose();
            int selectedRow = listView.getClientTable().getSelectedRow();
            Person selectedClient = clients.get(selectedRow);
            DogController dogController = new DogController(selectedClient);
        }
    }

    //new method to show the list view
    public void showListView() {
        this.listView.setVisible(true);
    }

}
