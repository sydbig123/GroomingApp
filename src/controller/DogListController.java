package controller;

import model.*;
import view.DogListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DogListController implements ActionListener {

    private List<Dog> dogList = new ArrayList<>();
    private DogTableModel dogTableModel;
    private DogListView dogListView;
    //private DogPersistenceController dogPersistenceController;

    public DogListController() {
        //dogPersistenceController = new DogPersistenceController();
        //dogList = dogPersistenceController.getDogs();
        dogTableModel = new DogTableModel(dogList);
        //this.dogListView = new DogListView(this);
        addActionListeners();
    }

    public DogTableModel getDogTableModel() {
        return dogTableModel;
    }

    public void addActionListeners() {
        dogListView.getDogList().addActionListener(this);
        dogListView.getDoneBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dogListView.getDoneBtn()) {
            System.exit(0);
        }
        if (e.getSource() == dogListView.getDogList()) {
            dogListView.dispose();
            new ClientListController();
        }
    }
}
