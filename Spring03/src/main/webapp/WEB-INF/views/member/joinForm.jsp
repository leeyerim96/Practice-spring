<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
 body {
 	background-color:#FFEFEF;
 }
 </style>
<meta charset="UTF-8">
<title>** Member Join Spring Image **</title>
</head>
<body>
<div align=center>
<h3>**Member Join Spring Image **</h3>
<form action="mjoin" method="post" enctype="multipart/form-data">
<!-- enctype="multipart/form-data" : 화일  upload 를 가능하게 해줌   -->
<table>
<tr height="40"><td bgcolor="#FFCBCB">I D</td>
	<td><input type="text" name="id" value=""></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Password</td>
	<td><input type="password" name="password" value=""></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Name</td>
	<td><input type="text" name="name" value=""></td></tr>
<tr height="40"><td bgcolor="#FFCBCB" >Level</td>
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
<tr height="40"><td bgcolor="#FFCBCB">BirthDay</td>
	<td><input type="date" name="birthd" value=""></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Pay</td>
	<td><input type="number" name="pay" value=""></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Weight</td>
	<td><input type="text" name="weight" value=""></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Image</td>
	<td><input type="file" name="uploadfilef"></td></tr>
	
	
	
	
<tr><td></td><td><input type="submit" value="Join">
                 <input type="reset" value="Reset"></td>	
</table>
</form>
</div>
</body>
</html>