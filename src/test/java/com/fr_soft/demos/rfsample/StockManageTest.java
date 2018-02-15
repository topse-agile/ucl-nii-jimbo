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
	
}
