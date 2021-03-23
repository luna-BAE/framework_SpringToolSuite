<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../template/head.jspf" %>
</head>
<body>
<%@ include file = "../template/menu.jspf" %>
<div class = "container">
	<div>
		<form method = "post">
			<div class = "form-group">
				<input type = "text" class = "form-control" name = "deptno" placeholder="deptno"/>
			</div>
			
			<div class = "form-group">
				<input type = "text" class = "form-control" name = "dname" placeholder="dname"/>
			</div>
			
			<div class = "form-group">
				<input type = "text" class = "form-control" name = "loc" placeholder="loc"/>
			</div>
			
			<div class = "form-group">
				<div class="btn-group-vertical btn-block" role="group">
					<button type = "submit" class = "btn btn-primary btn-block">입력</button>
					<button type = "reset" class = "btn btn-default btn-block">취소</button>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>