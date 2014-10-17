/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;
import java.util.Date;
/**
 *
 * @author Aarthi
 */
public class Workout {
    
    private Date date;
    private String type;
    private String name;
    private String intensity;
    private double duration;
    private double calories;
            
            
    
    public void setWorkout(Date date, String type, String name, String intensity, double duration, double calories)
    {
        this.date = date;
        this.type = type;
        this.name = name;
        this.intensity = intensity;
        this.duration = duration;
        this.calories = calories;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getIntensity()
    {
        return intensity;
    }
    
    public double getDuartion()
    {
        return duration;
    }
    
    private double calcCalories()
    {
        return calories;
    }
    
    public void addWorkout()
    {
        
    }
}
