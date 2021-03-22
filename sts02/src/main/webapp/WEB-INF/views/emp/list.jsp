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
				<h2>list 페이지<span>(emp table)</span></h2>
				
				<table class = "table">
					<thead>
						<tr>
							<th>empno</th>
							<th>ename</th>
							<th>nalja</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items = "${list }" var = "bean">
							<tr>
								<td><a href = "one?idx=${bean.empno }">${bean.empno }</a></td>
								<td><a href = "one?idx=${bean.empno }">${bean.ename }</a></td>
								<td><a href = "one?idx=${bean.empno }">${bean.nalja }</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href = "add" class = "btn btn-primary btn-block" role = "button">입력</a>
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