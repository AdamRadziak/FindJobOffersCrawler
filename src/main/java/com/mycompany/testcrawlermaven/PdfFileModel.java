/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfPCell;

/**
 * Class for formating rows and cells
 * @author adamr
 */
public class PdfFileModel {

    private String title ;
    private String subtitle;
    private String descr_1;
    private String descr_2;
    
    private final String title_font = FontFactory.HELVETICA_BOLD;
    private final String subtitle_font = FontFactory.HELVETICA_OBLIQUE;
    private final String desc_font = FontFactory.HELVETICA;
    private final int title_fontsize = 14;
    private final int subtitle_fontsize = 12;
    private final int desc_fontsize = 10;
    private final BaseColor default_fontcolor = BaseColor.BLACK;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setDescr_1(String descr_1) {
        this.descr_1 = descr_1;
    }

    public void setDescr_2(String descr_2) {
        this.descr_2 = descr_2;
    }
    

    /**
     * this function format title in pdf document
     * @return  title Chunk object of pdffile
     */
    public Chunk format_title(){
        // add title, subtitle and information for table
        Font font_title = FontFactory.getFont(title_font, title_fontsize, default_fontcolor);
        Chunk title = new Chunk(getTitle(), font_title);
        return title;
    }
    /**
     * this function format subtitle in pdf document
     * @return subtitle Chunk object of pdffile
     */
    public Chunk format_subtitle(){
        Font font_title = FontFactory.getFont(subtitle_font, subtitle_fontsize, default_fontcolor);
        Chunk subtitle = new Chunk(getSubtitle(), font_title);
        return subtitle;
    }
    /**
     * this function format description 1 in pdffile
     * @return desc_1 Chunk object of pdffile
     */
    public Chunk format_descr_1(){
        Font font_normal = FontFactory.getFont(desc_font, desc_fontsize, default_fontcolor);
        
        Chunk desc_1 = new Chunk(getDescr_1(), font_normal);
        return desc_1;
    }
    /**
     * this function format description 1 in pdffile
     * @return desc_2 Chunk object of pdffile
     */
    public Chunk format_descr_2(){
        Font font_normal = FontFactory.getFont(desc_font, desc_fontsize, default_fontcolor);
        
        Chunk desc_2 = new Chunk(getDescr_2(), font_normal);
        return desc_2;
    }
    
    
    /**
     * this function format table headers
     * @param pdfcell
     * @return 
     */
    public PdfPCell format_table_header(PdfPCell pdfcell) {
        pdfcell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        pdfcell.setBorderWidth(2);
        pdfcell.setMinimumHeight(20);
        return pdfcell;
    }

    /**
     * this function format table rows
     *
     * @param pdfcell PDFPcell object of pdf file
     * @return 
     */
    public PdfPCell format_rows(PdfPCell pdfcell) {
        pdfcell.setHorizontalAlignment(Element.ALIGN_CENTER);
        pdfcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return pdfcell;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescr_1() {
        return descr_1;
    }

    public String getDescr_2() {
        return descr_2;
    }
}
