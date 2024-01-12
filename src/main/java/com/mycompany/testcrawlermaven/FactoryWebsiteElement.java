/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

/**
 * This class is for searching job offers from selected website in website_names
 *
 * @author adamr
 */
public class FactoryWebsiteElement {
    /**
     * website_names is String list with name of website where searching
     */
    public static String[] website_names = {"justjoin_it", "no_fluff_jobs"};

    /**
     * build method which searching job offers depending of website
     *
     * @param website_name - name of the website, i.e justjoin_it
     * @param position - searching job name
     * @param location - localization for searching job
     */
    static WebsiteElement build(String website_name, String position, String location) {
        
        if (website_name.equals(website_names[0])) {
            WebsiteElement web1 = new JustJoinItWebsiteElement(position, location);
            return web1;

        } else {
            WebsiteElement web2 = new NoFluffJobsWebsiteElement(position, location);
            return web2;

        }
        
    }
}
