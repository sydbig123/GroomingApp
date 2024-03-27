package view;

import controller.ClientController;
import model.Address;
import model.Person;

import javax.swing.*;

public class ClientView extends JFrame{
    private JPanel panelClient;
    private JTextField fNameInput;
    private JTextField lNameInput;
    private JTextField numberInput;
    private JTextField emailInput;
    private JTextField streetInput;
    private JLabel fNameLabel;
    private JLabel lNameLabel;
    private JLabel phoneNumLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private JButton addButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JLabel messageLabel;
    private JButton submitButton;
    private JTextField zipcodeInput;
    private JTextField cityInput;
    private JComboBox stateInput;
    private ClientController clientController;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 600;


    public ClientView(ClientController clientController) {
        this.clientController = clientController;
        createComponents();
    }

    public ClientView(ClientController clientController, Person selectedClient) {
        this.clientController = clientController;
        createComponents();
        displayClient(selectedClient);
    }

    private void createComponents() {
        this.add(panelClient);
        this.stateInput.setModel(new DefaultComboBoxModel(Address.State.values())) ;
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Client GUI Screen");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }
    public JButton getSubmitButton() {
        return submitButton;
    }



    //read the JText values
    public Person createClient() {
        String fName = fNameInput.getText();
        String lName = lNameInput.getText();
        String phoneNum = numberInput.getText();
        String email = emailInput.getText();

        Address.State state = (Address.State) stateInput.getSelectedItem();
        Address address = new Address(streetInput.getText(), cityInput.getText(), state, zipcodeInput.getText());


        Person person = new Person(fName, lName, phoneNum, address, email);
        return person;
    }

    //write values to JText
    public void displayClient(Person client) {
        this.fNameInput.setText(client.getFirstName());
        this.lNameInput.setText(client.getLastName());
        this.numberInput.setText(client.getNumber());
        this.emailInput.setText(client.getEmail());
        this.streetInput.setText(client.getAddress().getStreet());
        this.cityInput.setText(client.getAddress().getCity());
        this.stateInput.setSelectedItem(client.getAddress().getState());
        this.zipcodeInput.setText(client.getAddress().getZipcode());
        //this.clientController.checkIndex();
    }

    public void clearFields() {
        this.fNameInput.setText("");
        this.lNameInput.setText("");
        this.numberInput.setText("");
        this.emailInput.setText("");
        this.streetInput.setText("");
        this.cityInput.setText("");
        this.stateInput.setSelectedItem(Address.State.AL);
        this.zipcodeInput.setText("");
    }

    public void setDisplayMessage(String message) {
        this.messageLabel.setText(message);
    }


    /*public void hideButton(String btn) {
        if (btn.equals("previous")) {
            previousButton.setVisible(false);
        }
        if (btn.equals("next")) {
            previousButton.setVisible(false);
        }
        if (btn.equals("add")) {
            previousButton.setVisible(false);
        }
        if (btn.equals("update")) {
            previousButton.setVisible(false);
        }
        if (btn.equals("submit")) {
            submitButton.setVisible(false);
        }
    }

    public void displayButton(String btn) {
        if (btn.equals("previous")) {
            previousButton.setVisible(true);
        }
        if (btn.equals("next")) {
            previousButton.setVisible(true);
        }
        if (btn.equals("add")) {
            previousButton.setVisible(true);
        }
        if (btn.equals("update")) {
            previousButton.setVisible(true);
        }
        if (btn.equals("submit")) {
            submitButton.setVisible(true);
        }
    }*/

}
