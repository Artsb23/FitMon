/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aarthi
 */
public class CustomizedDiet extends Diet{
    
    Diet diet;
    JDBCConnection jdbcObject;
    
   
    public void createDiet(Food item, String mealType,String date, int userId, int count)
    {
        jdbcObject = new JDBCConnection();
        String id = String.valueOf(Diet.generateId());
        String query="(date, mealType, category, itemName, qty, calories, fat, sodium, protein, fiber, carbs, sugar, cholesterol, userId, count)";
        String values="values('"+date+"','"+mealType+"','"+item.getCategory()+"','"+item.getItemName()+"','"+item.getQuantity()+"',"+item.getCalories()+","+item.getFat()+","+item.getSodium()+","+item.getProtein()+","+item.getFiber()+","+item.getCarbs()+","+item.getSugar()+","+item.getCholesterol()+","+userId+","+count+")";
        try {
            //jdbcObject.insertFunction("Diet",query+" "+values);
            jdbcObject.dbOperation("insert", "Diet", query+" "+values);
        } catch (SQLException ex) {
            Logger.getLogger(CustomizedDiet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Diet getDiet()
    {
        
        return diet;
    }
}
