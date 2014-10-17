/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;


//json import
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jas
 */
public class WorkoutData {
    
    private Notification note;
    private String workout;
    private String intensity;
    private int minutes;
    private double calories;
    private String date;
    
    
    public WorkoutData(String workout, String intensity, int minutes, double calories, String date)
    {
        this.workout = workout;
        this.intensity = intensity;
        this.minutes = minutes;
        this.calories = calories;
        this.date = date;
    }
    
    public WorkoutData()
    {
    }
   
    public String getWorkout()
    {
        return workout;
    }
    public String getIntensity()
    {
        return intensity;
    }
    public int getMinutes()
    {
        return minutes;
    }
    public double getCalories()
    {
        return calories;
    }
    public String getDate()
    {
        return date;
    }

    
    public void addData(String workout, String intensity, int minutes, double calories, String date, int userId) throws IOException, NoSuchAlgorithmException, InvalidKeyException, JSONException, SQLException, ClassNotFoundException{
        
        
        //ArrayList arr = new ArrayList(al);
        PreparedStatement st = null;
        Connection conn = null;

        
        
    
    try{
          Class.forName("com.mysql.jdbc.Driver");
          conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fitmon","root","april-23");
          String query = "INSERT into workout (type,calories,date,intensity,duration,userId) values (?,?,?,?,?,?);";
          st = conn.prepareStatement(query);
          conn.setAutoCommit(false);
          
          //st.setInt(1,7);
          st.setString(1,workout);
          st.setDouble(2, calories);
          st.setString(3,date);
          st.setString(4,intensity );
          st.setInt(5,minutes);
          st.setInt(6,userId);
          st.addBatch();
          st.executeBatch();
          
          conn.commit();
          System.out.println("Record is inserted into workout table!");

          
          st.close();
          conn.close();
          
      }
      catch (SQLException e) {
 
			System.out.println(e.getMessage());
			conn.rollback();
      }finally {
 
			if (st != null) {
				st.close();
			}
 
			if (conn != null) {
				conn.close();
			}
 
      }
 
    }   // TODO add your handling code here:
    
    public ArrayList<ArrayList> getTotalCaloriesBurned(int userId) throws SQLException
    {
         PreparedStatement st = null;
        Connection conn = null;
        ArrayList<ArrayList> calBurnedList = new ArrayList<ArrayList>();
        try
        {
            String query = "select date,sum(calories) from Workout where userId="+userId+" group by date limit 5";
           Class.forName("com.mysql.jdbc.Driver");
          conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fitmon","root","april-23");
          st = conn.prepareStatement(query);
          conn.setAutoCommit(false);
         
          ArrayList calBurned= new ArrayList();
          ResultSet rs = st.executeQuery(query);
          while(rs.next()){
                calBurned = new ArrayList();
                calBurned.add(rs.getString("date"));
                calBurned.add(rs.getDouble("sum(calories)"));
                calBurnedList.add(calBurned);
          }
          st.close();
          conn.close();
          
        }catch(ClassNotFoundException ce)
        {
            ce.printStackTrace();
        }
        catch(SQLException se)
        {
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally {
 
			if (st != null) {
				st.close();
			}
 
			if (conn != null) {
				conn.close();
			}
 
      } 
       
        return calBurnedList;
    }
    
    public void workoutAdded(String date, int userId) throws SQLException
   {
       
       notifyObserver(date, userId);
   }
   
   public double calBurned(String date, int userId) throws SQLException
   {
       PreparedStatement st = null;
        Connection conn = null;
        double calBurned = 0;
       try
        {
            String query = "select date,sum(calories) from Workout where userId="+userId+" and date='"+date+"'";
           Class.forName("com.mysql.jdbc.Driver");
          conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fitmon","root","april-23");
          st = conn.prepareStatement(query);
          conn.setAutoCommit(false);
          ResultSet rs = st.executeQuery(query);
          while(rs.next()){
                
                calBurned = rs.getDouble("sum(calories)");
                
          }
          st.close();
          conn.close();
          
        }catch(ClassNotFoundException ce)
        {
            ce.printStackTrace();
        }
        catch(SQLException se)
        {
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally {
 
			if (st != null) {
				st.close();
			}
 
			if (conn != null) {
				conn.close();
			}
 
      } 
       return calBurned;
   }
   
   public void notifyObserver(String date, int userId) throws SQLException
   {
       note = new Notification();
       WorkoutData wktdata = new WorkoutData();
       ArrayList calBurnedList = new ArrayList();
       calBurnedList.add(date);
       calBurnedList.add(userId);
       calBurnedList.add(calBurned(date,userId));
       note.update(wktdata, calBurnedList);
   }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, JSONException, SQLException, ClassNotFoundException{
//        ArrayList al = new ArrayList();
//        WorkoutData wktd = new WorkoutData();
//        wktd.addData(al);
    }
}