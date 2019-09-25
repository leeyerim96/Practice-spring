<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** LogOut Form SpDispatcherServlet **</title>
</head>
<body>
<h3>** LogOut Form SpDispatcherServlet **</h3>
<br>
GoodBye ~~~<br>
또 오세요 ~~~<br>
logoutTest=> ${loginID} 님은 logout 되었습니다.
<% session.invalidate(); %> 

</body>
</html>