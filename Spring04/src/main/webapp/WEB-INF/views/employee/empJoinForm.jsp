<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Employee Join **</title>
</head>
<body>
<h3>** Employee Join **</h3>
<form action="ejoin" method="post">
<table>
<tr height="40"><td bgcolor="yellow">I D</td>
	<td><input type="text" name="id" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Password</td>
	<td><input type="password" name="password" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Name</td>
	<td><input type="text" name="name" value=""></td></tr>
<tr height="40"><td bgcolor="yellow" >Level</td>
	<td><input type="text" name="lev" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Enter</td>
	<td><input type="date" name="enter" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Gender</td>
	<td><input type="number" name="gender" value=""></td></tr>
<tr height="40"><td bgcolor="yellow">Phone</td>
	<td><input type="text" name="phone" value=""></td></tr>
<tr><td></td><td><input type="submit" value="Join">
                 <input type="reset" value="Reset"></td>	
</table>
</form>
</body>
</html>