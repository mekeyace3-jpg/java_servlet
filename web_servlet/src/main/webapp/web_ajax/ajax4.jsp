<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//trimDirectiveWhitespaces(Ajax에서만 사용) : 
	//false(자바코드를 입력된 사항을 공백처리), true(자바코드 공백모두 삭제) 
	String msg = (String)request.getAttribute("msg");
%>
<%=msg%>