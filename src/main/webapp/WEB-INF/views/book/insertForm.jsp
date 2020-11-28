<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert book form</title>
</head>
<body>
	<form action="<c:url value="/book/insert"/>" method="POST">
		<input type="text" placeholder="책 제목" name="title" value="${book.title }"/>
		<br>
		<input type="text" placeholder="책 요약" name="contents" value="${book.contents }"/>
		<br>
		<input type="submit"/>
		
		<input type="hidden" name="id" value="${book.id }"/>
	</form>
</body>
</html>