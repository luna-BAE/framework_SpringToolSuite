<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../template/head.jspf" %>
<script type="text/javascript">

var back1 = function () {
	history.back();
};

var back2 = function () {
	$('form:eq(0)').one('submit', submit01);
	$('form:eq(0)').find('input').filter(':gt(0)').Prop('readonly','readonly');
	$('form').find('button[type=button]').on('click',back1);
	$('form').find('button[type=button]').off('click',back2);
};

var submit01 = function() {
	$(this).find('input').filter(':gt(0)').removeProp('readonly');
	$('form').find('button[type=button]').off('click',back1);
	$('form').find('button[type=button]').on('click',back2);
	return false;
}

$(function() {
	$('form').find('button[type=button]').on('click',back1);
	$('form:eq(0)').one('submit', submit01);
});

</script>
</head>
<body>
<%@ include file = "../template/menu.jspf" %>
<div class = "container">
	<div>
		<form method = "post">
			<div class = "form-group">
				<input type = "text" value = "${bean.deptno }" class = "form-control" name = "deptno" placeholder="deptno" readonly = "readonly"/>
			</div>
			
			<div class = "form-group">
				<input type = "text" value = "${bean.dname }" class = "form-control" name = "dname" placeholder="dname" readonly = "readonly"/>
			</div>
			
			<div class = "form-group">
				<input type = "text" value = "${bean.loc }" class = "form-control" name = "loc" placeholder="loc" readonly = "readonly"/>
			</div>
			
			<div class = "form-group">
				<div class="btn-group-vertical btn-block" role="group">
					<button type = "submit" class = "btn btn-primary btn-block">수정</button>
					<button type = "reset" class = "btn btn-default btn-block">취소</button>
					<button type = "button" class = "btn btn-default btn-block">뒤로</button>
				</div>
			</div>
		</form>
		<form action="${bean.deptno }/del" method = "post">
			<button type = "submit" class = "btn btn-danger btn-block">삭제</button>
		</form>
	</div>
</div>
</body>
</html>