/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.sql.SQLException;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
/**
 *
 * @author Aarthi
 */
public class UserModel {
    protected String firstName;
    protected String lastName;
    protected String gender;
    protected int age;
    protected int userId;
    protected double height;
    protected double weight;
    protected String pkg;
    protected String email;
    protected String password;
    protected double targetWeight;
    protected int targetDate;
    protected double calorieDeficit;
    protected JDBCConnection con = new JDBCConnection();
    private RMRCalculation rmrCalc=null;
    
    public void addUser(String fname, String lname, String gender, int age, String email, String password) throws SQLException
    {
         this.firstName = fname;
        this.lastName = lname;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.pkg = pkg;
        this.password = password;
        String query = "(fname, lname, gender, age, email, package, password)";
        String values = "values('"+fname+"','"+lname+"','"+gender+"',"+age+",'"+email+"','"+pkg+"','"+password+"')";
        //con.insertFunction("User", query+" "+values);
        con.dbOperation("insert", "User", query+" "+values);
    }
    
    
    public void setUserDetails(double height, double currentWeight, double targetWeight, int targetDate, String date, int userId) throws SQLException
    {
        this.height = height;
        this.weight = currentWeight;
        this.userId = userId;
        this.targetWeight = targetWeight;
        this.targetDate = targetDate;
        calculateCalorificDetails(userId);
        JOptionPane.showMessageDialog(null, "You have to burn a minimum of "+Math.round(calorieDeficit)+" calories everyday.");
        String values = "values('"+date+"',"+height+","+currentWeight+","+targetWeight+","+userId+","+targetDate+")";
        String query = "(date, height, currentWeight, targetWeight, userId, targetDate)";
        //con.insertFunction("weightDiary", query+" "+values);
        con.dbOperation("insert", "weightDiary", query+" "+values);
        String noteQuery ="(userId, note, date, calorieDeficit, calorieIntake, calorieBurned)";
        String note="hi";
        String noteValues ="values("+userId+",'"+note+"','"+date+"',"+calorieDeficit+","+0+","+0+")";
        //con.insertFunction("Notification", noteQuery+" "+noteValues);
        con.dbOperation("insert", "Notification", noteQuery+" "+noteValues);
    }
    
    public int getUserID(String email)
    {
        userId = con.getUserID(email);
        return userId;
    }
    
    public boolean checkUserLogin(String email, String password)
    {
        boolean val = con.checkUser(email, password);
        return val;
    }
    
    public void calculateCalorificDetails(int userId)
    {
        gender = con.getGender(userId);
        if(gender.equals("male"))
        {
            rmrCalc = new MaleRMR();
        }
        else if(gender.equals("female"))
        {
            rmrCalc = new FemaleRMR();
        }
        
        double rmr = rmrCalc.calculateRMR(weight, height, age);
        this.calorieDeficit = (3500 * (weight - targetWeight))/targetDate;
        
    }
    
    public String getPackage(int userId)
    {
        String usrPackage="";
        try
        {
            String tableName = "User";
            String query = "select package from User where userId="+userId;
            con = new JDBCConnection();
            con.makeConnection();
            usrPackage = con.getUserPackage(query);
           
        }catch(SQLException se)
        {
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        } finally{
            con.closeConnection();
        }
       
        return usrPackage;
    }
    
    public void editUser(int id, String category, String value)
    {
        switch(category)
        {
            case "firstName":
                this.firstName = value;
                break;
            case "lastName":
                this.lastName = value;
                break;
            case "gender":
                this.gender = value;
                break;
            case "age":
                this.age = Integer.parseInt(value);
                break;
            case "height":
                this.height = Double.parseDouble(value);
                break;
            case "weight":
                this.weight = Double.parseDouble(value);
                break;
            case "package":
                this.pkg = value;
                break;
            default:
                break;
            
        }
    }
    public void removeUser(int id)
    {
        //delete the user from user table in db
    }
    
    //public abstract void constructDiet(Food item, String mealType, String date, int count);
    //public abstract void constructWorkout();
    
}
