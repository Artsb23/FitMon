/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

/**
 *
 * @author Aarthi
 */
public class FemaleRMR implements RMRCalculation{
    
    private double rmr;
    
    public double calculateRMR(double weightInLbs, double height, int age)
    {
        double weightInKgs = weightInLbs/2.20462;
        rmr = (10*weightInKgs) + (6.25*height) - (5*age) - 161;
        return rmr;
    }
}
