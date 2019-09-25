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
<title>** Board Page List **</title>
</head>
<body>
<div align=center>
<h3>** Board Page List **</h3>
<img src="resources/image/line.gif" width=800>
<table width=800 >
  <tr bgcolor="#FFCBCB" align="left" height="30">
	<th>SEQ</th><th>Title</th><th>ID</th><th>RegDate</th><th>Count</th>
  </tr>
  <c:forEach var="bb" items="${Banana}">
  <tr align="left" height="30">
  	<td>${bb.seq}</td>
  	<!-- login 한 경우에만 detail을 볼 수 있도록 수정하기 -->
  	<td>
  	  <c:if test="${bb.indent>0}">
  	  	<c:forEach begin="1" end="${bb.indent}">
  	  		<span>&nbsp;&nbsp;</span>
  	  	</c:forEach>
  	  	<span style="color:red" >re..</span>
  	  </c:if>	
  	  <c:if test="${loginID==null}">
  	    ${bb.title}
  	  </c:if>
  	  <c:if test="${loginID!=null}">
  	  <!-- 글수정.삭제와 조회수 증가 처리를 위해  writer_id 값도 서버로   -->
  	    <a href="bdetail?seq=${bb.seq}&id=${bb.id}">${bb.title}</a>
  	  </c:if>
  	</td>
  	<td>${bb.id}</td><td>${bb.regdate}</td><td>${bb.cnt}</td>
  </tr>
  </c:forEach>
</table>
<br>
<!-- Paging 추가 -->
<c:forEach var="i" begin="1" end="${totalPage}">
	<c:choose>
		<c:when test="${i==currPage}">
			<font size="5" color="Orange">${i}</font>&nbsp;
		</c:when>
		<c:otherwise>
		 <a href="plist?currPage=${i}">${i}</a>&nbsp;
		</c:otherwise>
	</c:choose>
</c:forEach>

<!-- login 한 경우에만 새글쓰기가 가능하도록 수정하기 -->
<hr><br>
<c:if test="${loginID!=null}">
  <a href="binsertf"><input id=btn type=button value='새글쓰기'></a>&nbsp;
</c:if>
<a href="home"><input id=btn type=button value='HOME'></a>
</div>
</body>
</html>