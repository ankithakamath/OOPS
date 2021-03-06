package com.yml.inventorymanager;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class InventoryDet {
	
    private List<JSONArray> inventories = new ArrayList<>();
    
    public List<JSONArray> getInventories() {
        return inventories;
    }

  
    {
        try {
            FileReader reader = new FileReader("/Users/ankithakamath/Desktop/assignments/OOPS/src/com/yml/inventorymanager/Inventoryman.json");
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray inventoryList = (JSONArray) obj.get("inventories");

            Iterator<JSONArray> itr = inventoryList.iterator();
            while (itr.hasNext()) {
                JSONArray inventory = itr.next();
                inventories.add(inventory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}