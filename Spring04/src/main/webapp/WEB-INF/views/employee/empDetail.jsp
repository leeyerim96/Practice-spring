<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** employee Detail, Update **</title>
</head>
<body>
<h3>** employee Detail **</h3>
<form action="eupdate" method="post">
<table>
<tr height="40"><td bgcolor="gray">I D</td>
	<td><input type="text" name="id" value="${banana.id}" readonly="readonly"></td></tr>
<tr height="40"><td bgcolor="gray">Password</td>
	<td><input type="password" name="password" value="${banana.password}"></td></tr>
<tr height="40"><td bgcolor="gray">Name</td>
	<td><input type="text" name="name" value="${banana.name}"></td></tr>
<tr height="40"><td bgcolor="gray" >Level</td>
	<td><input type="text" name="lev" value="${banana.lev}"></td></tr>
<tr height="40"><td bgcolor="gray">Enter</td>
	<td><input type="date" name="enter" value="${banana.enter}"></td></tr>
<tr height="40"><td bgcolor="gray">Gender</td>
	<td><input type="text" name="gender" value="${banana.gender}"></td></tr>
<tr height="40"><td bgcolor="gray">Phone</td>
	<td><input type="text" name="phone" value="${banana.phone}"></td></tr>
<tr><td></td><td><input type="submit" value="Submit">
                 	
</table>
</form>
 
</body>
</html>