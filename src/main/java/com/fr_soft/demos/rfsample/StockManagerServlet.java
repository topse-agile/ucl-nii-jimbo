package com.fr_soft.demos.rfsample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StockManagerServlet extends HttpServlet {

    private static final long serialVersionUID = 6961400581681209885L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String filename = "src\\test\\resources\\ItemList.csv";
    	filename = "H:\\ucl-nii-jimbo\\src\\test\\resources\\ItemList.csv";
    	StockManager stockManager = new StockManager(filename);
    	
//    	String item = stockManager.getItem();
//    	
//    	request.setAttribute("item", item);
//        request.setAttribute("stock", stockManager.getStocks(item));

    	String[] items = stockManager.getItemList();
    	int[] stocks = new int[items.length];
    	String[] messages = new String[items.length];
    	
    	for (int i = 0 ; i< items.length; i++) {
    		stocks[i] = stockManager.getStocks(items[i]);
    		if(stockManager.checkZero(items[i])){
      		   messages[i] = "Please order";// + stockManager.getOrder(items[i]);//some method
    		}
    	}
    	

//    	String[] items = stockManager.getItemList{"Cola","Coffee","Tea"};
//    	int[] stocks = {30, 0, 40};
//    	String[] messages = {"", "Test Message", ""};
    	
    	request.setAttribute("items", items);
    	request.setAttribute("stocks", stocks);
    	request.setAttribute("messages", messages);
    	request.setAttribute("cnt", items.length);
    	
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
