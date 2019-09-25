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
  background-color: #FFFCFC; 
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
<title>** Spring DupKeyException Message **</title>
</head>
<body>
<h2>** Spring  DupKeyException Message **</h2>
<h2>입력시 문제가 발생 했습니다 ~</h2>
<h2>=> ID가 중복되어 Rollback 되었습니다~</h2>
<h2>exception Message => ${exception.message}</h2>
<h2>다시 하세요!</h2>
<br><br>
<a href="home"><input id=btn type=button value='HOME'></a>
</body>
</html>