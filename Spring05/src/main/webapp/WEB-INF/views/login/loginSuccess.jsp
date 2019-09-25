<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style> 

 body {
 	background-color:#FFEFEF;
 }

 #btn { 

  padding: 5px 10px 5px 10px; 
  border: 5px solid pink; 
  background-color:#FFFCFC; 
  border-top-left-radius: 15px; 
  border-top-right-radius: 15px; 
  border-bottom-left-radius: 15px; 
  border-bottom-right-radius: 15px; 
   zoom: 1; 

 } 

 #btn:hover { 

  padding: 5px 10px 5px 10px; 
  border: 5px solid pink; 
  background-color: pink; 
  border-top-left-radius: 15px; 
  border-top-right-radius: 15px; 
  border-bottom-left-radius: 15px; 
  border-bottom-right-radius: 15px; 
  zoom: 1; 
 } 
</style>
<meta charset="UTF-8">
<title>** Login Success **</title>
</head>
<body>
<div align=center>
<h3>** Login Success SpDispatcherServlet **</h3>
<br>
<script>
alert('~~ 로그인 성공 ~~');
</script>
${loginID} 님 안녕하세요<br><br>
<img src="resources/image/hi.jpg"><br><br>
<a href="mdetail"><input id=btn type=button value='내정보 보기'></a>&nbsp;&nbsp;
<a href="mlist"><input id=btn type=button value='회원목록'></a>&nbsp;&nbsp;
<a href="blist"><input id=btn type=button value='게시판'></a>&nbsp;&nbsp;
<a href="mdelete"><input id=btn type=button value='회원탈퇴'></a>&nbsp;&nbsp;
</div>
</body>
</html>