<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC empList **</title>
</head>
<body>
<h3>** Spring_MVC empList **</h3>
<table width=800 border="1">
<tr align="center" height=30 bgcolor="pink">
   <td>I D</td><td>Password</td><td>Name</td>
   <td>Lev</td><td>Enter</td><td>Gender</td>
   <td>Phone</td>
</tr>
<c:forEach var="mm" items="${banana}">
   <tr align="center" height=30>
      <td><a href="edetail?id=${mm.id}">${mm.id}</a></td>
         
   <td>${mm.password}</td><td>${mm.name}</td>
   <td>${mm.lev}</td>
   <td>
      ${mm.enter}
    
   </td>
   <td>${mm.gender}</td>
   
   <td>${mm.phone}</td>
   </tr>
</c:forEach>
</table>

<a href="home">[HOME]</a><br>
<a href="#" onclick="history.back()">[이전으로]</a> 
</body>
</html>