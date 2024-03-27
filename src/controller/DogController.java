package controller;

import model.Dog;
import model.Person;
import view.DogView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DogController implements ActionListener {

    private DogView dogView;

    public DogController(Person selectedClient) {
        this.dogView = new DogView(this);
        addActionListeners();
    }

    public void addActionListeners() {
        dogView.getAddBtn().addActionListener(this);
        dogView.getPreviousButton().addActionListener(this);
        dogView.getClearButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dogView.getAddBtn()) {
            Dog newDog = dogView.createDog();
            //DogPersistenceController dogPersistenceController = new DogPersistenceController();
            //dogPersistenceController.getDogs().add(newDog);
            showDogListView();
        }
        if (e.getSource() == dogView.getClearButton()) {
            dogView.clearFields();
        }
        if (e.getSource() == dogView.getPreviousButton()) {
            showDogListView();
        }
    }


    private void showDogListView() {
        dogView.dispose();
        new DogListController();
    }

}
