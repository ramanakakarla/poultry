<%@page import="com.springexamples.ui.UIElement"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%= request.getAttribute("action") %>" method="post">
<% List<UIElement> elements = (List<UIElement>) request.getAttribute("uiElements"); %>
<% for(UIElement element : elements){ %>
	<% if(element.getElementType().getOrder() ==1){ %>
		<%=  element.getLabel()%> <input type="text" name="<%=element.getName() %>" /><br/>
		<% } %>
			<% if(element.getElementType().getOrder() ==2){ %>
		<%=  element.getLabel()%> <input type="password" name="<%=element.getName() %>" /><br/>
		<% } %>
			<% if(element.getElementType().getOrder() ==3){ %>
		<%=  element.getLabel()%> <textarea  name="<%=element.getName() %>" ></textarea><br/>
		<% } %>
		
<% }%>
<input type="submit" value="submit"/>
</form>
</body>
</html>