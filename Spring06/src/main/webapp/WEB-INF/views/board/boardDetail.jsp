<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>** Board Detail **</title>
</head>
<body>
<div align=center>
<!-- => loginId와 writer가 같으면 수정, 삭제가능
=> 아니면서 로그인 했으면 댓글달기, 조회수 증가 -->
<h3>** Board Detail **</h3>
<form action="bupdate" method="post">
<table>
 <tr>
 <td bgcolor="#FFCBCB">S E Q</td>
 <td><input type="text" name="seq" value="${Apple.seq}" readonly="readonly"></td>
 </tr>
 
 <tr>
 <td bgcolor="#FFCBCB">I  D</td>
 <td><input type="text" name="id" value="${Apple.id}" readonly="readonly"></td>
 </tr>
 
 <tr>
 <td bgcolor="#FFCBCB">Title</td>
 	<td><c:if test="${Apple.id==loginID}">
 		<input type="text" name="title" value="${Apple.title}"></c:if>
 		<c:if test="${Apple.id!=loginID}">
 		${Apple.title}<br>
 		<%-- <input type="text" name="title" value="${Apple.title}" readonly="readonly">--%></c:if></td>
 </tr>
 

 
  <tr>
 <td bgcolor="#FFCBCB">Content</td>
 <td><c:if test="${Apple.id==loginID}">
 	<textarea name="content" rows="10" cols="40">${Apple.content}</textarea></c:if>
 	<c:if test="${Apple.id!=loginID}">
 	<textarea name="content" rows="10" cols="40" readonly="readonly">${Apple.content}</textarea></c:if></td>
 </tr>
 
  <tr>
 <td bgcolor="#FFCBCB">RegDate</td>
 <td><input type="text" name="regdate" value="${Apple.regdate}" readonly="readonly"></td>
 </tr>
 
 <tr>
 <td bgcolor="#FFCBCB">ViewCount</td>
 <td><input type="text" name="cnt" value="${Apple.cnt}" readonly="readonly"></td>
 </tr>
 
 
 <tr><td></td><td><c:if test="${Apple.id==loginID}">
 				  <input type="submit" value="글수정">&nbsp;
 				  <a href="bdelete?seq=${Apple.seq}&step=${Apple.step}&root=${Apple.root}"><input type="button" value="글삭제"></a>
 				 </c:if>
</td></tr>
</table>
</form><br>
<a href="binsertf"><input id=btn type=button value='새글쓰기'></a>&nbsp;&nbsp;
<a href="rinsertf"><input id=btn type=button value='댓글쓰기'></a>&nbsp;&nbsp;
<a href="blist"><input id=btn type=button value='게시판'></a>&nbsp;&nbsp;
<a href="home"><input id=btn type=button value='HOME'></a>
</div>
</body>
</html>