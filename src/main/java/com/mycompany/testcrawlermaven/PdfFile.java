/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
// import arraylist with elements
import static com.mycompany.testcrawlermaven.ElementMethods.Offers_tab;
import java.awt.Color;
import java.util.stream.Stream;

/**
 *
 * @author adamr
 */
public class PdfFile {

    private final String path;

    public PdfFile(String path) {
        this.path = path;
    }

    public void create_pdf_file(String position, String location, int count_offers) throws FileNotFoundException, DocumentException {
        // create table model like the same in appliacation
        TableModel my = new TableModel();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        // add title, subtitle and information for table
        Font font_title = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Font font_subtitle = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12, BaseColor.BLACK);
        Font font_normal = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
        Chunk title = new Chunk("Oferty pracy z portali:", font_title);
        Chunk subtitle = new Chunk("Justjoin.it oraz NoFluffjobs.pl", font_subtitle);
        Chunk description_1 = new Chunk("Szukane oferty na stanowisko: " + position, font_normal);
        Chunk description_2 = new Chunk("w lokalizacji " + location, font_normal);
        Chunk offers_count = new Chunk("Znaleziono "+ count_offers + " ofert" , font_normal);
        // add chunks
        document.add(title);
        document.add(new Paragraph("\n"));
        document.add(subtitle);
        document.add(new Paragraph("\n"));
        document.add(description_1);
        document.add(new Paragraph("\n"));
        document.add(description_2);
        document.add(new Paragraph("\n"));
        document.add(offers_count);
        //create  pdf table has the same column like table model in appliacation
        PdfPTable table = new PdfPTable(my.getColumnCount());
        addTableHeader(table, my);
        addRows(table);
        // customize table rows
        addCustomRows(table,my);
        document.add(table);
        document.close();
        

    }

    private void addTableHeader(PdfPTable table, TableModel model) {
        for (int i = 0; i < model.getColumnCount(); i++) {
            Stream.of(model.getColumnName(i))
                    .forEach(columnTitle -> {
                        PdfPCell header = new PdfPCell();
                        // color dark blue
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setBorderWidth(2);
                        header.setPhrase(new Phrase(columnTitle));
                        table.addCell(header);
                    });
        }
    }

    private void addRows(PdfPTable table) {
        for (TableElement el : Offers_tab) {
            table.addCell(el.Position);
            table.addCell(el.Localization);
            table.addCell(el.Company);
            table.addCell(el.Salary_range);
        }
    }

    private void addCustomRows(PdfPTable table, TableModel model) {

        for (int j = 0; j < model.getColumnCount (); j++) {
            for (int i = 0; i < Offers_tab.size(); i++) {
                String phrase = "row " + i + ", col " + j;
                PdfPCell horizontalAlignCell = new PdfPCell(new Phrase(phrase));
                horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(horizontalAlignCell);

                PdfPCell verticalAlignCell = new PdfPCell(new Phrase(phrase));
                verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
                table.addCell(verticalAlignCell);
            }

        }
    }
}
