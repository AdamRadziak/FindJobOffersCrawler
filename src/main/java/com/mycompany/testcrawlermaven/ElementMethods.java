/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

/**
 *
 * @author adamr
 */
public class ElementMethods {

    public static ArrayList<TableElement> Offers_tab = new ArrayList();
    // max offers count from all pages
    public static int Max_offers_count = 100;
    public static String Salaries_sep_regex = "\u2013|\u2014|\u002D|\u02D7";
    public static long timeout = 300;

    public static void Get_information_from_justjoin_web(String position, String location) {
        // replace space to + char
        position = position.replace(" ", "+");
        String url = Endpoints.Common_justjoin_end + location + Endpoints.Position_justjoin_end + position.toLowerCase();
        // fetching the target BulldogJob
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // implicity wait for job offers
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeout));
        // get list of offers
        Get_offers_from_justjoin(url, driver,location);

    }

    public static void Get_information_from_nofluffjobs_web(String position, String location) {
        String url = Endpoints.Common_NoFLuffJobs_end + location + Endpoints.Pages_NoFLuffJobs_end + "1" + Endpoints.Position_NoFLuffJobs_end + position.toLowerCase();
        // fetching the target BulldogJob
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // implicity wait for job offers
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeout));
        // get count of pages
        List<WebElement> pages = driver.findElements(By.xpath(Endpoints.pages_justjoin_xpath));
        // close previous driver
        driver.close();
        driver.quit();
        System.out.println("ILE stron = " + (pages.size() - 1));
        if(pages.size() > 0){
        for(int j=1; j < pages.size();j++){ 
            url = Endpoints.Common_NoFLuffJobs_end + location + Endpoints.Pages_NoFLuffJobs_end + Integer.toString(j) + Endpoints.Position_NoFLuffJobs_end + position.toLowerCase();
            Get_offers_from_nofluff_job(url,location);
            }
        }
        else{
            url = Endpoints.Common_NoFLuffJobs_end + location + Endpoints.Pages_NoFLuffJobs_end + "1" + Endpoints.Position_NoFLuffJobs_end + position.toLowerCase();
            Get_offers_from_nofluff_job(url, location);
        }
            
        
    }
        /**
     *
     * @param url
     * @param driver
     * @param location
     */
    public static void Get_offers_from_justjoin(String url, WebDriver driver, String location){
        String common_xpath;
        String get_position_xpath;
        String get_company_xpath;
        String get_salaries_xpath;
        String salaries;
        String position_get;
        String company; 
        // get list of offers
        try{
        WebElement offers_el_count = driver.findElement(By.xpath("//span[@class='MuiTab-iconWrapper css-1604j7q']"));
        String offers = offers_el_count.getText();
        // delete offers and trailing whitespaces from text
        offers = offers.replace("offers","" );
        offers = offers.replace(" ","" );
        int offers_count = Integer.parseInt(offers);
        System.out.println("ILE na stronie = " + offers);
        // get min of offers count and max offers from 1 page
        offers_count = Math.min(offers_count,Max_offers_count );
        for (int i = 0; i < offers_count; i++) {
            common_xpath = Endpoints.job_offers_justjoin_xpath + "'" + Integer.toString(i) + "']";
            get_position_xpath = common_xpath + Endpoints.job_position_justjoin_xpath;
            get_company_xpath = common_xpath + Endpoints.company_justjoin_xpath;
            get_salaries_xpath = common_xpath + Endpoints.salaries_range_justjoin_xpath;
            try{
            WebElement get_position = driver.findElement(By.xpath(get_position_xpath));
            WebElement get_company = driver.findElement(By.xpath(get_company_xpath));
            // scrolling by selenium
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(get_position);
            new Actions(driver)
                .scrollFromOrigin(scrollOrigin,0,150)
                .perform();
                WebElement get_salaries = driver.findElement(By.xpath(get_salaries_xpath));
                salaries = get_salaries.getText();
                position_get = get_position.getText();
                company = get_company.getText();
                if(salaries.matches("Undisclosed Salary")){
                salaries = "Nieznane";
            }
            } catch (NoSuchElementException e) {
                System.out.println(e);
                salaries = "";
                position_get ="";
                company ="";

            }
            if(!company.isEmpty()){
            Offers_tab.add(new TableElement(position_get, company, location, salaries));
            }
            System.out.println("stanowisko= " + position_get);
            System.out.println("firma= " + company);
            System.out.println("Widełki wynagrodzeń= " + salaries);

        }
        }catch(NoSuchElementException e){
            System.out.println("NIe znaleziono ofert na stronie");
        }
        driver.close();
        driver.quit();
    }
    
    /**
     *
     * @param url
     * @param location
     */
    public static void Get_offers_from_nofluff_job(String url,String location){
        int offers_count = 0;
        // get new driver
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // implicity wait for job offers
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeout));
        List<WebElement> offers = driver.findElements(By.xpath(Endpoints.job_offers_nofluffjobs_xpath));
        System.out.println("ILE na stronie = " + offers.size());
        offers_count += offers.size();
        // max offers count from all pages
        offers_count = Math.min(offers.size(),Max_offers_count );
            for (int i = 1; i < offers_count; i++) {
                String common_xpath = Endpoints.job_offers_nofluffjobs_xpath + "[" + Integer.toString(i) + "]";
                String get_position_xpath = common_xpath + Endpoints.job_position_nofluffjobs_xpath;
                String get_company_xpath = common_xpath + Endpoints.company_nofluffjobs_xpath;
                String get_salaries_xpath = common_xpath + Endpoints.salaries_range_nofluffjobs_xpath;
                String salaries;
                String position;
                String company;
                try {
                WebElement get_position = driver.findElement(By.xpath(get_position_xpath));
                WebElement get_company = driver.findElement(By.xpath(get_company_xpath));
                WebElement get_salaries = driver.findElement(By.xpath(get_salaries_xpath));
                salaries = get_salaries.getText();
                if(salaries.matches("Undisclosed Salary")){
                salaries = "Nieznane";
                }
                position = get_position.getText();
                company = get_company.getText();
                } catch (NoSuchElementException e) {
                    System.out.println(e);
                    salaries = "";
                    position = "";
                    company = "";
                }
                if(!company.isEmpty()){
                Offers_tab.add(new TableElement(position, company, location, salaries));
                }
                System.out.println("stanowisko= " + position);
                System.out.println("firma= " + company);
                System.out.println("Widełki wynagrodzeń= " + salaries);

            }
            driver.close();
            driver.quit();
    } 
    /* this method convert from string Salaries
        if salary is x - y return y
        if salary is Nienznae return 0
        else return salary
     */
    public static int convert_to_int_salaries(String salaries) {
        int salary;
        String[] parts;
        // remove traliling whitespcaces
        salaries = salaries.replace(" ","");
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
            parts[1] = parts[1].replace(" ","");
            salary = Integer.parseInt(parts[1]);
        }
        // if string is Nieznane
        else if (salaries.matches("Nieznane")) {
            salary = 0;
        } 
        else {
            salaries = salaries.replace(" ","");
            salary = Integer.parseInt(salaries);
        }
        return salary;
    }

    /* this function sorting ascending offers from Offers tab 
        this function not have an arguments because Offers_tab is global arrray
        if salary have x - y it sort by y
        if salary have Nieznane it seems salaries is 0
        else salary have x
     */
    public static void sort_asc() {
        int salary_act;
        int salary_next;
        // sorting by COllections method
        for (int j = 0; j < Max_offers_count; j++) {
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
    /* this function sorting descending offers from Offers tab 
        this function not have an arguments because Offers_tab is global arrray
        if salary have x - y it sort by y
        if salary have Nieznane it seems salaries is 0
        else salary have x
     */
        public static void sort_desc() {
        int salary_act;
        int salary_next;
        for (int j = 0; j < Max_offers_count; j++) {
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
