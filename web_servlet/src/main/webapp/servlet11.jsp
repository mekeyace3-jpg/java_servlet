<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String list[] = (String[])request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>함께할 조별 결과</title>
</head>
<body>
<fieldset> <!-- Back-end 직접 자바 코드를 이용하여 출력한 상황 -->
	<legend>A조 - 멤버</legend>
	<%
	int w = 0;
	while(w < list.length){
	%>
	<label><%=list[w]%></label><br>
	<%
	 w++;
	  }
	%>
</fieldset>
<br><br>
<!-- Front-end가 직접 Back-end의 변수를 활용하여 javascript 출력하는 방식 -->
<fieldset>
	<legend>A조 - 멤버</legend>
	<div id="views">
	
	</div>
</fieldset>
</body>
<script>
<%-- "<%=list[ww]%>"<%=","%> --%>
var data = [
	<%
	int ww = 0;
	while(ww < list.length){
		out.print("'"+list[ww]+"'"+",");
		ww++;
	}
	%>
];
var node = document.getElementById("views");
var f;
for(f=0; f<data.length; f++){
	var html = document.createElement("p");
	var text = document.createTextNode(data[f]);
	html.append(text);
	node.append(html);
}

</script>
</html>