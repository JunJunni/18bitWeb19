<%@ page language="java" contentType="application/xml; charset=UTF-8"
    pageEncoding="UTF-8"%><?xml version="1.0" encoding="UTF-8"?>

<%
	String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    boolean result = false;
    
    if(id.equals("admin") && pw.equals("1234")){
    	result=true;
    }
%>
    <root>
    	<user>
    		<result><%=result%></result>
    		<id><%=id%></id>
    	</user>
    </root>