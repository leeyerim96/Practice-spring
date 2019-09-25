<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member Join **</title>
</head>
<body>
<h3>** Member Join **</h3>
<form action="/Spring01/mjoin.do" method="post">
<table border=1>
<tr height="40" align="center">
<td bgcolor="yellow">ID</td>
<td><input type="text" name="id" value=""></td></tr>  <!-- 수정할수없도록 readonly -->

<tr height="40" align="center">
<td bgcolor="yellow">Password</td>
<td><input type="password" name="password" value=""></td></tr>

<tr height="40" align="center">
<td bgcolor="yellow">Name</td>
<td><input type="text" name="name" value=""></td></tr>

<tr height="40" align="center">
<td bgcolor="yellow">Level</td>
<td><!-- <input type="text" name="lev" value=""></td></tr>  -->
	<!--  input Tag를 select로 변경하기 -->
	<select name=lev>
		<option value="A">관리자</option>
		<option value="B">나무</option>
		<option value="C">잎새</option>
		<option value="D">새싹</option>
	</select>
	</td></tr>

<tr height="40" align="center">
<td bgcolor="yellow">pay</td>
<td><input type="text" name="pay" value=""></td></tr>

<tr height="40" align="center">
<td bgcolor="yellow">Birthd</td>
<td><input type="date" name="birthd" value=""></td></tr>

<tr height="40" align="center">
<td bgcolor="yellow">Weight</td>
<td><input type="text" name="weight" value=""></td></tr>

<tr><td></td><td><input type="submit" value="Join">
				<input type="reset" value="Reset"></td>

</table>
</form>
</body>
</html>