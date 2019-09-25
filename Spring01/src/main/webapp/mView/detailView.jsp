<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**Spring01 Member Detail, Update **</title>
</head>
<body>
<h3>**Spring01 Member Detail **</h3>

<form action="/Spring01/mupdate.do" method="post">
<table border=1>
<tr height="40" align="center">
<td bgcolor="pink">ID</td>
<td><input type="text" name="id" value="${Apple.id}" readonly="readonly"></td></tr>  <!-- 수정할수없도록 readonly -->

<tr height="40" align="center">
<td bgcolor="pink">Password</td>
<td><input type="password" name="password" value="${Apple.password}"></td></tr>

<tr height="40" align="center">
<td bgcolor="pink">Name</td>
<td><input type="text" name="name" value="${Apple.name}"></td></tr>

<tr height="40" align="center">
<td bgcolor="pink">Level</td>
<td>
<!-- input Tag를 select로 변경하면서 -->
<!-- lev에 해당하는 값이 default 값으로 표시되도록 -->
<%-- <input type="text" name="lev" value="${Apple.lev}"></td></tr> --%>
<c:choose>
	<c:when test="${Apple.lev=='A'}">
		<select name="lev">
			<option value="A" selected="selected">관리자</option>
			<option value="B">나무</option>
			<option value="C">잎새</option>
			<option value="D">새싹</option>
		</select>
	</c:when>
	<c:when test="${Apple.lev=='B'}">
		<select name="lev">
			<option value="A" >관리자</option>
			<option value="B" selected="selected">나무</option>
			<option value="C">잎새</option>
			<option value="D">새싹</option>
		</select>
	</c:when>
	<c:when test="${Apple.lev=='C'}">
		<select name="lev">
			<option value="A" >관리자</option>
			<option value="B" >나무</option>
			<option value="C" selected="selected">잎새</option>
			<option value="D">새싹</option>
		</select>
	</c:when>
	<c:when test="${Apple.lev=='D'}">
		<select name="lev">
			<option value="A" >관리자</option>
			<option value="B" >나무</option>
			<option value="C" >잎새</option>
			<option value="D" selected="selected">새싹</option>
		</select>
	</c:when>
	<c:otherwise>
	<select name="lev">
			<option value="A" >관리자</option>
			<option value="B" >나무</option>
			<option value="C" >잎새</option>
			<option value="D" >새싹</option>
			<option value="E" selected="selected" >Error</option>
		</select>
	</c:otherwise>
</c:choose>
<tr height="40" align="center">
<td bgcolor="pink">pay</td>
<td><input type="number" name="pay" value="${Apple.pay}"></td></tr>

<tr height="40" align="center">
<td bgcolor="pink">Birthd</td>
<td><input type="date" name="birthd" value="${Apple.birthd}"></td></tr>

<tr height="40" align="center">
<td bgcolor="pink">Weight</td>
<td><input type="text" name="weight" value="${Apple.weight}"></td></tr>

<tr><td></td><td><input type="submit" value="Submit">
				<input type="reset" value="Reset"></td>

</table>
</form>
<br>
<c:if test="${loginID=='admin'}">
========><a href="/Spring01/mdelete.do?id=${Apple.id}">회원삭제</a>
</c:if>
</body>
</html>


<!-- 
->detailView.jsp
관리자 로그인 확인 , delete 요청 기능 추가 , delete 컨트롤러에서 delete 처리 

->DeleteController
누구를 삭제하는지 확인 , DAO에서 삭제 (동일방법) , 결과 처리 - 성공 : mlist - 실패 : doFinish.jsp
-->
