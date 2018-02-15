package com.fr_soft.demos.rfsample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockManageTest {

	@Test
	public void getCurentCountOfAnItemTest() {
		String filename = "src\\test\\resources\\ItemList.csv";
    	StockManager stockManager = new StockManager(filename);
		
		stockManager.add("Tea", 10);
		
		assertThat(stockManager.getStocks("Tea"), is(10));
	}
	
	@Test
	public void checkAmountOfItemIsZero(){
		String filename = "src\\test\\resources\\ItemList.csv";
    	StockManager stockManager = new StockManager(filename);
		
		stockManager.add("Tea", 0);
		
		assertTrue(stockManager.checkZero("Tea"));
		
	}
	
	@Test
	public void checkAmountOdItemIsNotZero(){
		String filename = "src\\test\\resources\\ItemList.csv";
    	StockManager stockManager = new StockManager(filename);
		
		stockManager.add("Tea", 1);
		
		assertFalse(stockManager.checkZero("Tea"));
	}
	
}
