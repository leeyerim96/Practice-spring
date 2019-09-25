<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>** BoardFinish SpringMVC**</title>
</head>
<body>
<div align=center>
<h3>** BoardFinish SpringMVC **</h3>

<c:if test="${fCode=='I'}">
   <h3>새글 입력에 실패 했습니다~~</h3>
   <a href="javascript:history.go(-1)"><input id=btn type=button value='TRY AGAIN'></a> 
</c:if>
<c:if test="${fCode=='D'}">
	<h3> 글 삭제에 실패했습니다~~~</h3>
	 <a href="javascript:history.go(-1)"><input id=btn type=button value='TRY AGAIN'></a> 
</c:if>
<c:if test="${fCode=='U'}">
	<h3> 글 수정에 실패했습니다~~~</h3>
	 <a href="javascript:history.go(-1)"><input id=btn type=button value='TRY AGAIN'></a> 
</c:if>
<br>

<a href="home"><input id=btn type=button value='HOME'></a>&nbsp;&nbsp;
<a href="blist"><input id=btn type=button value='게시판'></a>&nbsp;&nbsp;
</div>
</body>
</html>