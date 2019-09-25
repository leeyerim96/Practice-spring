<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
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


	<title>Home</title>
</head>
<body>
<div align="center">
<h1>
	Hello world!!!  
</h1>

<P>  The time on the server is ${serverTime}. </P><br>

<img src="resources/image/cat.jpg" width=300 ><br><br><br>
<c:if test="${loginID==null}">
	<a href="loginf"><input id=btn type=button value='로그인'></a>&nbsp;&nbsp;
</c:if>
<c:if test="${loginID!=null}">
	<a href="logout"><input id=btn type=button value='로그아웃'></a>&nbsp;&nbsp;
</c:if>

<a href="joinf"><input id=btn type=button value='회원가입'></a>&nbsp;&nbsp;
<a href="mlist"><input id=btn type=button value='회원목록'></a>&nbsp;&nbsp;
<a href="blist"><input id=btn type=button value='게시판 1'></a>&nbsp;&nbsp;
<a href="plist"><input id=btn type=button value='게시판 2'></a>&nbsp;&nbsp;
<a href="plist2"><input id=btn type=button value='게시판 3'></a>

</div>
</body>
</html>
