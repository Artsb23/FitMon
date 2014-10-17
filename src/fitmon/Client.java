/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.client.ClientProtocolException;
import org.xml.sax.SAXException;

/**
 *
 * @author Aarthi
 */
public class Client {
    
    public static void main(String[] args) throws IOException, ClientProtocolException, NoSuchAlgorithmException, InvalidKeyException, SAXException, ParserConfigurationException
    {
        Food food = null;
        DietAPI dApi = new DietAPI();
        JDBCConnection jdbcCon = new JDBCConnection();
        ArrayList<Food> foodItems = dApi.getFood();
        Scanner scan = new Scanner(System.in);
        Calendar currentDate = Calendar.getInstance(); //Get the current date
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd"); //format it as per your requirement
        String dateNow = formatter.format(currentDate.getTime());
        System.out.println("Now the date is :=>  " + dateNow);
        for(int i=0;i<foodItems.size();i++)
        {
            food = foodItems.get(i);
            System.out.println("ID : " + food.getFoodID());
            System.out.println("servingID : " + food.getServingID());
            System.out.println("Name : " + food.getItemName());
            System.out.println("category : " + food.getCategory());
            System.out.println("Quantity : " + food.getQuantity());
            System.out.println("calories : " + food.getCalories());
            System.out.println("fat : " + food.getFat());
            System.out.println("carbs : " + food.getCarbs());
            System.out.println("protein : " + food.getProtein());
            System.out.println("fiber : " + food.getFiber());
            System.out.println("sodium : " + food.getSodium());
            System.out.println("sugar : " + food.getSugar());
            System.out.println("cholesterol : " + food.getCholesterol());
            System.out.println("------------------------------------------------------------------------------------------------");
 
        }
        
        System.out.println("Choose a meal......");
        String mealType = scan.next();
        System.out.println("Choose an item......");
        String servingID = scan.next();
         for(int j=0;j<foodItems.size();j++)
        {
            if(foodItems.get(j).getServingID() == null ? servingID == null : foodItems.get(j).getServingID().equals(servingID))
            {
                food = foodItems.get(j);
                break;
            }
                
        }
         Diet diet = new CustomizedDiet();
         diet.createDiet(food, mealType, dateNow);
         
    }
    
}
