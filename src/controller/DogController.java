package controller;

import model.Dog;
import model.Person;
import view.ClientView;
import view.DogListView;
import view.DogView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DogController implements ActionListener {

    private DogView dogView;
    private List<Dog> dogs = new ArrayList<>();
    private DogListController dogListController;
    int currentIndex;

    public DogController(DogListController dogListController, int selectedRow) {
        this.dogListController = dogListController;
        this.dogs = dogListController.getDogList();
        Dog selectedDog = dogs.get(selectedRow);
        this.dogView = new DogView(this, selectedDog);
        this.currentIndex = selectedRow;
        addActionListeners();

    }

//    public DogController(Person selectedClient) {
//        dogView = new DogView(this);
//        addActionListeners();
//        Dog newDog = dogView.createDog();
//        dogView.displayDog(newDog);
//    }

    public void addActionListeners() {
        dogView.getAddBtn().addActionListener(this);
        dogView.getNextButton().addActionListener(this);
        dogView.getPreviousButton().addActionListener(this);
        dogView.getUpdateButton().addActionListener(this);
        dogView.getDeleteButton().addActionListener(this);
        dogView.getClearButton().addActionListener(this);
        dogView.getBackButton().addActionListener(this);
        dogView.getSubmitButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dogView.getBackButton()) {
            this.dogView.dispose();
            dogListController.showListView();
        }
        if (e.getSource() == dogView.getAddBtn()) {
//            Dog newDog = dogView.createDog();
//            DogPersistenceController dogPersistenceController = new DogPersistenceController();
//            dogPersistenceController.getDogs().add(newDog);
//            dogPersistenceController.writeDogFile();
//            showDogListView();
            dogView.clearFields();
        }
        if (e.getSource() == dogView.getSubmitButton()) {
            Dog newDog = dogView.createDog();
            dogs.add(newDog);
            currentIndex = dogs.indexOf(newDog);
            dogView.displayDog(dogs.get(currentIndex));
        }
        if (e.getSource() == dogView.getNextButton()) {
            if (currentIndex < dogs.size() - 1) {
                currentIndex = currentIndex + 1;
                displayDog(currentIndex);
            }
            else {
                dogView.displayDog(dogs.get(currentIndex));
            }
        }
        if (e.getSource() == dogView.getPreviousButton()) {
            if (currentIndex >= 1) {
                currentIndex = currentIndex - 1;
                displayDog(currentIndex);
            }
            else {
                dogView.displayDog(dogs.get(currentIndex));
            }
        }
        if (e.getSource() == dogView.getUpdateButton()) {
            Dog updatedDog = dogView.createDog();
            dogs.set(currentIndex, updatedDog);
            dogListController.getDogPersistenceController().writeDogFile();
        }
        if (e.getSource() == dogView.getDeleteButton()) {
            dogs.remove(currentIndex);
            if (dogs.size() > 0) {
                dogView.displayDog(dogs.get(currentIndex - 1));
            }
            else {
                dogView.clearFields();
            }
        }
        if (e.getSource() == dogView.getClearButton()) {
            dogView.clearFields();
        }
    }

//    private void showDogListView() {
//        //dogView.dispose();
//        //new DogListController();
//        this.dogView.setVisible(true);
//    }

    public void displayDog(int index) {
        if (index == -1) {
            dogView.clearFields();
        }
        else {
            Dog previousDog = dogs.get(index);
            dogView.displayDog(previousDog);
            //dogView.setDisplayMessage("current index = \" + currentIndex");
        }
    }

}
