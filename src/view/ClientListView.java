package view;

import controller.ClientListController;

import javax.swing.*;

public class ClientListView extends JFrame {

    private JPanel pnlRoot;
    private JPanel pnlTable;
    private JPanel pnlButtons;
    private JScrollPane scrollPane;
    private JTable clientTable;
    private JButton newClientButton;
    private JButton showDetailsButton;
    private JButton doneButton;
    private JButton dogListBtn;
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;
    private ClientListController clientListController;

    public ClientListView(ClientListController clientListController) {
        this.clientListController = clientListController;
        createListComponents();
    }

    public JButton getNewClientBtn() {
        return newClientButton;
    }

    public JButton getDetailsBtn() {
        return showDetailsButton;
    }

    public JButton getDoneBtn() {
        return doneButton;
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public JButton getDogListBtn() {
        return dogListBtn;
    }

    public void createListComponents() {
        this.add(pnlRoot);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle("Client LIST Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        clientTable.setModel(clientListController.getClientTableModel());
        //if you want to show the scroll bar on the view
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
