/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

/**
 * This class creates rows for JTable and table in pdf file
 *
 * @author adamr
 */
public class TableElement {

    protected String Position;
    protected String Company;
    protected String Localization;
    protected String Salary_range;

    /**
     * Constructor for TableElement class
     *
     * @param Position job postion
     * @param Company company
     * @param Localization localization for searching job
     * @param Salary_range job expected salary
     */
    public TableElement(String Position, String Company, String Localization, String Salary_range) {
        this.Position = Position;
        this.Company = Company;
        this.Localization = Localization;
        this.Salary_range = Salary_range;
    }

    /**
     * this function get job position
     *
     * @return Position job position
     */
    public String getPosition() {
        return Position;
    }

    /**
     * this function return company
     *
     * @return Company
     */
    public String getCompany() {
        return Company;
    }

    /**
     * this function return localization
     *
     * @return Localization
     */
    public String getLocalization() {
        return Localization;
    }

    /**
     * this function return salaries
     *
     * @return Salary_range
     */
    public String getSalary_range() {
        return Salary_range;
    }

    /**
     * this function set value for position
     *
     * @param Position job position
     */
    public void setPosition(String Position) {
        this.Position = Position;
    }

    /**
     * this function set value for company
     *
     * @param Company
     */
    public void setCompany(String Company) {
        this.Company = Company;
    }

    /**
     * this function set localization
     *
     * @param Localization
     */
    public void setLocalization(String Localization) {
        this.Localization = Localization;
    }

    /**
     * this function set salary
     *
     * @param Salary_range expected salary
     */
    public void setSalary_range(String Salary_range) {
        this.Salary_range = Salary_range;
    }

}
