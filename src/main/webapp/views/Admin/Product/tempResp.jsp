<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="com.reviewdekho.image.model.ProductImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ProductImage image = (ProductImage) session.getAttribute( "image" );
	%>
	
	<img alt="" src="data:image/jpg;base64,<%=image.getImage() %>" height="400px" width="400px">
	
</body>
</html>