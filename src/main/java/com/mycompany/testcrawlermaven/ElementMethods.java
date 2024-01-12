/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author adamr this class is container of methods for TableElements, this
 * class not having a constructor
 */
public class ElementMethods {
    /**
     * Offers_tab is job offers information for Table row
     */
    public static ArrayList<TableElement> Offers_tab = new ArrayList();
    /**
     * Salaries_sep_regex is regex pattern to find - in unicode character
     */
    public static String Salaries_sep_regex = "\u2013|\u2014|\u002D|\u02D7";

    /**
     * this method convert from string Salaries to integer value if salary is x
     * - y return y if salary is Nieznane return 0 else return salary
     *
     * @param salaries - string representation of salaries, i.e 12000 - 20000
     * @return salary - maximum value from salaries
     */
    public static int convert_to_int_salaries(String salaries) {
        int salary;
        String[] parts;
        // remove traliling whitespcaces
        salaries = salaries.replace(" ", "");
        // remove pln in string
        salaries = salaries.replace("PLN", "");
        // pattern for search in string
        Pattern pattern = Pattern.compile(Salaries_sep_regex, Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(salaries);
        boolean matchFound = matcher.find();
        // if string have - split this into 2 string
        if (matchFound) {
            parts = salaries.split(Salaries_sep_regex);
            // remove whitespaces in string
            parts[1] = parts[1].replace(" ", "");
            salary = Integer.parseInt(parts[1]);
        } // if string is Nieznane
        else if (salaries.matches("Nieznane")) {
            salary = 0;
        } else {
            salaries = salaries.replace(" ", "");
            salary = Integer.parseInt(salaries);
        }
        return salary;
    }

    /**
     * this function sorting ascending job offers from Offers_tab Offers_tab is an
     * ArrayList for object TableElement with element of the table if salary
     * have x - y it sort by y if salary have Nieznane it seems salaries is 0
     * else salary have x
     */
    public static void sort_asc() {
        int salary_act;
        int salary_next;
        // sorting by COllections method
        for (int j = 0; j < WebsiteElement.Max_offers_count; j++) {
            for (int i = 0; i < Offers_tab.size() - 1; i++) {
                TableElement actual = Offers_tab.get(i);
                TableElement next = Offers_tab.get(i + 1);
                salary_act = convert_to_int_salaries(actual.getSalary_range());
                salary_next = convert_to_int_salaries(next.getSalary_range());
                if (salary_next < salary_act) {
                    Offers_tab.set(i, next);
                    Offers_tab.set(i + 1, actual);
                }
            }

        }
    }

    /**
     * this function sorting descending job offers from Offers tab Offers_tab is an
     * ArrayList for object TableElement with element of the table if salary
     * have x - y it sort by y if salary have Nieznane it seems salaries is 0
     * else salary have x
     */
    public static void sort_desc() {
        int salary_act;
        int salary_next;
        for (int j = 0; j < WebsiteElement.Max_offers_count; j++) {
            for (int i = 0; i < Offers_tab.size() - 1; i++) {
                TableElement actual = Offers_tab.get(i);
                TableElement next = Offers_tab.get(i + 1);
                salary_act = convert_to_int_salaries(actual.getSalary_range());
                salary_next = convert_to_int_salaries(next.getSalary_range());
                if (salary_next > salary_act) {
                    Offers_tab.set(i, next);
                    Offers_tab.set(i + 1, actual);
                }
            }

        }
    }

}
