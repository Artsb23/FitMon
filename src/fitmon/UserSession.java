/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;
import java.util.*;
/**
 *
 * @author Aarthi
 */
public class UserSession {
    
    private static String userSessionID = null;
    private int userID;
    private HashMap session = new HashMap();

    private static UserSession sessionInstance = new UserSession();
    private UserSession()
    {
        
    }
    
    public static UserSession getInstance()
    {
        return sessionInstance;
    }
    
    public void generateSessionID()
    {
        UUID key = UUID.randomUUID();
        this.userSessionID = String.valueOf(key);
    }
    
    public void setUSerSession(int Id)
    {
        this.userID = Id;
        session.put(userSessionID,userID);
        System.out.println(userSessionID);
    }
    
    public String getSessionID()
    {
        return userSessionID;
    }
    
    public int getUserID()
    {
        String key = getSessionID();
        int id = (Integer)session.get(key);
        System.out.println(key);
        return id;
    }
    
    public void removeUser(int id)
    {
        session.remove(userSessionID, id);
        userSessionID = null;
    }
    
    public void cleanUp()
   {
       session.clear();
   }
    
    public static void main(String[] args)
    {
        UserSession usr = UserSession.getInstance();
        int userId=123;
        if(usr.getSessionID() == null)
        {
            usr.setUSerSession(userId);
        }
        
        else
        {
            userId = usr.getUserID();
        }
        System.out.println(userId);
        
        Test obj = new Test();
        obj.test();
    }
    
    
    
}

class Test
{
    public void test()
    {
        UserSession usr = UserSession.getInstance();
        System.out.println(usr.getSessionID());
    }
}
