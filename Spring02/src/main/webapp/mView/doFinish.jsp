<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member DoFinish Factory**</title>
</head>
<body>
<h3>** Member DoFinish SpDispatcherServlet **</h3>
<c:if test="${fCode=='D'}">
	<h3> 당신의 정보는 없습니다~~~</h3>
	<a href="/Spring02/mView/login/loginForm.jsp">로그인 하기</a>
</c:if>
<c:if test="${fCode=='U'}">
	<h3> 정보 수정에 실패했습니다~~~</h3>
	<a href="/Spring02/mlist.do">memberList</a>
</c:if>
<c:if test="${fCode=='JS'}">
	<h3>${joinID} 님 회원 가입 되었습니다~~</h3>
	<a href="/Spring02/mView/login/loginForm.jsp">로그인 하기</a>
</c:if>
<c:if test="${fCode=='JF'}">
	<h3>회원 가입 실패~~</h3>
	<h3>다시 하시겠습니까 ?</h3>
	<a href="/Spring02/mView/joinForm.jsp">[회원가입]</a>
</c:if>
<c:if test="${fCode=='DS'}">
	<h3>회원 탈퇴 되었습니다~~</h3>
</c:if>
<c:if test="${fCode=='DF'}">
	<h3>회원 탈퇴 실패~~</h3>
</c:if>

<a href="/Spring02/mView/index.jsp">HOME</a>
</body>
</html>