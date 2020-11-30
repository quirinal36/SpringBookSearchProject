<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSTL -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 결과</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="<c:url value="/resources/css/books.css"/>"/>
</head>
<body>
<div class="container">
	<div>
		<form action="<c:url value="/book/list"/>">
			<input type="text" placeholder="책정보를 검색하세요." name="title"
				value="${bookInfo.title }"/>
			<input type="submit" value="검색"/>
		</form>
	</div>
	<div class="row mb-5">
		<!-- forEach start -->
		<c:forEach items="${list }" var="book">
			<div class="col-md-4">
				<div class="card">
					<img src="${book.thumbnail }" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<a href="<c:url value="/book/detail/${book.id }"/>">
							${book.title }
							</a>
						</h5>
						<p class="card-text">${book.contents }</p>
						<a href="${book.url }" class="btn btn-sm btn-primary" target="_blank">책정보 조회하기</a>
					</div>
				</div>
			</div>
		</c:forEach>
		<!-- forEach finish -->
	</div>
</div>
</body>
</html>