package fitmon;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jas
 */
public class WorkoutLog extends javax.swing.JFrame implements ActionListener {

    private UserSession usrSession;
    
    /**
     * Creates new form WorkoutLog
     */
    ArrayList<String> list = new ArrayList<>();
    ArrayList<WorkoutData> wkt = new ArrayList<>();
    HashMap<String,Integer> hm = new HashMap<>();
    WorkoutData wktd;
    
    public WorkoutLog() throws IOException, NoSuchAlgorithmException, InvalidKeyException, JSONException {
        initComponents();
        
        add.addActionListener(this);
        
        
        
        //add elements to fit combobox
        

        JsonParser jp = new JsonParser();
        list = jp.jsonExtract();
        for (int i=0; i<list.size(); i++ ) {
            fit.addItem(list.get(i));
            
        } 
        fit.setMaximumRowCount(5);
        //System.out.println(list);

    }
    
    public WorkoutLog(UserSession usrSession) throws IOException, NoSuchAlgorithmException, InvalidKeyException, JSONException {
        initComponents();
        this.usrSession = usrSession;
        add.addActionListener(this);
        
        
        
        //add elements to fit combobox
        

        JsonParser jp = new JsonParser();
        list = jp.jsonExtract();
        for (int i=0; i<list.size(); i++ ) {
            fit.addItem(list.get(i));
            
        } 
        fit.setMaximumRowCount(5);
        //System.out.println(list);

    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
          
          DefaultTableModel model = (DefaultTableModel)tab.getModel();
          DateFormat df = new SimpleDateFormat("dd MMMM yyyy");

          String workout = (String)fit.getSelectedItem();
          double cal = Double.parseDouble(callo.getText());
          String date = (time.getDate().getYear()+1900+"-"+String.valueOf(time.getDate().getMonth()+1)+"-"+time.getDate().getDate());
          String intensity = (String)level.getSelectedItem();
          int min = minutes.getValue();
          
          wktd = new WorkoutData(workout, intensity, min, cal, date);
          wkt.add(wktd);
          model.addRow(new Object[]{workout,min,intensity,cal,"Remove"});
          
          
          
          
//        try {
//            wktd.addData(wkt);
//        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | JSONException | SQLException | ClassNotFoundException ex) {
//            Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
//        }
//          
          
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fit = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        minutes = new javax.swing.JSlider();
        min = new javax.swing.JLabel();
        cal = new javax.swing.JLabel();
        callo = new javax.swing.JTextField();
        level = new javax.swing.JComboBox();
        inten = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        addanother = new javax.swing.JButton();
        table = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        log_wkt = new javax.swing.JButton();
        wkt_head = new javax.swing.JLabel();
        time = new com.toedter.calendar.JDateChooser();
        img = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("wktlog"); // NOI18N

        jPanel1.setLayout(null);

        jPanel1.add(fit);
        fit.setBounds(20, 100, 160, 40);

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 2, 14)); // NOI18N
        jLabel2.setText("Select Workout");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 80, 140, 20);

        minutes.setMajorTickSpacing(30);
        minutes.setMaximum(300);
        minutes.setMinorTickSpacing(5);
        minutes.setPaintLabels(true);
        minutes.setPaintTicks(true);
        minutes.setValue(0);
        jPanel1.add(minutes);
        minutes.setBounds(210, 100, 400, 40);

        min.setFont(new java.awt.Font("Microsoft Sans Serif", 2, 14)); // NOI18N
        min.setText("Minutes");
        jPanel1.add(min);
        min.setBounds(220, 80, 110, 16);

        cal.setFont(new java.awt.Font("Microsoft Sans Serif", 2, 14)); // NOI18N
        cal.setText("Clories Burned");
        jPanel1.add(cal);
        cal.setBounds(30, 140, 130, 20);

        callo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calloActionPerformed(evt);
            }
        });
        jPanel1.add(callo);
        callo.setBounds(20, 170, 150, 30);

        level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Low", "Moderate", "High" }));
        jPanel1.add(level);
        level.setBounds(210, 170, 90, 30);

        inten.setFont(new java.awt.Font("Microsoft Sans Serif", 2, 14)); // NOI18N
        inten.setText("Intensity");
        jPanel1.add(inten);
        inten.setBounds(220, 140, 100, 20);

        add.setText("add ");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(50, 230, 80, 30);

        addanother.setText("add another workout");
        addanother.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAnotherButton(evt);
            }
        });
        addanother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addanotherActionPerformed(evt);
            }
        });
        jPanel1.add(addanother);
        addanother.setBounds(160, 230, 160, 23);

        tab.setBackground(new java.awt.Color(204, 204, 255));
        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Workout", "Minutes", "Intensity", "Calories Burned", "Edit"
            }
        ));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeItem(evt);
            }
        });
        table.setViewportView(tab);

        jPanel1.add(table);
        table.setBounds(20, 280, 900, 240);

        log_wkt.setBackground(new java.awt.Color(204, 204, 255));
        log_wkt.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        log_wkt.setText("Save Workout");
        log_wkt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logWorkout(evt);
            }
        });
        jPanel1.add(log_wkt);
        log_wkt.setBounds(730, 530, 190, 40);

        wkt_head.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        wkt_head.setText("Log your workout for:");
        jPanel1.add(wkt_head);
        wkt_head.setBounds(200, 20, 220, 40);
        jPanel1.add(time);
        time.setBounds(420, 20, 200, 40);

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/new.png"))); // NOI18N
        jPanel1.add(img);
        img.setBounds(0, 0, 940, 600);

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(210, 30, 34, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void calloActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    }                                     

    private void addanotherActionPerformed(java.awt.event.ActionEvent evt) {                                           
            callo.setText("");
            minutes.setValue(0);
            fit.setSelectedIndex(0);
            level.setSelectedIndex(0);

// TODO add your handling code here:
    }                                          

    private void addAnotherButton(java.awt.event.MouseEvent evt) {                                  
        // TODO add your handling code here:
    }                                 

    private void removeItem(java.awt.event.MouseEvent evt) {                            
        
      if (evt.getClickCount() == 1) {
      JTable target = (JTable)evt.getSource();
      int row = target.getSelectedRow();
      int column = target.getSelectedColumn();
     String selectedwkt = (String)target.getValueAt(row, 0);
     //int index = selectedwkt.indexOf("--");
   // String foodName = selectedFood.substring(0, index);
     //int calorie = selectedFood.substring(index+2);
      if(target.getColumnName(target.getSelectedColumn()).equals("Edit"))
      {
          DefaultTableModel model = (DefaultTableModel) tab.getModel();
          model.removeRow(row);
          for(int i=0;i<wkt.size();i++)
          {
              if(wkt.get(i).getWorkout().equals(selectedwkt)) //&& wkt.get(i).getCal().equals(calorie))
              {
                    wkt.remove(i);
                    break;
              }
          }
      }
      // do some action if appropriate column
    }


// TODO add your handling code here:
    }                           

    private void logWorkout(java.awt.event.MouseEvent evt) {                            
        
        int userId = usrSession.getUserID();
        String date = null;
            for(int i=0; i<wkt.size();i++)
        {
                try {
                    date = wkt.get(i).getDate();
                    wktd.addData(wkt.get(i).getWorkout(), wkt.get(i).getIntensity(), wkt.get(i).getMinutes(),wkt.get(i).getCalories(),wkt.get(i).getDate(),userId);
                } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | JSONException | SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(WorkoutLog.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        try {
            wktd.workoutAdded(date,userId);
// TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(WorkoutLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                           

    private void addActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(WorkoutLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkoutLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkoutLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkoutLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new WorkoutLog().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(WorkoutLog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(WorkoutLog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(WorkoutLog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JSONException ex) {
                    Logger.getLogger(WorkoutLog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton add;
    private javax.swing.JButton addanother;
    private javax.swing.JLabel cal;
    private javax.swing.JTextField callo;
    private javax.swing.JComboBox fit;
    private javax.swing.JLabel img;
    private javax.swing.JLabel inten;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox level;
    private javax.swing.JButton log_wkt;
    private javax.swing.JLabel min;
    private javax.swing.JSlider minutes;
    private javax.swing.JTable tab;
    private javax.swing.JScrollPane table;
    private com.toedter.calendar.JDateChooser time;
    private javax.swing.JLabel wkt_head;
    // End of variables declaration                   
}
