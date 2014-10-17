/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author Aarthi
 */
public abstract class Diet{
    
    private String mealType;
    private double calories=0;//calc total calories for the entire diet
    private String date;
    private static int ID;
    ArrayList<Food> foodItems = new ArrayList<Food>();
    private Food food;
    private JDBCConnection con;
    
    private ArrayList<ArrayList> calIntake;
    
    public static int generateId()
    {
        ++ID;
        return ID;
    }
    
    public void calculateTotalCalories(double calories)
    {
        this.calories+=calories;
    }
    
    public ArrayList getTotalCalories(int userId)
    {
        ArrayList dateAndCal=null;
        try
        {
            String tableName = "Diet";
            String query = "select date,sum(calories) from Diet where userId="+userId+" group by date limit 5";
            con = new JDBCConnection();
            con.makeConnection();
            dateAndCal = con.getCalories(query);
           
        }catch(SQLException se)
        {
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        } finally{
            con.closeConnection();
        }
       
        return dateAndCal;
    }
   
   public double getCalIntake(String date, int userId)
   {
       
      double dateAndCal=0;
        try
        {
            String tableName = "Diet";
            String query = "select date,sum(calories) from Diet where userId="+userId+" and date='"+date+"'";
            con = new JDBCConnection();
            con.makeConnection();
            dateAndCal = con.getCalIntake(query);
           
        }catch(SQLException se)
        {
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        } finally{
            con.closeConnection();
        }
       
        return dateAndCal;
   }
    
    /*public void dietAdded(int userId, String date)
    {
        calIntake = getTotalCalories(userId);
        this.date = date;
        notifyObserver(this.note);
    }*/
    
    /*public void notifyObserver(Notification note)
    {
        note.update(this, calIntake);
    }*/
    
    public double getCalorieDeficit(int userId) throws SQLException
    {
        double calDeficit = 0;
        try{
            con = new JDBCConnection();
        String tableName = "Notification";
        con.makeConnection();
        calDeficit = con.getCalorieDeficit(userId);
        
        }catch(SQLException se)
        {
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        } finally{
            con.closeConnection();
        }
        return calDeficit;
    }
    
    public abstract void createDiet(Food item, String mealType, String date, int userId, int count);
    public abstract Diet getDiet();
    
}
