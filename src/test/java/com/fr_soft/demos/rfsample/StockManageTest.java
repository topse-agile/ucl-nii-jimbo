package com.fr_soft.demos.rfsample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockManageTest {

	@Test
	public void getCurentCountOfAnItemTest() {
		StockManager stockManager = new StockManager();
		
		stockManager.add("Tea", 10);
		
		assertThat(stockManager.getStocks("Tea"), is(10));
	}
	
	@Test
	public void checkAmountOfItemIsZero(){
		StockManager stockManager = new StockManager();
		
		stockManager.add("Tea", 0);
		
		assertTrue(stockManager.checkZero("Tea"));
		
	}
	
	@Test
	public void checkAmountOdItemIsNotZero(){
		StockManager stockmanager = new StockManager();
		
		stockmanager.add("Tea", 1);
		
		assertFalse(stockmanager.checkZero("Tea"));
	}


}
