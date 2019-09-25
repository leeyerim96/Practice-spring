<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Board List Ajax **</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/axTest.js"></script>
<script src="resources/jsLib/axTest2.js"></script>
<script src="resources/jsLib/axTest3.js"></script>
<style> 

 body {
 	background-color:#FFEFEF;
 	align:center;
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
<h3>** Board List Ajax **</h3>
<table width=800 >
  <tr bgcolor="#FFCBCB" align="left" height="30">
	<th>SEQ</th><th>Title</th><th>ID</th><th>RegDate</th><th>Count</th>
  </tr>
  <c:forEach var="bb" items="${Banana}" varStatus="vs">
  <tr align="left" height="30">
  	<td><span id='seq${vs.index}'>${bb.seq}</span></td>
  	<td>
  	  <c:if test="${bb.indent>0}">
  	  	<c:forEach begin="1" end="${bb.indent}">
  	  		<span>&nbsp;&nbsp;</span>
  	  	</c:forEach>
  	  	<span style="color:red" >re..</span>
  	  </c:if>	
  	   <a href="#" class=ct id='${vs.index}' onclick="axBDetail('${bb.seq}','${vs.index}')">${bb.title}</a>
  	</td>
  	<td>${bb.id}</td><td>${bb.regdate}</td><td>${bb.cnt}</td>
  </tr>
  <tr><td></td>
      <td colspan="4"><span id='result${vs.index}' class=result></span></td>
  </tr>
  </c:forEach>
</table>
<br>
<hr><br>
<c:if test="${loginID!=null}">
   <a href="binsertf"><input id=btn type=button value='새글쓰기'></a>&nbsp;
</c:if>
<a href="home"><input id=btn type=button value='HOME'></a> <br><br>
</body>
</html>