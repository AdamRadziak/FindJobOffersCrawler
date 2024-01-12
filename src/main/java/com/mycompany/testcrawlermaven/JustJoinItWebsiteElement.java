/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import static com.mycompany.testcrawlermaven.ElementMethods.Offers_tab;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

/**
 * This class is for searching job offers from website https://justjoin.it/
 *
 * @author adamr
 */
public class JustJoinItWebsiteElement extends WebsiteElement {

    // http endpoints
    private final String Common_end = "https://justjoin.it/";
    private final String Position_end = "?keyword=";
    // xpath selectors justjoin
    private static final String Job_offers_xpath = "//div[@data-test-id='virtuoso-item-list']//div[@data-index=";
    private static final String Job_position_xpath = "//div[@class='MuiBox-root css-6vg4fr']//h2";
    private static final String Company_xpath = "//div[@class='css-ldh1c9']//span";
    private static final String Salaries_range_xpath = "//div[@class='css-1b2ga3v']";
    private static final String Pages_xpath = "//ul[@class='pagination mb-0 ng-star-inserted']//a";
    // variables get from methods
    private static String url;

    /**
     * Constructor the same as WebsiteElement
     *
     * @param position - job searching position
     * @param location - localization for the job position
     */
    public JustJoinItWebsiteElement(String position, String location) {
        super(position, location);
    }

    /**
     * this methods create url to searching job offers from website
     */
    @Override
    public void create_get_job_offers_url() {
        // replace space to + char
        position = position.replace(" ", "+");
        // url is
        url = Common_end + location + Position_end + position.toLowerCase();
    }

    /**
     * this methods finding the job offers information such as job postion
     * company salaries range and get it to Offers_tab container with new
     * TableElements using selenium webdriver chrome If information like job
     * postion not exists it print "Nie znaleziono oferty" in output window If
     * salaries is Undisclosed Salary or not exists the salaries = "Nieznane"
     * and it save to TableElements
     */
    @Override
    public void get_offers() {
        String common_xpath;
        String get_position_xpath;
        String get_company_xpath;
        String get_salaries_xpath;
        String salaries;
        String position_get;
        String company;
        // fetching the target BulldogJob
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        // implicity wait for job offers
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(WebsiteElement.timeout));
        // get list of offers
        try {
            WebElement offers_el_count = driver.findElement(By.xpath("//span[@class='MuiTab-iconWrapper css-1604j7q']"));
            String offers = offers_el_count.getText();
            // delete offers and trailing whitespaces from text
            offers = offers.replace("offers", "");
            offers = offers.replace(" ", "");
            int offers_count = Integer.parseInt(offers);
            System.out.println("ILE na stronie = " + offers);
            // get min of offers count and max offers from 1 page
            offers_count = Math.min(offers_count, WebsiteElement.Max_offers_count);
            for (int i = 0; i < offers_count; i++) {
                common_xpath = Job_offers_xpath + "'" + Integer.toString(i) + "']";
                get_position_xpath = common_xpath + Job_position_xpath;
                get_company_xpath = common_xpath + Company_xpath;
                get_salaries_xpath = common_xpath + Salaries_range_xpath;
                try {
                    WebElement get_position = driver.findElement(By.xpath(get_position_xpath));
                    WebElement get_company = driver.findElement(By.xpath(get_company_xpath));
                    // scrolling by selenium
                    WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(get_position);
                    new Actions(driver)
                            .scrollFromOrigin(scrollOrigin, 0, 150)
                            .perform();
                    WebElement get_salaries = driver.findElement(By.xpath(get_salaries_xpath));
                    salaries = get_salaries.getText();
                    position_get = get_position.getText();
                    company = get_company.getText();
                    if (salaries.matches("Undisclosed Salary")) {
                        salaries = "Nieznane";
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Nie znaleziono oferty");
                    salaries = "";
                    position_get = "";
                    company = "";

                }
                if (!company.isEmpty()) {
                    Offers_tab.add(new TableElement(position_get, company, location, salaries));
                }
                System.out.println("stanowisko= " + position_get);
                System.out.println("firma= " + company);
                System.out.println("Widełki wynagrodzeń= " + salaries);

            }
        } catch (NoSuchElementException e) {
            System.out.println("NIe znaleziono ofert na stronie");
        }
        driver.close();
        driver.quit();
    }

}
