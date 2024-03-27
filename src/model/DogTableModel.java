package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DogTableModel extends AbstractTableModel {
    private String[] columnNames = {"First Name", "Last Name", "Breed", "Color"}; //Header values
    private List<Dog> dogList;
    //constructor
    public DogTableModel(List<Dog> dogList) {
        this.dogList = dogList;
    }

    @Override
    public int getRowCount() {
        return dogList.size();
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
            case 0: return (Object) dogList.get(rowIndex).getName();
            case 1: return (Object) dogList.get(rowIndex).getLastName();
            case 2: return (Object) dogList.get(rowIndex).getBreed();
            case 3: return (Object) dogList.get(rowIndex).getColor();
            default: return null;
        }
    }
}


