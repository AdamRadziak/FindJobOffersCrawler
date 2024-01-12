/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

/**
 * This is an abstract class for WebElements from websites
 *
 * @author adamr
 */
public abstract class WebsiteElement implements WebsiteElementsInterface {

    public String position;
    public String location;
    // max offers count from each website
    public static int Max_offers_count = 100;
    // max timeout for finding elements in selenium webdriver
    public static long timeout = 300;

    /**
     * Constructor for class WebsiteElement
     *
     * @param position job selected position
     * @param location localization for selected position
     */
    public WebsiteElement(String position, String location) {
        this.position = position;
        this.location = location;
    }

    /**
     * this function return position for selected job
     *
     * @return job position
     */
    public String getPosition() {
        return position;
    }

    /**
     * this function return localization for selected job
     *
     * @return localization
     */
    public String getLocation() {
        return location;
    }

    /**
     * this function set position for selected job
     *
     * @param position job position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * this function set localization for selected job
     *
     * @param location job localization
     */
    public void setLocation(String location) {
        this.location = location;
    }

}
