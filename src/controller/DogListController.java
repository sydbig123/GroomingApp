package controller;

import model.*;
import view.DogListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DogListController implements ActionListener {

    private DogListView dogListView;
    List<Dog> dogList = new ArrayList<>();
    DogTableModel dogTableModel;
    DogController dogController;
    DogPersistenceController dogPersistenceController;

    public DogListController() {
        this.dogPersistenceController = new DogPersistenceController();
        dogList = dogPersistenceController.getDogs();
        this.dogTableModel = new DogTableModel(dogList);
        this.dogListView = new DogListView(this);
        addActionListeners();
    }

    public DogTableModel getDogTableModel() {
        return dogTableModel;
    }

    public List<Dog> getDogList() {
        return dogList;
    }

    public DogPersistenceController getDogPersistenceController() {
        return dogPersistenceController;
    }

    public void addActionListeners() {
        dogListView.getNewDogBtn().addActionListener(this);
        dogListView.getDoneBtn().addActionListener(this);
        dogListView.getShowDetailsBtn().addActionListener(this);
        dogListView.getClientListButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dogListView.getNewDogBtn()) {

            this.dogController = new DogController(this, 0);
            this.dogController.displayDog(-1);
        }
        if (e.getSource() == dogListView.getShowDetailsBtn()) {
            dogListView.dispose();
            int selectedRow = dogListView.getDogTable().getSelectedRow();
            if (selectedRow == -1) {
                selectedRow = 0;
            }
            this.dogController = new DogController(this, selectedRow);
        }
        if (e.getSource() == dogListView.getDoneBtn()) {
            System.exit(0);
        }
        if (e.getSource() == dogListView.getClientListButton()) {
            dogListView.dispose();
            new ClientListController();
        }
    }

    public void showListView() {this.dogListView.setVisible(true);}
}
