/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.util.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jas
 */
public class JsonParser {
    
    /**
     *
     * @return 
     * @throws java.io.IOException
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.InvalidKeyException
     * @throws org.json.JSONException
     */
    public ArrayList jsonExtract() throws IOException, NoSuchAlgorithmException, InvalidKeyException, JSONException {
        
        WorkoutApi wa = new WorkoutApi();
        ArrayList<String> list = new ArrayList<>();
        
        String s = wa.apiGetInfo().toString();
        String s1 = s.substring(14);
        int n = s1.lastIndexOf("}");
        String s2 = s1.substring(0,n); //+ s1.substring(n+1);
        //System.out.println(s2);
        JSONObject json = new JSONObject(s2);
        
        JSONArray arr = json.getJSONArray("exercise");
        //JSONObject newJSON = json.getJSONObject("exercise");
        for(int i = 0; i < arr.length(); i++){
            JSONObject json_obj = arr.getJSONObject(i);
            int id = json_obj.getInt("exercise_id");
            String name = json_obj.getString("exercise_name");
            list.add(name);
            //System.out.println("Id: " + id + "workout: " + name);
            
        }
        //System.out.println(list);
        return list;
    }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, JSONException{
        
        JsonParser jp = new JsonParser();
        jp.jsonExtract();
    }
    
}
