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
<title>** Board Insert **</title>
</head>
<body>
<div align=center>
<h3>** Board Insert **</h3>
<form action="rinsert" method="post">
<table>

  <tr><td bgcolor="#FFCBCB">Root</td>
      <td><input type="text" name="root" value="${root}" readonly="readonly">
  </td></tr>
  
  <tr><td bgcolor="#FFCBCB">I  D</td>
      <td><input type="text" name="id" value="${loginID}" readonly="readonly">
  </td></tr>
  
  <tr><td bgcolor="#FFCBCB">Title</td>
      <td><input type="text" name="title" value="">
  </td></tr>
  
  <tr><td bgcolor="#FFCBCB">Content</td>
      <td><textarea name="content" rows="10" cols="40"></textarea>
  </td></tr>
  
  <tr><td></td>
       <td><input type="submit" value="댓글등록">&nbsp;
           <input type="reset"  value="Reset">
  </td></tr>
  
</table>
</form><br>

<a href="blist"><input id=btn type=button value='게시판'></a>&nbsp;&nbsp;
<a href="home"><input id=btn type=button value='HOME'></a>
</div>
</body>
</html>