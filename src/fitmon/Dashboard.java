package fitmon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jas
 */
// bar-chart
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.awt.Panel;
import java.awt.BorderLayout;

//pie-chart
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Dashboard extends javax.swing.JFrame {

    private UserSession usrSession;
    private static int userId;
    private Notification note;
    //private Notification note;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        // Bar-chart 
        WorkoutChart demo = new WorkoutChart("weekly workout");
        CategoryDataset ds = demo.createDataset();
        JFreeChart chart = demo.createChart(ds);
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500,300));
        bar_panel.setLayout(new java.awt.BorderLayout());

        bar_panel.add(panel,BorderLayout.NORTH);
        bar_panel.getParent().validate();
        
        // pie-chart
        PieChart pie = new PieChart("weekly workout");
        PieDataset ps = pie.createDataset();
        JFreeChart pie_chart = pie.createChart(ps);
        
        ChartPanel panel2 = new ChartPanel(pie_chart);
        panel2.setPreferredSize(new Dimension(500,300));
        pie_panel.setLayout(new java.awt.BorderLayout());
        
        noteButton1.setVisible(false);
        noteButton2.setVisible(false);
        noteButton3.setVisible(false);
        noteButton4.setVisible(false);
        noteButton5.setVisible(false);
        
        pie_panel.add(panel2);
        pie_panel.getParent().validate();
        displayNotifications();

       // setContentPane(dashpanel);
    }
    
    public Dashboard(UserSession usrSession)
    {
        initComponents();
        // Bar-chart 
        WorkoutChart demo = new WorkoutChart("weekly workout");
        CategoryDataset ds = demo.createDataset();
        JFreeChart chart = demo.createChart(ds);
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500,300));
        bar_panel.setLayout(new java.awt.BorderLayout());

        bar_panel.add(panel,BorderLayout.NORTH);
        bar_panel.getParent().validate();
        
        // pie-chart
        PieChart pie = new PieChart("weekly workout");
        PieDataset ps = pie.createDataset();
        JFreeChart pie_chart = pie.createChart(ps);
        
        ChartPanel panel2 = new ChartPanel(pie_chart);
        panel2.setPreferredSize(new Dimension(500,300));
        pie_panel.setLayout(new java.awt.BorderLayout());

        pie_panel.add(panel2);
        pie_panel.getParent().validate();
        
        noteButton1.setVisible(false);
        noteButton2.setVisible(false);
        noteButton3.setVisible(false);
        noteButton4.setVisible(false);
        noteButton5.setVisible(false);

        this.usrSession = usrSession;
        userId = usrSession.getUserID();
        displayNotifications();
    }

    
    public void displayNotifications()
    {
        
                ArrayList<String> notes = new ArrayList<String>();
                ArrayList<ArrayList> notesList;
                
                try {
                    Notification note = new Notification();
                    notesList = note.checkCalorieDeficitAchieved(userId);
                   
                    if(notesList.size()>0)
                    {
                        noteButton1.setText((String)notesList.get(0).get(0)+"--"+(String)notesList.get(0).get(1));
                        noteButton1.setVisible(true);
                    }
                    
                    if(notesList.size()>1)
                    {
                        noteButton2.setText((String)notesList.get(1).get(0)+"--"+(String)notesList.get(1).get(1));
                        noteButton2.setVisible(true);
                    }
                    
                     if(notesList.size()>2)
                    {
                        noteButton3.setText((String)notesList.get(2).get(0)+"--"+(String)notesList.get(2).get(1));
                        noteButton3.setVisible(true);
                    }
                     
                     if(notesList.size()>3)
                    {
                        noteButton4.setText((String)notesList.get(3).get(0)+"--"+(String)notesList.get(3).get(1));
                        noteButton4.setVisible(true);
                    }
                     
                      if(notesList.size()>4)
                    {
                        noteButton5.setText((String)notesList.get(4).get(0)+"--"+(String)notesList.get(4).get(1));
                        noteButton5.setVisible(true);
                    }
                   
                } catch (SQLException ex) {
                    Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashpanel = new javax.swing.JPanel();
        bar_panel = new javax.swing.JPanel();
        pie_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noteButton5 = new javax.swing.JButton();
        noteButton1 = new javax.swing.JButton();
        noteButton4 = new javax.swing.JButton();
        noteButton2 = new javax.swing.JButton();
        noteButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dashpanel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout bar_panelLayout = new javax.swing.GroupLayout(bar_panel);
        bar_panel.setLayout(bar_panelLayout);
        bar_panelLayout.setHorizontalGroup(
            bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );
        bar_panelLayout.setVerticalGroup(
            bar_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pie_panelLayout = new javax.swing.GroupLayout(pie_panel);
        pie_panel.setLayout(pie_panelLayout);
        pie_panelLayout.setHorizontalGroup(
            pie_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pie_panelLayout.setVerticalGroup(
            pie_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Notifications");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Daily Calorific Deficit");

        noteButton5.setBackground(new java.awt.Color(204, 204, 204));
        noteButton5.setText("jButton1");
        noteButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButton5ActionPerformed(evt);
            }
        });

        noteButton1.setBackground(new java.awt.Color(204, 204, 204));
        noteButton1.setText("jButton1");
        noteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButton1ActionPerformed(evt);
            }
        });

        noteButton4.setBackground(new java.awt.Color(204, 204, 204));
        noteButton4.setText("jButton1");
        noteButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButton4ActionPerformed(evt);
            }
        });

        noteButton2.setBackground(new java.awt.Color(204, 204, 204));
        noteButton2.setText("jButton1");
        noteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButton2ActionPerformed(evt);
            }
        });

        noteButton3.setBackground(new java.awt.Color(204, 204, 204));
        noteButton3.setText("jButton1");
        noteButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashpanelLayout = new javax.swing.GroupLayout(dashpanel);
        dashpanel.setLayout(dashpanelLayout);
        dashpanelLayout.setHorizontalGroup(
            dashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashpanelLayout.createSequentialGroup()
                .addComponent(bar_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pie_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dashpanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(dashpanelLayout.createSequentialGroup()
                .addGroup(dashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(noteButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noteButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noteButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noteButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(noteButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(504, 504, 504))
        );
        dashpanelLayout.setVerticalGroup(
            dashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashpanelLayout.createSequentialGroup()
                .addGroup(dashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pie_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bar_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dashpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noteButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteButton5ActionPerformed

    private void noteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteButton1ActionPerformed

    private void noteButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteButton4ActionPerformed

    private void noteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteButton2ActionPerformed

    private void noteButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                
                WorkoutChart demo = new WorkoutChart("weekly workout");
                CategoryDataset ds = demo.createDataset();
                JFreeChart chart = demo.createChart(ds);
                ChartPanel panel = new ChartPanel(chart);
                
                PieChart pie = new PieChart("weekly workout");
                PieDataset ps = pie.createDataset();
                JFreeChart pie_chart = pie.createChart(ps);
                ChartPanel panel2 = new ChartPanel(pie_chart);
                
                
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bar_panel;
    private javax.swing.JPanel dashpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton noteButton1;
    private javax.swing.JButton noteButton2;
    private javax.swing.JButton noteButton3;
    private javax.swing.JButton noteButton4;
    private javax.swing.JButton noteButton5;
    private javax.swing.JPanel pie_panel;
    // End of variables declaration//GEN-END:variables
}
