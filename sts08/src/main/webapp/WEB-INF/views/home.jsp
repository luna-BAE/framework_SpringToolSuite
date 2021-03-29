<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8">
	<script type="text/javascript" src = "webjars/jquery/3.6.0/jquery.min.js"></script>
	<!-- 웹 소켓 통신에 사용할 CDN -->
	<script src = "https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
	<script type="text/javascript">
	
	var sock;
	
	function callback(e) {
		console.log(e.data);
		$('<li>'+e.data+'</li>').appendTo('ul');
	}
	
	$(function name() {
		sock = new SockJS('/sts08/echo');
		sock.onmessage = callback;
		$('button').click(function() {
			var msg = $('input').val();
			sock.send(msg);
			$('input').val("");
		});
	});	
	
	</script>
</head>
<body>
<h1>웹채팅</h1>
<div>
	<input><button>전송</button>
</div>

<div>
	<ul></ul>
</div>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
