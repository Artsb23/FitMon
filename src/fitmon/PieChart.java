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

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

/**
 * A simple demonstration application showing how to create a pie chart using 
 * data from a {@link DefaultPieDataset}.
 */
public class PieChart extends ApplicationFrame {

    /**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    WorkoutChart wkt_ch = new WorkoutChart("hi");
    //ArrayList<String day = new ArrayList<>();
    Double protein = 0.0;
    Double fat = 0.0;
    Double carbo = 0.0;
    Double fiber = 0.0;
    
    public PieChart(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    /**
     * Creates a sample dataset.
     * 
     * @return A sample dataset.
     */
    public PieDataset createDataset() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                    /*st = conn.prepareStatement();*/
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fitmon","root","april-23"); 
            Statement st = conn.createStatement(); 
            String query = "select sum(protein), sum(carbs), sum(fat), sum(fiber)from Diet group by date limit 5 ;";
            System.out.println(query);
            try (
                    ResultSet rs = st.executeQuery(query)) {
                    while(rs.next()){    
            
                        //Retrieve by column name
                //for (int i=0; i<4; i++){ 
                        
                        Double prot= rs.getDouble("sum(protein)");
                        protein += prot;
                        System.out.println(protein);
                        Double carb = (rs.getDouble("sum(carbs)"));
                        carbo += carb;
                        Double fats = (rs.getDouble("sum(fat)"));
                        fat += fats;
                        Double fib = (rs.getDouble("sum(fiber)"));
                        fiber += fib;

                        
                //}
                    }
                }
            
            
                    
        }catch(ClassNotFoundException | SQLException e){
          JOptionPane.showMessageDialog(this,"Error");
          
        }
        
        
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue(protein,protein);
        dataset.setValue(carbo,carbo);
        dataset.setValue(fiber,fiber);
        dataset.setValue(fat,fat);
        //dataset.setValue("Five", new Double(11.0));
        //dataset.setValue("Six", new Double(19.4));
        return dataset;        
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return A chart.
     */
    public static JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Food Stat of the Week",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
    
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     * 
     * @return A panel.
     */
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {

        PieChart demo = new PieChart("Food Stat of the Day");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}
