<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** employee DoFinish **</title>
</head>
<body>
<h3>** employee DoFinish  **</h3>

<c:if test="${fCode=='U'}">
	<h3> 정보 수정에 실패했습니다~~~</h3>
</c:if>
<c:if test="${fCode=='JS'}">
	<h3>${joinID} 님  사원등록 되었습니다~~</h3>
</c:if>
<c:if test="${fCode=='JF'}">
	<h3>사원등록 실패~~</h3>
	<h3>다시 하시겠습니까 ?</h3>
	
</c:if>
<c:if test="${fCode=='DS'}">
	<h3>사원 탈퇴 되었습니다~~</h3>
</c:if>
<c:if test="${fCode=='DF'}">
	<h3>사원 탈퇴 실패~~</h3>
</c:if>

<a href="#" onclick="history.back()">[다시 하기]</a> 
<a href="home">HOME</a>
</body>
</html>