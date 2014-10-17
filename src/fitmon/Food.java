/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aarthi
 */
public class Food {
    
    private String foodID;
    private String servingID;
    private String category;
    private double calories;
    private String itemName;
    private String quantity;
    private double fat;
    private double sodium;
    private double carbs;
    private double protein;
    private double fiber;
    private double cholesterol;
    private double sugar;
    
    public Food(String foodID, String servingID, String itemName, String qty, String category, double calories, double fat, double sodium, double carbs, double protein, double fiber, double cholesterol, double sugar)
    {
        this.foodID = foodID;
        this.servingID = servingID;
        this.itemName = itemName;
        this.quantity = qty;
        this.category = category;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbs = carbs;
        this.protein = protein;
        this.fiber = fiber;
        this.cholesterol = cholesterol;
        this.sugar = sugar;
    }
    
   
    public String getFoodID()
    {
        return foodID;
    }
    
    public String getServingID()
    {
        return servingID;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public String getQuantity()
    {
        return quantity;
    }
  
    public double getCalories()
    {
        return calories;
    }
  
    public double getFat()
    {
        return fat;
    }

    public double getSodium()
    {
        return sodium;
    }

    public double getCarbs()
    {
        return carbs;
    }

    public double getProtein()
    {
        return protein;
    }

    public double getFiber()
    {
        return fiber;
    }
    
    public double getCholesterol()
    {
        return cholesterol;
    }
    
    public double getSugar()
    {
        return sugar;
    }
}
