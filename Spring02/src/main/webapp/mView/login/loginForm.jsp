<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Login Form **</title>
</head>
<body>
<h2>** Spring01_MVC2 SpDispatcherServlet Login **</h2>
<table>
<form action="/Spring02/login.do" method="post">
<tr><td>I      D : </td>
    <td><input type="text" name="id" value="banana"> </td>
</tr>
<tr><td>Password : </td>
    <td><input type="password" name="password" ></td>
</tr>
<tr><td></td>
    <td><input type="submit" value="Login"> &nbsp; 
        <input type="reset" value="Reset">
    </td>
</tr>
</form>
</table>
</body>
</html>