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

    // website names
    public static String[] website_names = {"justjoin_it", "no_fluff_jobs"};

    /**
     * build method which searching job offers depending of website
     *
     * @param website_name - name of the website, i.e justjoin_it
     * @param position - searching job name
     * @param location - localization for searching job
     */
    static void build(String website_name, String position, String location) {
        if (website_name.equals(website_names[0])) {
            JustJoinItWebsiteElement web1 = new JustJoinItWebsiteElement(position, location);
            web1.create_get_job_offers_url();
            web1.get_offers();

        } else {
            NoFluffJobsWebsiteElement web2 = new NoFluffJobsWebsiteElement(position, location);
            web2.create_get_job_offers_url();
            web2.get_offers();
        }
    }
}
