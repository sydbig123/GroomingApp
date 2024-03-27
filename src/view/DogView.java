package view;

import controller.DogController;
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
    private JLabel messageLabel;
    private JComboBox monthInput;
    private JTextField yearInput;
    private JTextField dayInput;
    private JComboBox genderInput;
    private JComboBox aggressionInput;
    private JTextArea healthProblemsInput;
    private JComboBox ownerInput;
    DogController dogController;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 600;
    private Person owner = null;

    public DogView(DogController dogController) {
        this.dogController = dogController;
        createComponents();
    }

    public DogView(DogController dogController, Person selectedClient) {
        this.dogController = dogController;
        createComponents();
        owner = selectedClient;
    }

    public void createComponents() {
        this.add(pnlDog);
        this.monthInput.setModel(new DefaultComboBoxModel(Month.values())) ;
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dog GUI Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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

    //read the JText values
    public Dog createDog() {
        String fName = dogName.getText();
        Dog.Genders gender = (Dog.Genders) genderInput.getSelectedItem();
        String breed = breedInput.getText();
        String color = colorInput.getText();
        int year  = Integer.parseInt(yearInput.getText());
        int month = monthInput.getSelectedIndex();
        int day = Integer.parseInt(dayInput.getText());
        LocalDate dob = LocalDate.of(year, month, day);
        String health_problems = healthProblemsInput.getText();
        Dog.Aggression aggression = (Dog.Aggression) aggressionInput.getSelectedItem();
        Person owner = (Person) ownerInput.getSelectedItem();

        Dog dog = new Dog(fName, gender, breed, color, dob, health_problems, aggression, owner);
        return dog;
    }


    //write values to JText
    public void displayDog(Dog payment) {
        /*this.dogName.setText(dog.getFname());
        this.genderInput.setSelectedIndex();
        this.breedInput.setText(payment.getPayment_type());
        this.colorInput.setText(payment.getTip().toString());
        this.dayInput.setText(payment.getDate().getDayOfMonth() + "");
        this.yearInput.setText(payment.getDate().getYear() + "");
        this.monthInput.setSelectedIndex(payment.getDate().getMonthValue());*/
    }

    public void clearFields() {
        this.dogName.setText("");
        this.genderInput.setSelectedItem(Dog.Genders.Female);
        this.breedInput.setText("");
        this.colorInput.setText("");
        this.dayInput.setText("");
        this.monthInput.setSelectedItem(Month.JANUARY);
        this.yearInput.setText("");
        this.healthProblemsInput.setText("");
        this.aggressionInput.setSelectedItem(Dog.Aggression.Unknown);
        this.ownerInput.setSelectedIndex(0);
    }

}
