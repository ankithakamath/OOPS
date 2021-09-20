package com.yml.stock;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Management {
	public static void main(String args[]) {
      
        Management.run();
    }
	

    public static void run() {  
    	
        PrintWriter out = new PrintWriter(System.out, true);
        Portfolio portfolio = new Portfolio();
        
        
        try {
            FileReader reader = new FileReader("/Users/ankithakamath/Desktop/assignments/OOPS/src/com/yml/stock/Stocks.json");
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(reader);
            JSONArray stocks = (JSONArray) obj.get("stocks");

            Iterator<JSONObject> itr = stocks.iterator();
            while (itr.hasNext()) {
                JSONObject stock = itr.next();
                String stockName = (String)stock.get("stockName");
                String stockSymbol = (String) stock.get("stockSymbol");
                long numberOfShares = (long) stock.get("numberOfShares");
                double sharePrice = (double) stock.get("sharePrice");
                Stock newStock = new Stock(stockName, stockSymbol, numberOfShares, sharePrice);
                portfolio.addStock(newStock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println("Stock Report");
        out.println("Value of Each Stocks in Portfolio: \n");
        for (Stock stock : portfolio.getStocks()) {
            out.println("Stock Name: " + stock.getStockName());
            out.println("Stock Symbol: " + stock.getStockSymbol());
            out.println("Stock Value: " + portfolio.valueOf(stock));
            out.println();
        }

        out.println("Total Value of Portfolio: "+portfolio.valueOfPortfolio());
    }
}