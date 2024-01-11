/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

/**
 *
 * @author adamr
 */
public class Endpoints {
    // http endpoints
    public static String Common_justjoin_end = "https://justjoin.it/";
    public static String Position_justjoin_end = "?keyword=";
    public static String Common_NoFLuffJobs_end = "https://nofluffjobs.com/pl/";
    public static String Position_NoFLuffJobs_end = "&criteria=keyword%3D";
    public static String Pages_NoFLuffJobs_end = "?page=";
    // xpath selectors bulldogjob
    public static String job_offers_justjoin_xpath = "//div[@data-test-id='virtuoso-item-list']//div[@data-index=";
    public static String job_position_justjoin_xpath = "//div[@class='MuiBox-root css-6vg4fr']//h2";
    public static String company_justjoin_xpath = "//div[@class='css-ldh1c9']//span";
    public static String salaries_range_justjoin_xpath = "//div[@class='css-1b2ga3v']";
    public static String pages_justjoin_xpath = "//ul[@class='pagination mb-0 ng-star-inserted']//a";
    // xpath selectors nofluffjob
    public static String job_offers_nofluffjobs_xpath = "//div[@class='list-container ng-star-inserted']//a[@target='_self']";
    public static String job_position_nofluffjobs_xpath = "//h3";
    public static String company_nofluffjobs_xpath = "//h4";
    public static String salaries_range_nofluffjobs_xpath = "//nfj-posting-item-salary[@class='tw-mr-2']//span[1]";
}   
//a[@href='/offers/itds-fullstack-node-js-javascript-developer']