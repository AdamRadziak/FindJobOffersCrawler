/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;
import static com.mycompany.testcrawlermaven.ElementMethods.Offers_tab;

/**
 *
 * @author adamr
 */
import javax.swing.table.AbstractTableModel;
public class TableModel extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return Offers_tab.size();
    }

    @Override
    public String getColumnName(int column) {
//        return super.getColumnName(column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        return switch (column) {
            case 0 -> "Stanowisko";
            case 1 -> "Lokalizacja";
            case 2 -> "Firma";
            case 3 -> "Wynagrodzenie";
            default -> "";
        };

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> Offers_tab.get(rowIndex).getPosition();
            case 1 -> Offers_tab.get(rowIndex).getLocalization();
            case 2 -> Offers_tab.get(rowIndex).getCompany();
            case 3 -> Offers_tab.get(rowIndex).getSalary_range();
            default -> 0;
        };
    }
    
}
