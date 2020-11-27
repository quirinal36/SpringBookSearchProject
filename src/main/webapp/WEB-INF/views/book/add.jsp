<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<form>
		<input id="imageupload" type="file"
			accept="image/x-png,image/gif,image/jpeg" data-url="<c:url value="/book/upload/image"/>" multiple>
		<input type="submit" value="확인"/>
	</form>
</body>
<script type="text/javascript">
	$(document).ready(function(){
	    $('#imageupload').fileupload({
	    	imageCrop: true,
	        dataType: 'json',
	        done: function (e, data) {	        	
	        	console.log(data);
	        },
	    });
	});
</script>
<script src="<c:url value="/resources/js/jquery-1.9.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.ui.widget.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.iframe-transport.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.fileupload.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</html>