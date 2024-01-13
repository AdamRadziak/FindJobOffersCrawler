/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import static com.mycompany.testcrawlermaven.ElementMethods.Offers_tab;
import java.time.Duration;
import java.util.List;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class is for searching job offers from website https://nofluffjobs.com/
 *
 * @author adamr
 */
public class NoFluffJobsWebsiteElement extends WebsiteElement {

    // http endpoints
    private static final String Common_end = "https://nofluffjobs.com/pl/";
    private static final String Position_end = "&criteria=keyword%3D";
    private static final String Pages_end = "?page=";
    // xpath selectors justjoin
    private static final String Job_offers_xpath = "//div[@class='list-container ng-star-inserted']//a[@target='_self']";
    private static final String Job_position_xpath = "//h3";
    private static final String Company_xpath = "//h4";
    private static final String Salaries_range_xpath = "//nfj-posting-item-salary[@class='tw-mr-2']//span[1]";
    private static final String Pages_xpath = "//ul[@class='pagination mb-0 ng-star-inserted']//a";
    // variables get from methods
    private static String url;
    private static int offers_count;

    /**
     * Constructor the same as WebsiteElement
     *
     * @param position - job searching position
     * @param location - localization for the job position
     */
    public NoFluffJobsWebsiteElement(String position, String location) {
        super(position, location);
    }

    /**
     * this methods create url to searching job offers from website
     */
    @Override
    public void create_get_job_offers_url() {
        url = Common_end + location + Pages_end + "1" + Position_end + position.toLowerCase();
    }

    /**
     * this methods finding the job offers information such as job position
     * company salaries range and get it to Offers_tab container with new
     * TableElements using selenium webdriver chrome. If information like job
     * postion not exists it print "Nie znaleziono oferty" in output window If
     * salaries is Undisclosed Salary or not exists the salaries = "Nieznane"
     * and it save to TableElements
     */
    @Override
    public void get_offers() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // implicity wait for job offers
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(WebsiteElement.timeout));
        // get count of pages
        List<WebElement> pages = driver.findElements(By.xpath(Pages_xpath));
        // close previous driver
        driver.close();
        driver.quit();
        System.out.println("ILE stron = " + (pages.size() - 1));
        if (!pages.isEmpty()) {
            for (int j = 1; j < pages.size(); j++) {
                url = Common_end + location + Pages_end + Integer.toString(j) + Position_end + position.toLowerCase();
                Get_offers_from_nofluff_job(url, location);
            }
        } else {
            url = Common_end + location + Pages_end + "1" + Position_end + position.toLowerCase();
            Get_offers_from_nofluff_job(url, location);
        }
    }

    /**
     * this methods finding the job offers information such as job position
     * company salaries range and get it to Offers_tab container with new
     * TableElements using selenium webdriver chrome in some new pages
     *
     * @param url url to search for
     * @param location localization for searching job
     */
    public static void Get_offers_from_nofluff_job(String url, String location) {
        // get new driver
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // implicity wait for job offers
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(WebsiteElement.timeout));
        List<WebElement> offers = driver.findElements(By.xpath(Job_offers_xpath));
        System.out.println("ILE na stronie = " + offers.size());
        offers_count += offers.size();
        // max offers count from all pages
        offers_count = Math.min(offers.size(), WebsiteElement.Max_offers_count);
        for (int i = 1; i < offers_count; i++) {
            String common_xpath = Job_offers_xpath + "[" + Integer.toString(i) + "]";
            String get_position_xpath = common_xpath + Job_position_xpath;
            String get_company_xpath = common_xpath + Company_xpath;
            String get_salaries_xpath = common_xpath + Salaries_range_xpath;
            String salaries;
            String position;
            String company;
            try {
                WebElement get_position = driver.findElement(By.xpath(get_position_xpath));
                WebElement get_company = driver.findElement(By.xpath(get_company_xpath));
                WebElement get_salaries = driver.findElement(By.xpath(get_salaries_xpath));
                salaries = get_salaries.getText();
                if (salaries.matches("Undisclosed Salary")) {
                    salaries = "Nieznane";
                }
                position = get_position.getText();
                company = get_company.getText();
            } catch (NoSuchElementException e) {
                System.out.println("Nie znaleziono oferty");
                salaries = "";
                position = "";
                company = "";
            if (!company.isEmpty()) {
                Offers_tab.add(new TableElement(position, company, location, salaries));
            System.out.println("stanowisko= " + position);
            System.out.println("firma= " + company);
            System.out.println("Widełki wynagrodzeń= " + salaries);
            }
            } catch (TimeoutException te) {
                JOptionPane.showMessageDialog(null, "timeout occured", te + " try again", JOptionPane.WARNING_MESSAGE);
                driver.close();
                driver.quit();
            }

        }
        driver.close();
        driver.quit();
    }

}
