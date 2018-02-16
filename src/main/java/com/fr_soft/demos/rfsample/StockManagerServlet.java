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
    String[] items;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String filename = "src\\test\\resources\\ItemList.csv";
    	filename = "H:\\ucl-nii-jimbo\\src\\test\\resources\\ItemList.csv";
    	StockManager stockManager = new StockManager(filename);
    	
//    	String item = stockManager.getItem();
//    	
//    	request.setAttribute("item", item);
//        request.setAttribute("stock", stockManager.getStocks(item));

    	items = stockManager.getItemList();
    	int[] stocks = new int[items.length];
    	int[] orders = new int[items.length];
    	String[] messages = new String[items.length];
    	
    	for (int i = 0 ; i< items.length; i++) {
    		stocks[i] = stockManager.getStocks(items[i]);
    		if(stockManager.checkZero(items[i])){
    			orders[i] = stockManager.getOrder(items[i]);
      		    messages[i] = "Please order " + orders[i];
    		} else {
    			orders[i] = 0;
    			messages[i] = "";
    		}
    	}
    	

//    	String[] items = {"Cola","Coffee","Tea"};
//    	int[] stocks = {30, 0, 40};
//    	String[] messages = {"", "Test Message", ""};
    	
    	request.setAttribute("items", items);
    	request.setAttribute("stocks", stocks);
    	request.setAttribute("orders", orders);
    	request.setAttribute("messages", messages);
    	request.setAttribute("cnt", items.length);
    	
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int[] orders = new int[items.length];
    	for (int i = 0; i < items.length; i++) {
    		orders[i] = Integer.parseInt(request.getParameter(items[i]));    		
    	}

    	request.setAttribute("items", items);
    	request.setAttribute("orders", orders);

        request.getRequestDispatcher("orderlist.jsp").forward(request, response);
    }

}
