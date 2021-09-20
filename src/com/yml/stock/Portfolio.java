package com.yml.stock;

import java.util.*;

public class Portfolio {
    private List<Stock> stocks = new ArrayList<Stock>();

    Portfolio() {

    }
    
    Portfolio(List<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    
    public List<Stock> getStocks() {
        return stocks;
    }

    public double valueOf(Stock stock) {
        return (double) (stock.getSharePrice() * stock.getNumberOfShares());
    }
    
    public double valueOfPortfolio() {
        double value = 0;
        for (Stock stock : stocks) {
            value += valueOf(stock);
        }

        return value;
    }
    
}