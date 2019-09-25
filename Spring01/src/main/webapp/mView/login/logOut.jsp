<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**LogOut Form **</title>
</head>
<body>
<h2>**LogOut Form **</h2>
GoodBye ~~~<br>
또 오세요~~~<br>
logoutTest => ${loginID} 님 은 logout 되었습니다.
<% session.invalidate(); %> <!-- 보관되었던 값을 모두 삭제처리 -->
<!--logoutTest => ${loginID} 님 은 logout 되었습니다. 이것을 session.invalidate() 뒤에 넣으면 이미 다 삭제된 후라 id가 안뜸-->
</body>
</html>