<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** PopUp Login Form**</title>
<script src="resources/jsLib/inCheck2.js"></script>
<style>
 body {
 	background-color:#FFEFEF;
 }
 
 table{border:1px solid #FFA7A7; border-collapse:collapse;}
 td, th{border: 1px solid #FFA7A7;}
 
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
</head>
<body>
<h3>** Login Form**</h3>
<form action="plogin" method="post">
	User ID :
	<input type="text" id="id" name="id" value="banana"><br>
	Password:
	<input type="password" id="password" name="password" value="12345"><br>
	<input type="submit" value="poplogin"><br>
</form>
<div style="margin-top: 20px">
	<c:if test="${loginR=='T'}">
		${id}님 !!! 로그인 성공<br>
	  <script>
     /*  opener.alert("${id} 님이 로그인 했습니다. !!!");
      self.close(); */
      </script>
	</c:if>
	<c:if test="${loginR=='F'}">
		${id}님 !! 로그인 실패!! <br>
		다시하세요 <br>
	</c:if>
	
</div>
</body>
</html>