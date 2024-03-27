package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {
    private String[] columnNames = {"First Name", "Last Name", "Phone Number"}; //Header values
    private List<Person> clientList;
    //constructor
    public ClientTableModel(List<Person> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int getRowCount() {
        return clientList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return (Object) clientList.get(rowIndex).getFirstName();
            case 1: return (Object) clientList.get(rowIndex).getLastName();
            case 2: return (Object) clientList.get(rowIndex).getNumber();
            default: return null;
        }
    }
}

