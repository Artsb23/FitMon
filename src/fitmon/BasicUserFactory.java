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
public class BasicUserFactory extends UserFactory{
    
    public UserModel createUser(int userType)
    {
        return new BasicUser();
    }
    
}
