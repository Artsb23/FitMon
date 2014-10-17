/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.sql.Timestamp;
import java.util.Date;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;



public class WorkoutApi {
    

    //public String url;
    public StringBuilder apiGetInfo() throws ClientProtocolException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        HttpClient client = new DefaultHttpClient();
        //HttpGet request = new HttpGet("http://platform.fatsecret.com/rest/server.api&"
        //                    + "oauth_consumer_key=5f2d9f7c250c4d75b9807a4f969363a7&oauth_signature_method=HMAC-SHA1&oauth_timestamp=1408230438&"
        //                     + "oauth_nonce=abc&oauth_version=1.0&method=food.get&food_id=4384");
        //HttpResponse response = client.execute(request);
        //BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        //StringBuilder sb = new StringBuilder();
        String base = URLEncoder.encode("GET") + "&";
        base += "http%3A%2F%2Fplatform.fatsecret.com%2Frest%2Fserver.api&"; 
        
        String params;
        
        params = "format=json&";
        params += "method=exercises.get&"; 
        params += "oauth_consumer_key=5f2d9f7c250c4d75b9807a4f969363a7&" ; // ur consumer key 
        params += "oauth_nonce=123&"; 
        params += "oauth_signature_method=HMAC-SHA1&";
        Date date= new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
        params += "oauth_timestamp="+ts.getTime()+"&"; 
        params += "oauth_version=1.0"; 
        //params += "search_expression=apple"; 
        
        String params2 = URLEncoder.encode(params); 
        base += params2; 
        //System.out.println(base);
        String line = "";
        
        String secret = "76172de2330a4e55b90cbd2eb44f8c63&";
        Mac sha256_HMAC = Mac.getInstance("HMACSHA1");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HMACSHA1");
        sha256_HMAC.init(secret_key);
        String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(base.getBytes()));
        
        //$url = "http://platform.fatsecret.com/rest/server.api?".$params."&oauth_signature=".rawurlencode($sig); 
        HttpGet request = new HttpGet("http://platform.fatsecret.com/rest/server.api?"+params+"&oauth_signature="+URLEncoder.encode(hash));
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        StringBuilder sb = new StringBuilder();
        
        //$url = "http://platform.fatsecret.com/rest/server.api?"+params+"&oauth_signature="+URLEncoder.encode(hash);
        //return url;
        
        while ((line = rd.readLine()) != null) {
            sb.append(line);
            //System.out.println(line);
        }
        //System.out.println(sb.toString());
        return sb;
    }
    
    
    public static void main(String[] args) throws IOException, ClientProtocolException, NoSuchAlgorithmException, InvalidKeyException{ //ClientProtocolException, IOException, NoSuchAlgorithmException, InvalidKeyException {
      WorkoutApi wa = new WorkoutApi();
        //String s;
      StringBuilder s = wa.apiGetInfo();
      System.out.println(s.toString());
    }
}


    

