<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member Join SpDispatcherServlet **</title>
</head>
<body>
<h3>** Member Join SpDispatcherServlet **</h3>
<form action="/Spring02/mjoin.do" method="post">
<table>
<tr height="40"><td bgcolor="yellow">I D</td>
	<td><input type="text" name="id" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Password</td>
	<td><input type="password" name="password" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Name</td>
	<td><input type="text" name="name" value=""></td></tr>
<tr height="40"><td bgcolor="yellow" >Level</td>
	<td>  
	<!-- input Tag 를 select 로 변경하기 -->
	<!-- <input type="text" name="lev" value=""> -->
	  <select name=lev>
		<option value="A">관리자</option>
		<option value="B">나무</option>
		<option value="C">잎새</option>
		<option value="D">새싹</option>
	  </select>
	</td></tr>
<tr height="40"><td bgcolor="yellow">BirthDay</td>
	<td><input type="date" name="birthd" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Pay</td>
	<td><input type="number" name="pay" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Weight</td>
	<td><input type="text" name="weight" value=""></td></tr>
<tr><td></td><td><input type="submit" value="Join">
                 <input type="reset" value="Reset"></td>	
</table>
</form>
</body>
</html>