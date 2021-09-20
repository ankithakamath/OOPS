package com.yml.inventorymanager;

import java.io.PrintWriter;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Manager {
	  
    public static void run() {
    	
        InventoryDet inventoryFactory = new InventoryDet();
        List<JSONObject> inventories = new ArrayList<JSONObject>();
        PrintWriter out = new PrintWriter(System.out,true);
        
       
        for (JSONArray inventory : inventoryFactory.getInventories()) {
           
        	
            Map<String, Double> priceMap = new HashMap<String, Double>();
            Iterator<JSONObject> itr = inventory.iterator();
            
            
            while (itr.hasNext()) {
                JSONObject item = (JSONObject) itr.next();
                String name = (String) item.get("name");
                double weight = (double) item.get("weight");
                double pricePerKG = (double) item.get("pricePerKG");
                double totalPrice = weight * pricePerKG;
                priceMap.put(name, totalPrice);
            }

           
            JSONObject inventoryJSON = new JSONObject();
            inventoryJSON.putAll(priceMap);
            inventories.add(inventoryJSON);
        }
    
        int count = 1;
        for (JSONObject inventory : inventories) {
            out.println("Inventory "+count);
            double sum = 0;
            for (Object item : inventory.keySet()) {
                sum += (double) inventory.get(item);
            }
            
            out.println("Cost: " + sum);
            out.println("Inventory Items");
            out.println(inventory.toJSONString());
            out.println();
            count++;
        }
    }
}