/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

/**
 *
 * @author adamr
 */
public class TableElement {
    
    protected String Position;
    protected String Company;
    protected String Localization;
    protected String Salary_range;

    public TableElement(String Position, String Company, String Localization, String Salary_range) {
        this.Position = Position;
        this.Company = Company;
        this.Localization = Localization;
        this.Salary_range = Salary_range;
    }

    public String getPosition() {
        return Position;
    }

    public String getCompany() {
        return Company;
    }

    public String getLocalization() {
        return Localization;
    }

    public String getSalary_range() {
        return Salary_range;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public void setLocalization(String Localization) {
        this.Localization = Localization;
    }

    public void setSalary_range(String Salary_range) {
        this.Salary_range = Salary_range;
    }
    
    
    
}
