<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<!-- 파일은 반드시 포스트로 보내야 함, 왜냐하면 띄어쓰기나 특수문자, 길이 등이 파일명에 있으면 주소에 인자로 보낼때 문제가 생길 수 있기 때문 -->
<form action="upload" method="post" enctype="multipart/form-data">
	<div>msg : <input type = "text" name = "msg"></div>
	<div>file : <input type = "file" name = "file"></div>
	<button>업로드</button>
</form>

</body>
</html>
