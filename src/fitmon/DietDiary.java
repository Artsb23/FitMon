/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
/**
 *
 * @author Aarthi
 */
public class DietDiary {
    
  private ArrayList<Diet> dietList = new ArrayList<Diet>();
  Diet diet = new CustomizedDiet();
  HashMap<String, String> hm = new HashMap<String,String>();
  HashMap<String, ArrayList<Food>> mealHM = new HashMap<String, ArrayList<Food>>();
  Food food;
  JDBCConnection con;
   
  public void setDietDiary(String date, int userId) throws SQLException
  {
      //mySQL db queries to get food data on a particular date
      con = new   JDBCConnection();
      //ArrayList<Food> breakfastList = new ArrayList<Food>();
      //BreakFast
      String breakfastQuery = "where userId="+userId+" and date='" +date+"' and mealType='breakfast'";
      ArrayList rs = con.getDietDetails("Diet", breakfastQuery);
      for(int i=0; i<rs.size();i++)
      {
        ArrayList a = (ArrayList)rs.get(i);
        hm.put(String.valueOf(a.get(0)),String.valueOf(a.get(13)));
        food = new Food(String.valueOf(a.get(0)),(String)a.get(1),(String)a.get(2),(String)a.get(3),(String)a.get(4),(double)a.get(5),(double)a.get(6),(double)a.get(7),(double)a.get(8), (double)a.get(9), (double)a.get(10), (double)a.get(11),(double)a.get(12));
        diet.foodItems.add(food);   
      }
       mealHM.put("breakfast", diet.foodItems);
       
       
       diet.foodItems = new ArrayList<Food>();
       String lunchQuery = "where userId="+userId+" and date='" +date+"' and mealType='lunch'";
      rs = con.getDietDetails("Diet", lunchQuery);
      for(int i=0; i<rs.size();i++)
      {
        ArrayList a = (ArrayList)rs.get(i);
        hm.put(String.valueOf(a.get(0)),String.valueOf(a.get(13)));
        food = new Food(String.valueOf(a.get(0)),(String)a.get(1),(String)a.get(2),(String)a.get(3),(String)a.get(4),(double)a.get(5),(double)a.get(6),(double)a.get(7),(double)a.get(8), (double)a.get(9), (double)a.get(10), (double)a.get(11),(double)a.get(12));
        diet.foodItems.add(food);   
      }
       mealHM.put("lunch", diet.foodItems);
       
       
       diet.foodItems = new ArrayList<Food>();
       String dinnerQuery = "where userId="+userId+" and date='" +date+"' and mealType='dinner'";
      rs = con.getDietDetails("Diet", dinnerQuery);
      for(int i=0; i<rs.size();i++)
      {
        ArrayList a = (ArrayList)rs.get(i);
        hm.put(String.valueOf(a.get(0)),String.valueOf(a.get(13)));
        food = new Food(String.valueOf(a.get(0)),(String)a.get(1),(String)a.get(2),(String)a.get(3),(String)a.get(4),(double)a.get(5),(double)a.get(6),(double)a.get(7),(double)a.get(8), (double)a.get(9), (double)a.get(10), (double)a.get(11),(double)a.get(12));
        diet.foodItems.add(food);   
      }
       mealHM.put("dinner", diet.foodItems);
       diet.foodItems = new ArrayList<Food>();
       
       diet.foodItems = new ArrayList<Food>();
       String snacksQuery = "where userId="+userId+" and date='" +date+"' and mealType='snacks'";
      rs = con.getDietDetails("Diet", snacksQuery);
      for(int i=0; i<rs.size();i++)
      {
        ArrayList a = (ArrayList)rs.get(i);
        hm.put(String.valueOf(a.get(0)),String.valueOf(a.get(13)));
        food = new Food(String.valueOf(a.get(0)),(String)a.get(1),(String)a.get(2),(String)a.get(3),(String)a.get(4),(double)a.get(5),(double)a.get(6),(double)a.get(7),(double)a.get(8), (double)a.get(9), (double)a.get(10), (double)a.get(11),(double)a.get(12));
        diet.foodItems.add(food);   
      }
       mealHM.put("snacks", diet.foodItems);
       diet.foodItems = new ArrayList<Food>();
      
  }
  
  
  
  public void calculateTotalCalories()
  {
      
  }
  
  public static void main(String[] args) throws SQLException
  {
      DietDiary d = new DietDiary();
      d.setDietDiary("2014-08-23",123);
  }
  
}
