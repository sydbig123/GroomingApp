package view;

import controller.DogListController;

import javax.swing.*;

public class DogListView extends JFrame{
    private JPanel pnlRoot;
    private JButton doneBtn;
    private JButton dogListBtn;
    private JTable dogTable;
    private JPanel pnlButtons;
    private JPanel pnlTable;
    private JScrollPane scrollPane;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 600;
    //private DogListController dogListController;

    public DogListView(DogListController dogListController) {
        //this.dogListController = dogListController;
        createListComponenets();
    }

    public JButton getDoneBtn() {
        return doneBtn;
    }

    public JButton getDogList() {
        return dogListBtn;
    }

    public JTable getDogTable() {
        return dogTable;
    }

    public void createListComponenets() {
        this.add(pnlRoot);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Dog LIST Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //dogTable.setModel(dogListController.getDogTableModel());
        //if you want to show the scroll bar on the view
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
