/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.testcrawlermaven;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is main window for program
 * @author adamr
 */
public class Okno extends javax.swing.JFrame {

    /**
     * position searching job position from textbox
     */
    public static String position;
    /**
     * location searching job localization from textbox
     */
    public static String location;
    /**
     * Default Tbale model for Jtable on startup
     */
    public TableModel DefaultTableModel = new TableModel();

    /**
     * Constructor get 2 methods initComponents which creates components create
     * default table template
     */
    public Okno() {
        initComponents();
        // set column names for table
        OffersTable.setModel(DefaultTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchButt = new javax.swing.JButton();
        PositionText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        LocationText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        OffersTable = new javax.swing.JTable();
        Down_state_label = new javax.swing.JLabel();
        SortAscButton = new javax.swing.JButton();
        SortDescButton = new javax.swing.JButton();
        PdfButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SearchButt.setText("Wyszukaj");
        SearchButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtActionPerformed(evt);
            }
        });

        PositionText.setText("Stanowisko");
        PositionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionTextActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Wyszukiwarka ofert pracy z okreslonymi widełkami ze stron: https://justjoin.it/ oraz https://nofluffjobs.com/pl");
        jLabel1.setToolTipText("");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        LocationText.setText("Lokalizacja");
        LocationText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationTextActionPerformed(evt);
            }
        });

        OffersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(OffersTable);

        Down_state_label.setText("Dane niewczytane");
        Down_state_label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Down_state_labelKeyPressed(evt);
            }
        });

        SortAscButton.setText("Sortuj od najmniejszych pensji");
        SortAscButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortAscButtonActionPerformed(evt);
            }
        });

        SortDescButton.setText("Sortuj od największych pensji");
        SortDescButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortDescButtonActionPerformed(evt);
            }
        });

        PdfButt.setText("Zapisz do pdf");
        PdfButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PdfButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(SortDescButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SortAscButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Down_state_label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PositionText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LocationText, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(SearchButt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PdfButt)
                                .addGap(16, 16, 16))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PositionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LocationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButt)
                    .addComponent(PdfButt))
                .addGap(4, 4, 4)
                .addComponent(Down_state_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SortDescButton)
                    .addComponent(SortAscButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * this function is for searching job offers and saving it to jTable
     * compnonent
     *
     * @param evt
     */
    private void SearchButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtActionPerformed
        // table model
        TableModel my = new TableModel();
        position = PositionText.getText();
        location = LocationText.getText();
        // get offers from urls
        WebsiteElement web1 = FactoryWebsiteElement.build(FactoryWebsiteElement.website_names[0], position, location);
        web1.create_get_job_offers_url();
        web1.get_offers();
        WebsiteElement web2 = FactoryWebsiteElement.build(FactoryWebsiteElement.website_names[1], position, location);
        web2.create_get_job_offers_url();
        web2.get_offers();
        // set data to Table
        OffersTable.setModel(my);
        // refresh Table
        OffersTable.repaint();
        // set visibility of down_state_label to false
        Down_state_label.setText("Oferty wczytane. Ilość ofert: " + OffersTable.getRowCount());

    }//GEN-LAST:event_SearchButtActionPerformed

    private void PositionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PositionTextActionPerformed

    private void LocationTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocationTextActionPerformed
    /**
     * this function sorting Jtable elements form highest to lowest
     *
     * @param evt
     */
    private void SortDescButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortDescButtonActionPerformed
        // table model
        TableModel my = new TableModel();
        ElementMethods.sort_desc();
        // set data to Table
        OffersTable.setModel(my);
        OffersTable.repaint();
    }//GEN-LAST:event_SortDescButtonActionPerformed
    /**
     * this function sorting Jtable elements form lowest to highest
     *
     * @param evt
     */
    private void SortAscButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortAscButtonActionPerformed
        // table model
        TableModel my = new TableModel();
        ElementMethods.sort_asc();
        // set data to Table
        OffersTable.setModel(my);
        OffersTable.repaint();
    }//GEN-LAST:event_SortAscButtonActionPerformed
    /**
     * this function saving pdf file in path selected by user
     *
     * @param evt
     */
    private void PdfButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PdfButtActionPerformed
        // parent component of the dialog
        JFrame parentFrame = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save don't write .pdf in the end");

        int userSelection = fileChooser.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // create pdf file in selected path with .pdf extensions
            String string_path = fileToSave.getAbsolutePath() + ".pdf";
            Path path = Paths.get(string_path);
            if (Files.exists(path) && !Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                int option_choose = JOptionPane.showConfirmDialog(parentFrame, "This file exists, overwrite file?", "Choose one", JOptionPane.YES_NO_OPTION);
                System.out.println(option_choose);
                // if yes option
                if (option_choose == JOptionPane.YES_OPTION) {
                    create_pdf_file(string_path);
                } else {
                    JOptionPane.showMessageDialog(null, "Nie zapisano pliku", "Set no option", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                create_pdf_file(string_path);
            }
        }
    }//GEN-LAST:event_PdfButtActionPerformed

    private void Down_state_labelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Down_state_labelKeyPressed

    }//GEN-LAST:event_Down_state_labelKeyPressed
    /**
     * this function save pdf file in selected path
     *
     * @param path
     */
    private void create_pdf_file(String path) {
        System.out.println("Save as file: " + path);
        PdfFile pdf = new PdfFile(path);
        try {
            pdf.create_pdf_file(position, location, OffersTable.getRowCount());
            String message = "Zapisano plik pdf w ścieżce\n" + path;
            JOptionPane.showMessageDialog(null, message, "Zapisano plik pdf", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Okno.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Exception saving pdf file", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Down_state_label;
    private javax.swing.JTextField LocationText;
    private javax.swing.JTable OffersTable;
    private javax.swing.JButton PdfButt;
    private javax.swing.JTextField PositionText;
    private javax.swing.JButton SearchButt;
    private javax.swing.JButton SortAscButton;
    private javax.swing.JButton SortDescButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
