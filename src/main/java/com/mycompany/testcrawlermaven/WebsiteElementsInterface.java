/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.testcrawlermaven;

/**
 * This is interface which implemented by class WebsiteElement
 * @author adamr
 */
public interface WebsiteElementsInterface {
    /**
     * this methods is for creating url whre searching job offers from websites
     */
    public void create_get_job_offers_url();
    /**
     * * this methods is searching information from job offers from websites
     */
    public void get_offers();
}
