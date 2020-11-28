<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Photo</title>
</head>
<body>
	<form enctype="multipart/form-data" action="<c:url value="/upload/image"/>" method="POST">
		<input type="file" name="files[]" accept="image/*"/>
		<input type="submit" value="upload"/>
	</form>
</body>
</html>