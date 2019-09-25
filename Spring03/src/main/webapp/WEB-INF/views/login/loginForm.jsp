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
<title>** Login Form **</title>
</head>
<body>
<div align=center>
<h2>** Spring03_WEB Login **</h2>
<table>
<form action="login" method="post">
<tr><td>I      D : </td>
    <td><input type="text" name="id" placeholder="아이디"> </td>
</tr>
<tr><td>Password : </td>
    <td><input type="password" name="password" placeholder="비밀번호" ></td>
</tr>
<tr><td></td>
    <td><br><input id=btn type="submit" value="로그인"> &nbsp; 
        <input id=btn type="reset" value="초기화">
    </td>
</tr>
</form>
</table>
<br>
<hr>
<br> 
<a href="home"><input id=btn type=button value='HOME'></a>
<br>
</div>
</body>
</html>