 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<style>
 body {
 	background-color:#FFEFEF;
 	align:center;
 }
 </style>
<meta charset="UTF-8">
<title>** Member Detail, Update **</title>
</head>
<body>
<div align=center>
<h3>** Member Detail SpDispatcherServlet **</h3>
<form action="mupdate" method="post" enctype="multipart/form-data">
<table>
<tr height="40"><td bgcolor="#FFCBCB">I D</td>
	<td><input type="text" name="id" value="${Apple.id}" readonly="readonly"></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Password</td>
	<td><input type="password" name="password" value="${Apple.password}"></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Name</td>
	<td><input type="text" name="name" value="${Apple.name}"></td></tr>
<tr height="40"><td bgcolor="#FFCBCB" >Level</td>
	<td>
	<!-- input Tag 를 select 로 변경하면서 -->
	<!-- lev 에 해당하는 값이 default 값으로 표시 되도록  -->
	<%-- <input type="text" name="lev" value="${Apple.lev}"> --%>
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
				<option value="A">관리자</option>
				<option value="B" selected="selected">나무</option>
				<option value="C">잎새</option>
				<option value="D">새싹</option>
			</select>
		</c:when>
		<c:when test="${Apple.lev=='C'}">
			<select name="lev">
				<option value="A">관리자</option>
				<option value="B">나무</option>
				<option value="C" selected="selected">잎새</option>
				<option value="D">새싹</option>
			</select>
		</c:when>
		<c:when test="${Apple.lev=='D'}">
			<select name="lev">
				<option value="A">관리자</option>
				<option value="B">나무</option>
				<option value="C">잎새</option>
				<option value="D" selected="selected">새싹</option>
			</select>
		</c:when>
		<c:otherwise>
			<select name="lev">
				<option value="A">관리자</option>
				<option value="B">나무</option>
				<option value="C">잎새</option>
				<option value="D">새싹</option>
				<option value="E" selected="selected">Error</option>
			</select>
		</c:otherwise>
	</c:choose>
	</td></tr>
<tr height="40"><td bgcolor="#FFCBCB">BirthDay</td>
	<td><input type="date" name="birthd" value="${Apple.birthd}"></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Pay</td>
	<td><input type="number" name="pay" value="${Apple.pay}"></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Weight</td>
	<td><input type="number" name="weight" value="${Apple.weight}"></td></tr>
	<tr height="40"><td bgcolor="#FFCBCB">Image</td>
	<td><img src="${Apple.uploadfile}">
	<input type="text" name="uploadfile" value="${Apple.uploadfile}" hidden="true"><br>
	<input type="file" name="uploadfilef"></td></tr>
		
	

<tr><td></td><td><input type="submit" value="Submit">
                 <input type="reset" value="Reset"></td>	
</table>
</form>
<br>
<c:if test="${loginID=='admin'}">
	======><a href="mdelete?id=${Apple.id}">회원삭제</a>
</c:if>
</div>
</body>
</html>