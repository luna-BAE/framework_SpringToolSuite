<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel = "stylesheet" href = "../css/bootstrap.css">
<script type="text/javascript" src = "../js/jquery-1.12.4.js"></script>
<script type="text/javascript" src = "../js/bootstrap.js"></script>

</head>
<body>

	<div class = "container">
		<div class = "row">
			<div class = "col-sm-12">
				<ul>
					<li><a href = "../">home</a></li>
					<li><a href = "../intro">intro</a></li>
					<li><a href = "../dept/list">dept</a></li>
					<li><a href = "../emp/list">emp</a></li>
				</ul>
			</div>
		</div>
		
		<div class = "row">
			<div class = "col-sm-12">
				<h2>입력 페이지<span>(emp table)</span></h2>
				<form method = "post">
					<div class = "form-group">
						<input type = "text" name = "empno" placeholder="empno" class = "form-control" />
					</div>
					
					<div class = "form-group">
						<input type = "text" name = "ename" placeholder="ename" class = "form-control" />
					</div>
					
					<div class = "form-group">
						<input type = "text" name = "pay" placeholder="pay" class = "form-control" />
					</div>
					
					<div class = "form-group">
						<select name = "deptno" class = "form-control">
							<c:forEach items = "${list }" var = "bean">
							<option value = "${bean.deptno}">${bean.dname }</option>
							</c:forEach>
						</select>
					</div>
					
					<div class = "form-group">
						<button class = "btn btn-primary btn-block">입 력</button>
					</div>
				</form>
			</div>
		</div>
		
		<div class = "row">
			<div class = "col-sm-12">
				footer
			</div>
		</div>
	</div>

</body>
</html>