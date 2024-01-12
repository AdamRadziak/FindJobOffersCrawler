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
import java.util.stream.Stream;

/**
 * this class create pdf file in selected path
 *
 * @author adamr
 */
public class PdfFile {

    private final String path;

    /**
     * COnstructor of class
     *
     * @param path String absolute path to pdf file
     */
    public PdfFile(String path) {
        this.path = path;
    }

    /**
     *
     * @param position searching job position
     * @param location localization for searching job position
     * @param count_offers count of table rows from Jtable
     * @throws DocumentException when user want to write in open document
     * @throws FileNotFoundException when file with selected path not found
     */
    public void create_pdf_file(String position, String location, int count_offers) throws FileNotFoundException, DocumentException {
        // create table model like the same in appliacation
        TableModel my = new TableModel();
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        // add title, subtitle and description for document
        addTitleSubtitle(document);
        addDescriptions(document, position, location, count_offers);
        //create  pdf table has the same column like table model in appliacation
        PdfPTable table = new PdfPTable(my.getColumnCount());
        // create TableHeader
        addTableHeader(table, my);
        addRows(table);
        document.add(table);
        document.close();

    }

    /**
     *
     * @param document Document object pdf file
     * @throws DocumentException when user want to write in open document
     */
    private void addTitleSubtitle(Document document) throws DocumentException {
        // subtitle 
        String subtitle_string = "";
        // add title, subtitle and information for table
        Font font_title = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Font font_subtitle = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 12, BaseColor.BLACK);
        Chunk title = new Chunk("Oferty pracy z portali:", font_title);
        // get subtitle from list
        for (String website_name : FactoryWebsiteElement.website_names) {
            subtitle_string = subtitle_string + website_name + ", ";
        }
        Chunk subtitle = new Chunk(subtitle_string, font_subtitle);
        // add chunks to documents
        document.add(title);
        document.add(new Paragraph("\n"));
        document.add(subtitle);
        document.add(new Paragraph("\n"));
    }

    /**
     * This function add Descriptions for pdf file
     *
     * @param document Document object pdf file
     * @param position searching job position
     * @param location searching job localization
     * @param count_offers count of table rows from Jtable
     * @throws DocumentException when user want to write in open document
     */
    private void addDescriptions(Document document, String position, String location, int count_offers) throws DocumentException {
        Font font_normal = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);
        Chunk description_1 = new Chunk("Szukane oferty na stanowisko: " + position, font_normal);
        Chunk description_2 = new Chunk(" w lokalizacji " + location, font_normal);
        Chunk offers_count = new Chunk("Znaleziono " + count_offers + " ofert", font_normal);
        // add chunks to document
        document.add(description_1);
        document.add(description_2);
        document.add(new Paragraph("\n"));
        document.add(offers_count);
        document.add(new Paragraph("\n"));

    }

    /**
     *
     * This function create TableHeaders
     *
     * @param table PdfTable object table in pdf file
     * @param model TableModel object with template of pdf table
     */
    private void addTableHeader(PdfPTable table, TableModel model) {
        for (int i = 0; i < model.getColumnCount(); i++) {
            Stream.of(model.getColumnName(i))
                    .forEach(columnTitle -> {
                        PdfPCell header = new PdfPCell();
                        // color dark blue
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setBorderWidth(2);
                        header.setMinimumHeight(20);
                        header.setPhrase(new Phrase(columnTitle));
                        table.addCell(header);
                    });
        }
    }

    /**
     * This function add rows to pdf file
     *
     * @param table PdfTable object table in pdf file
     */
    private void addRows(PdfPTable table) {
        for (TableElement el : Offers_tab) {
            // customize cell
            PdfPCell PositionCell = new PdfPCell(new Phrase(el.Position));
            PositionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            PositionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(PositionCell);
            // customize cell
            PdfPCell LocalizationCell = new PdfPCell(new Phrase(el.Localization));
            PositionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            PositionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(LocalizationCell);
            // customize cell
            PdfPCell CompanyCell = new PdfPCell(new Phrase(el.Company));
            PositionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            PositionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(CompanyCell);
            // customize cell
            PdfPCell SalaryCell = new PdfPCell(new Phrase(el.Salary_range));
            PositionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            PositionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(SalaryCell);
        }
    }

}
