package com.fr_soft.demos.rfsample;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class InputFileTest {

	@Test
	public void inputFileTest() {
		DB db = new DB();
		String filename = "hogehoge";
		Map<String, Integer> stocks = db.imputfile(filename);
		
		assertThat(stocks.get("items"), is(10));

	}

}
