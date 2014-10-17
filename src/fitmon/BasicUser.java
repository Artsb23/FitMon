/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Aarthi
 */
public class BasicUser extends UserModel{
    
    
    public void addUser(String fname, String lname, String gender, int age, String email, String password) throws SQLException{
       
        this.pkg = "Basic";
        super.addUser(fname, lname, gender, age, email, password);
        
        
        //add these details to the user table in database
    }
    
    @Override
      //session id - id
    public void editUser(int id, String category, String value)
    {
        
        super.editUser(id, category, value);
    }
    
    @Override
      //session id - id
    public void removeUser(int id)
    {
        super.removeUser(id);
        //remove all details of the user from the user table in database
    }
    
   
    public void constructDiet(Food item, String mealType, String date, int count)
    {
        CustomizedDiet c = new CustomizedDiet();
        c.createDiet(item, mealType, date, userId, count);
    }
    
  
    public void constructWorkout()
    {
        
    }
   
}
