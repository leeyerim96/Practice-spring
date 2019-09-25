<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Info **</title>
</head>
<body>
<h3>** Login Info **</h3>
session ID : <%= session.getId() %><br>
session 유효시간 : 10초 설정<br>
=> session 객체의 메서드 또는 web.xml에서 설정<br><br>
<% session.setMaxInactiveInterval(10); %>
</body>
</html>