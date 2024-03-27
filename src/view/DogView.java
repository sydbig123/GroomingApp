package view;

import controller.DogController;
import model.Address;
import model.Dog;
import model.Person;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Month;

public class DogView extends JFrame{
    private JButton previousButton;
    private JPanel pnlDog;
    private JButton deleteButton;
    private JButton addButton;
    private JButton submitButton;
    private JButton updateButton;
    private JButton nextButton;
    private JButton clearButton;
    private JTextField dogName;
    private JTextField breedInput;
    private JTextField colorInput;
    //private JLabel messageLabel;
    private JComboBox monthInput;
    private JTextField yearInput;
    private JTextField dayInput;
    private JComboBox genderInput;
    private JComboBox aggressionInput;
    private JTextArea healthProblemsInput;
    private JComboBox ownerInput;
    private JComboBox sizeInput;
    private JButton backButton;
    DogController dogController;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;
    //private Person owner = null;

    public DogView(DogController dogController) {
        this.dogController = dogController;
        createComponents();
    }

    public DogView(DogController dogController, Dog selectedDog) {
        //this.dogController = dogController;
        //createComponents();
        //displayDog(selectedDog);
        //owner = selectedClient;
    }

    public void createComponents() {
        this.add(pnlDog);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dog GUI Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //this.createUIComponents();

        this.monthInput.setModel(new DefaultComboBoxModel(Month.values())) ;
        this.sizeInput.setModel(new DefaultComboBoxModel(Dog.Size.values()));
        this.genderInput.setModel(new DefaultComboBoxModel(Dog.Genders.values()));
        this.aggressionInput.setModel(new DefaultComboBoxModel(Dog.Aggression.values()));
        //this.ownerInput.setModel(new DefaultComboBoxModel(PersonPersistenceController.getClients()));
    }

    public JButton getPreviousButton() {
        return previousButton;
    }
    public JButton getAddBtn() {
        return addButton;
    }
    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getBackButton() {
        return backButton;
    }


    //read the JText values
    public Dog createDog() {
        String fName = dogName.getText();
        Dog.Genders gender = (Dog.Genders) genderInput.getSelectedItem();
        String breed = breedInput.getText();
        String color = colorInput.getText();
        Dog.Size size = (Dog.Size) sizeInput.getSelectedItem();
        int year  = Integer.parseInt(yearInput.getText());
        int month = monthInput.getSelectedIndex();
        int day = Integer.parseInt(dayInput.getText());
        LocalDate dob = LocalDate.of(year, month, day);
        String health_problems = healthProblemsInput.getText();
        Dog.Aggression aggression = (Dog.Aggression) aggressionInput.getSelectedItem();
        //Person owner = (Person) ownerInput.getSelectedItem();
        Person owner = new Person("Charlie", "Brown", "321-321-3210", new Address("123 House Rd.", "State College", Address.State.PA, "16801"), "charlie@email.com");


        Dog dog = new Dog(fName, gender, breed, color, size, dob, health_problems, aggression, owner);
        return dog;
    }


    //write values to JText
    public void displayDog(Dog dog) {
        this.dogName.setText(dog.getName());
        this.genderInput.setSelectedItem(dog.getGender());
        this.breedInput.setText(dog.getBreed());
        this.colorInput.setText(dog.getColor());
        this.sizeInput.setSelectedItem(dog.getSize());
        this.dayInput.setText(dog.getDob().getDayOfMonth() + "");
        this.yearInput.setText(dog.getDob().getYear() + "");
        this.monthInput.setSelectedIndex(dog.getDob().getMonthValue());
        this.healthProblemsInput.setText(dog.getHealth_problems());
    }

    public void clearFields() {
        this.dogName.setText("");
        this.genderInput.setSelectedItem(Dog.Genders.Female);
        this.breedInput.setText("");
        this.colorInput.setText("");
        this.sizeInput.setSelectedItem(Dog.Size.Small);
        this.dayInput.setText("");
        this.monthInput.setSelectedItem(Month.JANUARY);
        this.yearInput.setText("");
        this.healthProblemsInput.setText("");
        this.aggressionInput.setSelectedItem(Dog.Aggression.Unknown);
        //this.ownerInput.setSelectedIndex(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
