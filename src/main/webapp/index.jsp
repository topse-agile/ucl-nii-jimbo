<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sample Web</title>
</head>
<body>
        <%
        	String[] items = (String[])request.getAttribute("items");
        	int[] stocks = (int[])request.getAttribute("stocks");
        	String[] messages = (String[])request.getAttribute("messages");
        	out.println("<table>");
        	for(int i=0;i<items.length;i++){
        		out.println("<tr>");
        		out.println("<td>"+items[i]+"</td>"+"<td>"+stocks[i]+"</td>"+"<td>"+messages[i]+"</td>");
        		out.println("</tr>");
        	}
        	out.println("</table>");
        	
        %>
        	
</body>
</html>