package com.fr_soft.demos.rfsample;

import java.util.HashMap;
import java.util.Map;

public class StockManager {
	private Map<String, Integer> stocks = new HashMap();

    public int getStocks(String item) {
        Integer amount = stocks.get(item);
        if (amount == null) {
            return 0;
        }
        return amount;
    }
    
    public void add(String item, int amount) {
        stocks.put(item, amount);
    }
    
    public boolean checkZero(String item){
    	
    	if (stocks.get(item) <= 0 ){
    		return true;
    	}
    	
    	return false;		
    }
    
    public String[] getItemList() {
    	Integer i = 0;
    	String[] ItemList = new String[stocks.size()];
    	for (String item : stocks.keySet()) {
    		ItemList[i] = item;
    		i++;
    	}
    	return ItemList;
    }
}
