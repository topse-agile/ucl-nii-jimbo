<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item list</title>
</head>
<body>
        <%
        	String[] items = (String[])request.getAttribute("items");
        	int[] stocks = (int[])request.getAttribute("stocks");
        	int[] orders = (int[])request.getAttribute("orders");
        	String[] messages = (String[])request.getAttribute("messages");
        	
        	boolean outOfStock = false;
        	for (int i=0; i < stocks.length; i++) {
        		out.println("<font color=\"#ff0000\">");
        		if (stocks[i] == 0) {
        			if (outOfStock) {
        				out.println("- " + items[i] + "<br/>");
        			} else {
        				out.println("Some items are out of stock. Please order the below items.<br/>");
        				out.println("- " + items[i] + "<br/>");
        				outOfStock = true;
        			}
        		}
        		out.println("</font>");
        	}
        	
        	if (!outOfStock) {
        		out.println("<p>All items exist.</p>");
        	}
        	
        	
        	out.println("<form action=\"./stockmanager\" method=\"POST\">");
        	out.println("<table>");
        	out.println("<tr>");
        	out.println("<th>Item</th><th>Stock</th><th>Message</th><th>Amount to order</th>");
        	out.println("</tr>");
        	for(int i=0;i<items.length;i++){
        		out.println("<tr>");
        		out.println("<td>"+items[i]+"</td>"+"<td>"+stocks[i]+"</td>"+"<td>"+messages[i]+"</td>"+"<td><input type=\"test\" value=\""+orders[i]+"\" name=\"" + items[i] + "\"/></td>");
        		out.println("</tr>");
        	}
        	out.println("<td></td><td></td><td></td><td><input type=\"submit\" value=\"Order\"/></td>");
        	out.println("</table>");
        	out.println("</form>");
        	
        %>
        	
</body>
</html>