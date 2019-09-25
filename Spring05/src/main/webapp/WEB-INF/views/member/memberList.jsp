<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC MemberList_Mybatis**</title>
<style>
* {cursor: url(http://ani.cursors-4u.net/cursors/cur-11/cur1089.cur), auto !important;}
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
<div align=center>
<h3>** Spring_MVC MemberList_Mybatis **</h3>
<img src="resources/image/line.gif" width=800>
<table width=800>
<tr align="center" height=30 bgcolor="pink">
   <td>I D</td><td>Password</td><td>Name</td>
   <td>Lev</td><td>BirthDay</td><td>Pay</td>
   <td>Weight</td><td>Image</td>
</tr>
<c:forEach var="mm" items="${Banana}">
   <tr align="center" height=30>
   <!-- 관리자 기능 추가 -->
   <c:if test="${loginID=='admin'}">
      <td><a href="mdetail?id=${mm.id}">${mm.id}</td>
   </c:if>
   <c:if test="${loginID!='admin'}">
      <td>${mm.id}</td>
   </c:if>   
   <td>${mm.password}</td><td>${mm.name}</td>
   <td>${mm.lev}
   <!-- sql에서 DECODE 적용 Test -->
     <c:choose>
         <c:when test="${mm.lev=='A'}"> 관리자</c:when>
         <c:when test="${mm.lev=='B'}"> 나무</c:when>
         <c:when test="${mm.lev=='C'}"> 잎새</c:when>
         <c:when test="${mm.lev=='D'}"> 새싹</c:when>
         <c:otherwise>ERROR</c:otherwise>
   </c:choose></td>
   <td>
      ${mm.birthd}
       <%-- <fmt:formatDate value="${mm.birthd}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초 "/> --%>
   </td>
   <td>
      <fmt:formatNumber value="${mm.pay}" pattern="##,###,###"/>
   </td>
   <td>${mm.weight}</td>
   <td><img src="${mm.uploadfile}" width="100" height="100"></td>
   </tr>
</c:forEach>
</table><br>
<a href="http://www.cursors-4u.com/cursor/2012/06/24/s-pink-premium-pointer.html" target="_blank" title="S Pink Premium Pointer"><img src="http://cur.cursors-4u.net/cursor.png" border="0" alt="S Pink Premium Pointer" style="position:absolute; top: 0px; right: 0px;" /></a>
<a href="home"><input id=btn type=button value='HOME'></a>&nbsp;&nbsp;
<a href="#" onclick="history.back()"><input id=btn type=button value='TRY AGAIN'></a> <br><br>
</div>
</body>
</html>