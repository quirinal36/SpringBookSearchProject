<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>id: ${book.id }</li>
		<li>title: ${book.title }</li>
		<li>contents: ${book.contents }</li>
	</ul>
	
	<a href="<c:url value="/book/update?id=${book.id}"/>">수정하기</a>
	<a href="<c:url value="/book/list"/>">목록</a>
	<a href="<c:url value="/book/delete?id=${book.id}"/>">삭제하기</a>
</body>
</html>