/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import static com.mycompany.testcrawlermaven.ElementMethods.Offers_tab;

/**
 * This class creates template of table for Jtable and table in pdf file
 *
 * @author adamr
 */
import javax.swing.table.AbstractTableModel;

/**
 * This class create default template for Table
 * @author adamr
 */
public class TableModel extends AbstractTableModel {

    /**
     * this function return num of rows from table
     * @return num of rows
     */
    @Override
    public int getRowCount() {
        return Offers_tab.size();
    }

    /**
     * This function returns name of column
     *
     * @param column column index
     * @return name of the column
     */
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 ->
                "Stanowisko";
            case 1 ->
                "Lokalizacja";
            case 2 ->
                "Firma";
            case 3 ->
                "Wynagrodzenie";
            default ->
                "";
        };

    }

    /**
     * this function returns number of columns in table
     *
     * @return num of columns in table
     */
    @Override
    public int getColumnCount() {
        return 4;
    }

    /**
     * this function get Value of selected row and column
     *
     * @param rowIndex index of row
     * @param columnIndex index of column
     * @return value of selected row and column
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 ->
                Offers_tab.get(rowIndex).getPosition();
            case 1 ->
                Offers_tab.get(rowIndex).getLocalization();
            case 2 ->
                Offers_tab.get(rowIndex).getCompany();
            case 3 ->
                Offers_tab.get(rowIndex).getSalary_range();
            default ->
                0;
        };
    }

}
