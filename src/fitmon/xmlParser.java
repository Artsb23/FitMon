/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fitmon;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Aarthi
 */
public class xmlParser {
    
    public ArrayList<Food> Parser(String url) throws IOException, ParserConfigurationException, SAXException
    {
        
        String servingDescription;
        String foodID;
        String foodName;
        String servingID;
        String category;
        double protein=0;
        double calories=0;
        double fat=0;
        double carbs=0;
        double fiber=0;
        double sugar=0;
        double chol=0;
        double sodium=0;
        Food food;
        ArrayList<Food> foodList = new ArrayList<Food>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(url).openStream());
        doc.getDocumentElement().normalize();
 
	
        NodeList nList = doc.getElementsByTagName("food");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			foodID = eElement.getElementsByTagName("food_id").item(0).getTextContent();
			foodName = eElement.getElementsByTagName("food_name").item(0).getTextContent();
                        category = eElement.getElementsByTagName("food_type").item(0).getTextContent();
			Node servingsNode = eElement.getElementsByTagName("servings").item(0);
                        Element servingsElement = (Element) servingsNode;
                        NodeList servingList = servingsElement.getElementsByTagName("serving");
                        for (int i = 0; i < servingList.getLength(); i++) {
                            Node servingNode = servingList.item(i);
                            if (servingNode.getNodeType() == Node.ELEMENT_NODE) {
 
                                Element servingElement = (Element) servingNode;
                                servingID = servingElement.getElementsByTagName("serving_id").item(0).getTextContent();
                                servingDescription = servingElement.getElementsByTagName("serving_description").item(0).getTextContent();
                                if(servingElement.getElementsByTagName("calories").item(0)!=null)
                                    calories = Double.parseDouble(servingElement.getElementsByTagName("calories").item(0).getTextContent());
                                if(servingElement.getElementsByTagName("carbohydrate").item(0)!=null)
                                    carbs = Double.parseDouble(servingElement.getElementsByTagName("carbohydrate").item(0).getTextContent());
                                if(servingElement.getElementsByTagName("protein").item(0)!=null)
                                    protein = Double.parseDouble(servingElement.getElementsByTagName("protein").item(0).getTextContent());
                                if(servingElement.getElementsByTagName("fat").item(0)!=null)
                                    fat = Double.parseDouble(servingElement.getElementsByTagName("fat").item(0).getTextContent());
                                if(servingElement.getElementsByTagName("sodium").item(0)!=null)
                                    sodium = Double.parseDouble(servingElement.getElementsByTagName("sodium").item(0).getTextContent());
                                if(servingElement.getElementsByTagName("fiber").item(0)!=null)
                                    fiber = Double.parseDouble(servingElement.getElementsByTagName("fiber").item(0).getTextContent());
                                if(servingElement.getElementsByTagName("cholesterol").item(0)!=null)
                                    chol = Double.parseDouble(servingElement.getElementsByTagName("cholesterol").item(0).getTextContent());
                                if(servingElement.getElementsByTagName("sugar").item(0)!=null)
                                    sugar = Double.parseDouble(servingElement.getElementsByTagName("sugar").item(0).getTextContent());
                                food = new Food(foodID, servingID, foodName, servingDescription, category, calories, fat, sodium, carbs, protein, fiber, chol, sugar);
                                foodList.add(food);
                                
			
                            }
                        }
                        
		}
	}
        return foodList;
    }
    
    public ArrayList<String> foodSearchParser(String url) throws ParserConfigurationException, SAXException, IOException
    {
        
         
        String foodID=null;
        String foodName;
        String category;
        Food food;
        ArrayList<String> list = new ArrayList<String>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new URL(url).openStream());
        doc.getDocumentElement().normalize();
 
	
        NodeList nList = doc.getElementsByTagName("food");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 
			foodID = eElement.getElementsByTagName("food_id").item(0).getTextContent();
			foodName = eElement.getElementsByTagName("food_name").item(0).getTextContent();
                        category = eElement.getElementsByTagName("food_type").item(0).getTextContent();
                        list.add(foodID);
                }
        }
        return list;
    }
    
}
