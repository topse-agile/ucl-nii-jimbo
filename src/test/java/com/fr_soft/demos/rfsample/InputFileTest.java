package com.fr_soft.demos.rfsample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class InputFileTest {

	@Test
	public void inputFileToCurrentNumberTest() {
		DB db = new DB();
		//String filename = "H:\\git\\ucl-nii-jimbo\\ItemList.csv";
		String filename = "src\\test\\resources\\ItemList.csv";
		Map<String, Integer> stocks = db.inputFileToCurrentNumber(filename);
		
		assertThat(stocks.get("Tea"), is(10));

	}
	
	@Test
	public void inputFileToOrderNumberTest(){
		DB db = new DB();
		//String filename = "H:\\git\\ucl-nii-jimbo\\ItemList.csv";
		String filename = "src\\test\\resources\\ItemList.csv";
		Map<String, Integer> stocks = db.inputFileToOrderNumber(filename);
		
		assertThat(stocks.get("Tea"), is(30));
	}

}
