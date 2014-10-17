/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aarthi
 */
public class Notification {
  
    
    private Diet diet = new CustomizedDiet();
    private JDBCConnection con = new JDBCConnection();
    private RMRCalculation rmrCalc=null;
    private ArrayList<String> note = new ArrayList<String>();
    private ArrayList<ArrayList> noteList = new ArrayList<ArrayList>();
    
   
    public Notification()
    {
        
    }
    
     void update(WorkoutData wktdata, ArrayList calBurnedList) {
        updateWorkoutNotification(wktdata, calBurnedList);
    }
    
    public void updateWorkoutNotification(Object o, Object arg) {
        ArrayList a = (ArrayList)arg;
        double weight=0;
        double height=0;
        int age=0;
        int userId = (int)a.get(1);
        String date = (String)a.get(0);
        double calIntake = diet.getCalIntake(date, userId);
        double calBurned = (double)a.get(2);
        
        String gender = con.getGender(userId);
        if(gender.equals("male"))
        {
            rmrCalc = new MaleRMR();
        }
        else if(gender.equals("female"))
        {
            rmrCalc = new FemaleRMR();
        }
        con.makeConnection();
        try 
        {
            double calDeficit = diet.getCalorieDeficit(userId);
            con.getHeightAndWeight(userId);

            while(con.getResultSet().next())
            {
                weight = con.getResultSet().getDouble("currentWeight");
                height = con.getResultSet().getDouble("height");
            }
            age = con.getAge(userId);
            con.closeConnection();
            double rmr = rmrCalc.calculateRMR(weight, height, age);
            double val = calIntake-rmr+calBurned;
                    if(val >= calDeficit)
                    {
                        JOptionPane.showMessageDialog(null, "Hurray! You have reached your goal for the day.");
                    }
        } catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public ArrayList<ArrayList> checkCalorieDeficitAchieved(int userId) throws SQLException
    {
         WorkoutData wrkt = new WorkoutData();
        ArrayList<ArrayList> calIntake = diet.getTotalCalories(userId);
        double calDeficit = diet.getCalorieDeficit(userId);
        ArrayList<ArrayList> calBurned = wrkt.getTotalCaloriesBurned(userId);
        double weight=0;
        double height=0;
        int age=0;
        String gender = con.getGender(userId);
        if(gender.equals("male"))
        {
            rmrCalc = new MaleRMR();
        }
        else if(gender.equals("female"))
        {
            rmrCalc = new FemaleRMR();
        }
        con.makeConnection();
        con.getHeightAndWeight(userId);
        while(con.getResultSet().next())
        {
            weight = con.getResultSet().getDouble("currentWeight");
            height = con.getResultSet().getDouble("height");
        }
        age = con.getAge(userId);
        con.closeConnection();
        double rmr = rmrCalc.calculateRMR(weight, height, age);
        for(int i=0;i<calIntake.size();i++)
        {
            for(int j=0; j<calBurned.size();j++)
            {
                if(calIntake.get(i).get(0).equals(calBurned.get(j).get(0)))
                {
                    double val = (double)calIntake.get(i).get(1)-rmr+(double)calBurned.get(i).get(1);
                    if(val >= calDeficit)
                    {
                        note = new ArrayList<String>();
                        note.add((String)calIntake.get(i).get(0));
                        note.add("Hurray! You have reached your goal for the day.");
                        noteList.add(note);
                        System.out.println(calIntake.get(i).get(0)+"Hurray! You have reached your goal for the day.");

                    }
                    else
                    {
                        note = new ArrayList<String>();
                        note.add((String)calIntake.get(i).get(0));
                        note.add("Sorry! You have not reached your goal for the day.");
                         noteList.add(note);
                        System.out.println(calIntake.get(i).get(0)+"Sorry! You have not reached your goal for the day.");
                    }
                }
            }
        }
        return noteList;
    }
    
    public static void main(String[] args) throws SQLException
    {
        Notification note = new Notification();
        note.checkCalorieDeficitAchieved(125);
    }
}
