<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<List<String>> alldata = (List<List<String>>)request.getAttribute("alldata");
	Integer total = (Integer)request.getAttribute("total");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 리스트 페이지</title>
</head>
<body>
<p>등록된 공지사항 게시물은 : <%=total%> 개 입니다.</p>
<table border="1">
<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
	</tr>
</thead>
<tbody>
	<%
		int w = 0;
		while(w < alldata.size()){
	%>
	<tr>
		<td><%=total-w%></td>
		<td>
		<a href="./notice_view.do?idx=<%=alldata.get(w).get(0)%>">
		<%=alldata.get(w).get(1)%></a>
		</td>
		<td><%=alldata.get(w).get(2)%></td>
		<td><%=alldata.get(w).get(3)%></td>
	</tr>
	<%
		w++;
		}
	%>
</tbody>
</table>
</body>
</html>