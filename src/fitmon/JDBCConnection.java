/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.sql.*;
import java.text.DateFormat.Field;
import java.util.ArrayList;
import java.util.HashMap;



/**
 *
 * @author Aarthi
 */
public class JDBCConnection<T> {
 
   private ArrayList rSet;
   private ArrayList<ArrayList> list;
   private Connection conn = null;
   private Statement stmt = null;
   private ResultSet rs = null;
   private Object flag = null;
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/fitMon";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "april-23";
  
   public Connection getConnection()
   {
       return this.conn;
   }
   
   public Statement getStatement()
   {
       return stmt;
   }
   
   public ResultSet getResultSet()
   {
       return rs;
   }
   
   //Template Method Pattern 
   public void dbOperation(String operation, String tableName, String query) throws SQLException
   {
       makeConnection();
       doOperation(operation, tableName, query);
       closeConnection();
   }
   
   public Connection makeConnection() {
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   return conn;
}//end main
   
   public void doOperation(String operation, String tableName, String query) throws SQLException
   {
       if(operation.equals("select"))
           selectFunction(tableName, query);
       else if(operation.equals("insert"))
           insertFunction(tableName, query);
       else if(operation.equals("update"))
           updateFunction(tableName, query);
   }
   
  public void closeConnection()
  {
      try{
         if(stmt!=null)
            conn.close();
       }catch(SQLException se){
       }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
  }
   
   public void selectFunction(String tableName, String query) throws SQLException
   {
       
        String sql="";
        try
        {
            if(query == null || query == "")
                sql = "select* from "+tableName;
            else
                sql = "select* from "+tableName+" "+query;
             
            this.rs = stmt.executeQuery(sql);
            System.out.println("query executed!");
        }catch(SQLException se){
      //Handle errors for JDBC
           se.printStackTrace();
       }catch(Exception e){
      //Handle errors for Class.forName
           e.printStackTrace();
       }
   }
   
   public ArrayList getDietDetails(String tableName, String query) throws SQLException
   {
       makeConnection();
       selectFunction(tableName,query);
       list = new ArrayList<ArrayList>();
       while(this.rs.next()){
         //Retrieve by column name
          rSet = new ArrayList();
         rSet.add(rs.getInt("dietId"));
         rSet.add("0");
         rSet.add(rs.getString("itemName"));
         rSet.add(rs.getString("qty"));
         rSet.add(rs.getString("category"));
         rSet.add(rs.getDouble("calories"));
         rSet.add(rs.getDouble("fat"));
         rSet.add(rs.getDouble("sodium"));
         rSet.add(rs.getDouble("carbs"));
         rSet.add(rs.getDouble("protein"));
         rSet.add(rs.getDouble("fiber"));
         rSet.add(rs.getDouble("cholesterol"));
         rSet.add(rs.getDouble("sugar"));
         rSet.add(rs.getInt("count"));
         list.add(rSet);
         
      }
       closeConnection();
        return list;
   }
   
    /**
     *
     * @param tableName
     * @param values
     * @param className
     * @throws SQLException
     */
    public void insertFunction(String tableName, String query) throws SQLException
   {
       
       try
       {
            String sql;
             sql = "Insert into "+tableName+query;
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           stmt.executeUpdate(sql);
       }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
       
   }
   
   public void updateFunction(String tableName, String query)
   {
       
       try
       {
            String sql;
             sql = "update "+tableName+" set "+ query;
             stmt = conn.createStatement();
            
           stmt.executeUpdate(sql);
       }catch(SQLException se){
      //Handle errors for JDBC
           se.printStackTrace();
       }catch(Exception e){
      //Handle errors for Class.forName
           e.printStackTrace();
       }
       
   }
   
   public boolean checkUser(String email, String password)
   {
      
        try
       {
            conn = makeConnection();
            
            String sql;
             sql = "where email='"+email+"' and password='"+password+"'";
             selectFunction("User", sql);
            //STEP 5: Extract data from result set
           if(rs!=null)
           {
               return true;
           }
           else
               return false;
      //STEP 5: Extract data from result set
     
       }catch(SQLException se){
      //Handle errors for JDBC
           se.printStackTrace();
       }catch(Exception e){
      //Handle errors for Class.forName
           e.printStackTrace();
       }finally{
      //finally block used to close resources
       closeConnection();
   }//end try
        return false;
   }
   
   public int getUserID(String email)
   {
       int userId=0;
        try
       {
            conn = makeConnection();
            
            String sql;
             sql = "select userId from User where email='"+email+"'";
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         userId  = rs.getInt("userId");
      }
       }catch(SQLException se){
      //Handle errors for JDBC
           se.printStackTrace();
       }catch(Exception e){
      //Handle errors for Class.forName
           e.printStackTrace();
       }finally{
      //finally block used to close resources
       closeConnection();
   }//end try
       return userId;
   }
   
   public String getGender(int userId)
   {
      try
       {
            conn = makeConnection();
            
            String sql;
             sql = "where userId="+userId;
             selectFunction("User", sql);
            //STEP 5: Extract data from result set
           if(rs!=null)
           {
               while(rs.next())
               {
                   return rs.getString("gender");
               }
              
           }
      //STEP 5: Extract data from result set
     
       }catch(SQLException se){
      //Handle errors for JDBC
           se.printStackTrace();
       }catch(Exception e){
      //Handle errors for Class.forName
           e.printStackTrace();
       }finally{
      //finally block used to close resources
       closeConnection();
   }//end try
        return ""; 
   }
   
   public ArrayList<ArrayList> getCalories(String query) throws SQLException
   {
       String sql;
        ArrayList cal=null;   
        ArrayList<ArrayList> finalarry = new ArrayList<ArrayList>(); 
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           ResultSet rs = stmt.executeQuery(query);
      //STEP 5: Extract data from result set
      while(rs.next()){
          cal = new ArrayList();
         //Retrieve by column name
         cal.add(rs.getString("date"));
         cal.add(rs.getDouble("sum(calories)"));
         finalarry.add(cal);
                 
      }
      return finalarry;
   }
    
   public double getCalorieDeficit(int userId) throws SQLException
   {
       String sql;
        double cal = 0;     
        String query = "SELECT MAX(date), calorieDeficit FROM Notification where userId="+userId;
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           ResultSet rs = stmt.executeQuery(query);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         cal  = rs.getDouble("calorieDeficit");
      }
      return cal;
   }
   
   public void getHeightAndWeight(int userId) throws SQLException
   {
       String sql;
          
        String query = "SELECT MAX(date),currentWeight,height FROM weightDiary where userId="+userId;
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           this.rs = stmt.executeQuery(query);
      
   }
   
   public int getAge(int userId) throws SQLException
   {
       String sql;
        int age = 0;     
        String query = "SELECT age FROM User where userId="+userId;
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           this.rs = stmt.executeQuery(query);
           while(rs.next()){
         //Retrieve by column name
         age  = rs.getInt("age");
      }
      return age;
   }
   
   public double getCalIntake(String query) throws SQLException
   {
       String sql;
        double calIntake=0;
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           ResultSet rs = stmt.executeQuery(query);
      //STEP 5: Extract data from result set
      while(rs.next()){
          
         calIntake = rs.getDouble("sum(calories)");
                 
      }
      return calIntake;
   }
   
   public String getUserPackage(String query) throws SQLException
   {
       String userPackage = null;
       String sql;
       
             stmt = conn.createStatement();
            //STEP 5: Extract data from result set
           ResultSet rs = stmt.executeQuery(query);
      //STEP 5: Extract data from result set
      while(rs.next()){
          
         userPackage = rs.getString("package");
                 
      }
      return userPackage;
   }
}
