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
<title>** board Page List2 **</title>
</head>
<body>
<div align=center>
<h2>** Board PageList2_PageNo 제한 **</h2>
<img src="resources/image/line.gif" width=800>
<table width=800 >
	<tr bgcolor="#FFCBCB" align="center" height="30">
	<th>SEQ</th><th>Title</th><th>I D</th><th>RegDate</th><th>Count</th></tr>
	<c:forEach var="bb"  items="${Banana}">
	  <tr align="left" height="30" bgcolor="WhiteSmoke">
		<td>${bb.seq}</td>
		
		<!-- 글수정.삭제와 조회수 증가 처리를 위해  writer 값도 서버로   -->
		<td><c:if test="${bb.indent>0}">
				<c:forEach begin="1" end="${bb.indent}">
					<span>&nbsp;&nbsp;</span>
				</c:forEach>
				<span style="color:red;">re..</span>
			</c:if>
			 <c:if test="${loginID==null}">
      ${bb.title}
    </c:if>
    <c:if test="${loginID!=null}">
      <a href="bdetail?seq=${bb.seq}&id=${bb.id}">${bb.title}</a>
    </c:if>
		
		<td>${bb.id}</td>
		<td>${bb.regdate}</td>
		<td>${bb.cnt}</td>
	  </tr>
	</c:forEach>
</table>
<br>
<!--  Paging2 Code 추가   --> 
 <div align="center">
 	<c:choose>
 		<c:when test="${sPage > perPageNo}">
 			<a href="plist2?currPage=1"> 〈〈  </a>&nbsp;
 			<a href="plist2?currPage=${sPage-1}">〈 </a>&nbsp;
 		</c:when>
 		<c:otherwise>
 			〈〈&nbsp;〈 &nbsp;&nbsp;
 		</c:otherwise>
 	</c:choose>
 	
 	<c:if test="${totalPage < ePage}">
 		<c:set var="ePage" value="${totalPage}"></c:set>
 	</c:if>
 	<c:forEach var="i" begin="${sPage}" end="${ePage}">
 		<c:choose>
 			<c:when test="${i==currPage}">
 				<font size="5" color="Orange">${i}</font>&nbsp;
 			</c:when>
 			<c:otherwise>
 				<a href="plist2?currPage=${i}">${i}</a>&nbsp;
 			</c:otherwise>
 		</c:choose>
 	</c:forEach>
 	
 	<c:choose>
 		<c:when test="${totalPage==ePage}">
 			  〉&nbsp; 〉〉&nbsp;&nbsp;
 		</c:when>
 		<c:otherwise>
 			<a href="plist2?currPage=${ePage+1}">  〉</a>&nbsp;
 			<a href="plist2?currPage=${totalPage}"> 〉〉</a>&nbsp;
 		</c:otherwise>
 	</c:choose>
 </div> 
 <br><hr><br>
<a href="home"><input id=btn type=button value='HOME'></a>&nbsp;&nbsp;
<c:if test="${loginID!=null}">
  <a href="binsertf"><input id=btn type=button value='새글쓰기'></a>&nbsp;
</c:if>
</div>
</body>
</html>