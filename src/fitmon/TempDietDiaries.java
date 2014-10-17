/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aarthi
 */
public class TempDietDiaries extends javax.swing.JFrame {
    
    private String flagDate="";
    private int flag = 0;
    private UserSession usrSession;
    /**
     * Creates new form TempDietDiaries
     */
    public TempDietDiaries() {
        initComponents();
        breakfastTablePanel.setVisible(false);
        lunchTablePanel.setVisible(false);
        snacksTablePanel.setVisible(false);
        dinnerTablePanel.setVisible(false);
        breakfastTable.getColumnModel().getColumn(0).setPreferredWidth(300);
        breakfastTable.getColumnModel().getColumn(1).setPreferredWidth(75);
        breakfastTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        dinnerTable.getColumnModel().getColumn(0).setPreferredWidth(175);
        dinnerTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        lunchTable.getColumnModel().getColumn(0).setPreferredWidth(175);
        lunchTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        snacksTable.getColumnModel().getColumn(0).setPreferredWidth(175);
        snacksTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        breakfastTablePanel.setLocation(150, 150);
    }

    public TempDietDiaries(UserSession usrSession) {
        initComponents();
        this.usrSession = usrSession;
        breakfastTablePanel.setVisible(false);
        lunchTablePanel.setVisible(false);
        snacksTablePanel.setVisible(false);
        dinnerTablePanel.setVisible(false);
        breakfastTable.getColumnModel().getColumn(0).setPreferredWidth(175);
        breakfastTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        breakfastTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        dinnerTable.getColumnModel().getColumn(0).setPreferredWidth(175);
        dinnerTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        lunchTable.getColumnModel().getColumn(0).setPreferredWidth(175);
        lunchTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        snacksTable.getColumnModel().getColumn(0).setPreferredWidth(175);
        snacksTable.getColumnModel().getColumn(1).setPreferredWidth(175);
        breakfastTablePanel.setLocation(150, 150);
       
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        breakfastTablePanel = new javax.swing.JPanel();
        breakfastLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        breakfastTable = new javax.swing.JTable();
        snacksTablePanel = new javax.swing.JPanel();
        snacksLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        snacksTable = new javax.swing.JTable();
        lunchTablePanel = new javax.swing.JPanel();
        lunchLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lunchTable = new javax.swing.JTable();
        dinnerTablePanel = new javax.swing.JPanel();
        dinnerLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        dinnerTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setAutoscrolls(true);
        mainPanel.setPreferredSize(new java.awt.Dimension(950, 811));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Your Food Diary For:  ");

        jDateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserjCalendarPropertyChange(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Meal");

        jLabel3.setBackground(new java.awt.Color(0, 51, 153));
        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("  Quantity");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(0, 51, 153));
        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Calories");
        jLabel4.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(0, 51, 153));
        jLabel9.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("   Fat");
        jLabel9.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(0, 51, 153));
        jLabel10.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("   Protein");
        jLabel10.setOpaque(true);

        jLabel11.setBackground(new java.awt.Color(0, 51, 153));
        jLabel11.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("   Carbs");
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(0, 51, 153));
        jLabel12.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("  Fiber");
        jLabel12.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(0, 51, 153));
        jLabel13.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("  Sodium");
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(0, 51, 153));
        jLabel14.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("  Sugar");
        jLabel14.setOpaque(true);

        jLabel15.setBackground(new java.awt.Color(0, 51, 153));
        jLabel15.setFont(new java.awt.Font("Calibri Light", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("  Cholesterol");
        jLabel15.setOpaque(true);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        breakfastTablePanel.setBackground(new java.awt.Color(204, 204, 255));

        breakfastLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        breakfastLabel.setForeground(new java.awt.Color(0, 51, 153));
        breakfastLabel.setText("jLabel5");

        breakfastTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ));
        jScrollPane2.setViewportView(breakfastTable);

        javax.swing.GroupLayout breakfastTablePanelLayout = new javax.swing.GroupLayout(breakfastTablePanel);
        breakfastTablePanel.setLayout(breakfastTablePanelLayout);
        breakfastTablePanelLayout.setHorizontalGroup(
            breakfastTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(breakfastTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(breakfastTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addGroup(breakfastTablePanelLayout.createSequentialGroup()
                        .addComponent(breakfastLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        breakfastTablePanelLayout.setVerticalGroup(
            breakfastTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(breakfastTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(breakfastLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        snacksTablePanel.setBackground(new java.awt.Color(204, 204, 255));

        snacksLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        snacksLabel.setForeground(new java.awt.Color(0, 51, 153));
        snacksLabel.setText("jLabel5");

        snacksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ));
        jScrollPane4.setViewportView(snacksTable);

        javax.swing.GroupLayout snacksTablePanelLayout = new javax.swing.GroupLayout(snacksTablePanel);
        snacksTablePanel.setLayout(snacksTablePanelLayout);
        snacksTablePanelLayout.setHorizontalGroup(
            snacksTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(snacksTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(snacksTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(snacksTablePanelLayout.createSequentialGroup()
                        .addComponent(snacksLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        snacksTablePanelLayout.setVerticalGroup(
            snacksTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(snacksTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(snacksLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        lunchTablePanel.setBackground(new java.awt.Color(204, 204, 255));

        lunchLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        lunchLabel.setForeground(new java.awt.Color(0, 51, 153));
        lunchLabel.setText("jLabel5");

        lunchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ));
        jScrollPane3.setViewportView(lunchTable);

        javax.swing.GroupLayout lunchTablePanelLayout = new javax.swing.GroupLayout(lunchTablePanel);
        lunchTablePanel.setLayout(lunchTablePanelLayout);
        lunchTablePanelLayout.setHorizontalGroup(
            lunchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lunchTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lunchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lunchTablePanelLayout.createSequentialGroup()
                        .addComponent(lunchLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        lunchTablePanelLayout.setVerticalGroup(
            lunchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lunchTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lunchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );

        dinnerTablePanel.setBackground(new java.awt.Color(204, 204, 255));

        dinnerLabel.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        dinnerLabel.setForeground(new java.awt.Color(0, 51, 153));
        dinnerLabel.setText("jLabel5");

        dinnerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ));
        jScrollPane5.setViewportView(dinnerTable);

        javax.swing.GroupLayout dinnerTablePanelLayout = new javax.swing.GroupLayout(dinnerTablePanel);
        dinnerTablePanel.setLayout(dinnerTablePanelLayout);
        dinnerTablePanelLayout.setHorizontalGroup(
            dinnerTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dinnerTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dinnerTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dinnerTablePanelLayout.createSequentialGroup()
                        .addComponent(dinnerLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        dinnerTablePanelLayout.setVerticalGroup(
            dinnerTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dinnerTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dinnerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dinnerTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(breakfastTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lunchTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(snacksTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(breakfastTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lunchTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(snacksTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dinnerTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooserjCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserjCalendarPropertyChange
        // TODO add your handling code here:

         if(jDateChooser.getDate() != null)
        {
            if(!(flagDate.equals(jDateChooser.getDate().getYear()+1900+"-"+String.valueOf(jDateChooser.getDate().getMonth()+1)+"-"+jDateChooser.getDate().getDate()))|| flag!=1)
            {
                breakfastTablePanel.setVisible(false);
                lunchTablePanel.setVisible(false);
                snacksTablePanel.setVisible(false);
                dinnerTablePanel.setVisible(false);
                clearTables((DefaultTableModel) breakfastTable.getModel());
                clearTables((DefaultTableModel) lunchTable.getModel());
                clearTables((DefaultTableModel) snacksTable.getModel());
                clearTables((DefaultTableModel) dinnerTable.getModel());
                DietDiary dDiary = new DietDiary();
            int userId = usrSession.getUserID();
            try {
                dDiary.setDietDiary(jDateChooser.getDate().getYear()+1900+"-"+String.valueOf(jDateChooser.getDate().getMonth()+1)+"-"+jDateChooser.getDate().getDate(), userId);
            } catch (SQLException ex) {
                Logger.getLogger(DietDiaries.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(!dDiary.mealHM.get("breakfast").isEmpty() || !dDiary.mealHM.get("lunch").isEmpty() || !dDiary.mealHM.get("snacks").isEmpty() || !dDiary.mealHM.get("dinner").isEmpty())
            {
                
                fillTable(breakfastTable,"breakfast", dDiary, breakfastTablePanel, breakfastLabel);
                fillTable(lunchTable,"lunch", dDiary, lunchTablePanel, lunchLabel);
                fillTable(snacksTable,"snacks", dDiary, snacksTablePanel, snacksLabel);
                fillTable(dinnerTable,"dinner", dDiary, dinnerTablePanel, dinnerLabel);
                
            }
            flagDate=jDateChooser.getDate().getYear()+1900+"-"+String.valueOf(jDateChooser.getDate().getMonth()+1)+"-"+jDateChooser.getDate().getDate();
            flag=1;
            }
            
        }
    }//GEN-LAST:event_jDateChooserjCalendarPropertyChange

     public void clearTables(DefaultTableModel dm)
    {
                int rowCount=dm.getRowCount();
                if(rowCount!=0)
                {
                    for(int i = rowCount - 1; i >=0; i--)
                    {
                       dm.removeRow(i); 
                    }
                }
    }
    
    public void fillTable(JTable table, String meal, DietDiary dDiary, JPanel panel, JLabel label)
    {
        if(!dDiary.mealHM.get(meal).isEmpty())
                {
                    ArrayList<Food> foodList = dDiary.mealHM.get(meal);
                    label.setText(Character.toUpperCase(meal.charAt(0)) + meal.substring(1));
                    for(Food f : foodList)
                    {
                    Object[] row = {f.getItemName(), f.getQuantity(), f.getCalories(), f.getFat(), f.getProtein(), f.getCarbs(), f.getFiber(), f.getSodium(), f.getSugar(), f.getCholesterol()};
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(row);
                    }
                    panel.setVisible(true);
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
            java.util.logging.Logger.getLogger(TempDietDiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TempDietDiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TempDietDiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TempDietDiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TempDietDiaries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel breakfastLabel;
    private javax.swing.JTable breakfastTable;
    private javax.swing.JPanel breakfastTablePanel;
    private javax.swing.JLabel dinnerLabel;
    private javax.swing.JTable dinnerTable;
    private javax.swing.JPanel dinnerTablePanel;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lunchLabel;
    private javax.swing.JTable lunchTable;
    private javax.swing.JPanel lunchTablePanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel snacksLabel;
    private javax.swing.JTable snacksTable;
    private javax.swing.JPanel snacksTablePanel;
    // End of variables declaration//GEN-END:variables
}
