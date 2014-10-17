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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jas
 */
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

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * A simple demonstration application showing how to create a bar chart.
 *
 */
public class WorkoutChart extends ApplicationFrame {
    
    ArrayList<String> day = new ArrayList<>();
    ArrayList<Double> calori = new ArrayList<>();
    ArrayList<Double> dur = new ArrayList<>();
    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public WorkoutChart(String title) {

        super(title);

        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(100,150));
        setContentPane(chartPanel);

    }

    /**
     * Returns a sample dataset.
     * 
     * @return The dataset.
     */
    @SuppressWarnings("empty-statement")
    public CategoryDataset createDataset() {
        
        
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                    /*st = conn.prepareStatement();*/
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fitmon","root","april-23"); 
            Statement st = conn.createStatement(); 
            String query = "select date, sum(calories), sum(duration) from Workout group by date;";
            System.out.println(query);
            try (
                    ResultSet rs = st.executeQuery(query)) {
                    while(rs.next()){    
            
                        //Retrieve by column name
                //for (int i=0; i<4; i++){           
                        String date = (rs.getString("date"));
                        day.add(date);
                        System.out.println(day.get(0));
                        Double cal = (rs.getDouble("sum(calories)"));
                        calori.add(0.2*cal);
                        System.out.println(calori.get(0));

                        double duration = (rs.getDouble("sum(duration)"));
                        dur.add(duration);
                //}
                    }
                }
            
            
                    
        }catch(ClassNotFoundException | SQLException e){
          JOptionPane.showMessageDialog(this,"Error");
          
        }
        
        // row keys...
        String series1 = "Calories";
        String series2 = "Hours_Exercised";
        //final String series3 = "Third";

        // column keys...
        
        String category1 = day.get(0);
        String category2 = day.get(1);
        String category3 = day.get(2);
        String category4 = day.get(3);
        //String category5 = day.get(4);
        
        // create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(calori.get(0), series1, category1);
        dataset.addValue(calori.get(1), series1, category2);
        dataset.addValue(calori.get(2), series1, category3);
        dataset.addValue(calori.get(3),series1, category4);
        //dataset.addValue(calori.get(4),series1, category5);

        dataset.addValue(dur.get(0), series2, category1);
        dataset.addValue(dur.get(1), series2, category2);
        dataset.addValue(dur.get(2), series2, category3);
        dataset.addValue(dur.get(3), series2, category4);
        //dataset.addValue(dur.get(4), series2, category5);

//        dataset.addValue(4.0, series3, category1);
//        dataset.addValue(3.0, series3, category2);
//        dataset.addValue(2.0, series3, category3);
//        dataset.addValue(3.0, series3, category4);
//        dataset.addValue(6.0, series3, category5);
              
    return dataset;
        
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    public JFreeChart createChart(CategoryDataset dataset) {
        
        // create the chart...
        JFreeChart chart = ChartFactory.createBarChart(
            "weekly workout",         // chart title
            "Date",               // domain axis label
            "Performance",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(25,200 );

        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.ORANGE, 
            0.0f, 0.0f, Color.lightGray
        );
        GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.PINK, 
            0.0f, 0.0f, Color.lightGray
        );
        GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
//    public static void main(String[] args) {
//
//        WorkoutChart demo = new WorkoutChart("Workout Chart Demo");
//        demo.pack();
//        RefineryUtilities.centerFrameOnScreen(demo);
//        demo.setVisible(true);
//
//    }

}




