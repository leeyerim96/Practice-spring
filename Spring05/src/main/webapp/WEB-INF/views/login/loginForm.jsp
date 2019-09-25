<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<style> 
* {cursor: url(http://ani.cursors-4u.net/cursors/cur-11/cur1089.cur), auto !important;}

 span {
      color:red; font-style: italic; font-size:x-small;
      }
      
 body {
 	background-color:#FFEFEF;
 }

 #btn { 

  padding: 5px 10px 5px 10px; 
  border: 5px solid pink; 
  background-color: #FFFCFC; 
  border-top-left-radius: 15px; 
  border-top-right-radius: 15px; 
  border-bottom-left-radius: 15px; 
  border-bottom-right-radius: 15px; 
   zoom: 1; 

 } 

 #btn:hover { 

  padding: 5px 10px 5px 10px; 
  border: 5px solid pink; 
  background-color: pink; 
  border-top-left-radius: 15px; 
  border-top-right-radius: 15px; 
  border-bottom-left-radius: 15px; 
  border-bottom-right-radius: 15px; 
  zoom: 1; 
 } 

</style> 

<meta charset="UTF-8">
<title>** Login Form **</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/axTest.js"></script>
<script src="resources/jsLib/inCheck.js"></script>
<script src="resources/jsLib/axTest3.js"></script>
<script>
//1) 개별적 오류 확인을 위한 switch 변수  : 전역	
var iCheck=false ;
var pCheck=false ;	

//2)  개별적 focusout 이벤트의  function 작성	
//=> JQuery 방식 : 그러므로  $(document).ready(function()... 필요	
$(function() {
// id 확인	
	  $('#id').focusout(function() {
	var id=$('#id').val();
	// id : 길이확인 (4이하 오류)
	if (id.length<4) {
		$('#iMessage').text('ID 를 4글자 이상 정확하게 입력 하세요 ~~') ;
		$('#id').focus() ;  // 해당태그에 focus In
		iCheck=false ;
	}else if (id.replace(/[a-z.0-9]/gi,'').length>0) {
		$('#iMessage').text('ID 를 영문자와 숫자로만 정확하게 입력 하세요 ~~~') ;
		$('#id').focus() ;  // 해당태그에 focus In
		iCheck=false ;
	}else {
		iCheck=true ;
		$('#iMessage').text('') ;
	} 
  }); // id
  
 // password
 $('#password').focusout(function() {
	 var password=$('#password').val();
	 if (password.replace(/(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{6,50}$/g,'').length>0) {
         $('#pMessage').text('숫자, 특문 각 1회 이상, 영문은 2개 이상 사용하여 6자리 이상 입력하세요.');
         $('#password').focus();  
         pCheck=false ;
    }else {
         pCheck=true ;
         $('#pMessage').text('') ;
      } 
  }); // password
  

    
}) // ready	

//3) 전체적으로 입력 오류 가 없음을 확인하고 submit 여부를 판단하는 function
function insertCheck() {
	if (iCheck==true && pCheck==true) 
		 return true;   // submit 진행
	else {
		alert('입력 자료에 오류가 있습니다.~~\n확인 후 전송 버튼을 누르세요 ~~') ;
		return false ; // submit 무효화
	}
} // inputCheck

</script>

</head>
<body>
<div align=center>
<h2>** Spring05_WEB Login **</h2>
<c:if test="${fail=='true'}">
	<script>alert('없는 아이디입니다!');
		$('#id').focus();
	</script>
</c:if>
<table>
<!-- focusout 을 이용해서 입력 오류 확인을 하세요 -->
<form action="login" method="post">
<tr><td>I      D : </td>
    <td><input type="text" name="id" id=id placeholder="아이디" ><br>
    <span id=iMessage></span></td>
</tr>
<tr><td>Password : </td>
    <td><input type="password" name="password" id=password placeholder="비밀번호" ><br>
    <span id=pMessage></span></td>
</tr>
<tr><td></td>
    <td><br><input id=btn type="submit" value="로그인" onclick="return insertCheck()"> &nbsp; 
        <input id=btn type="reset" value="초기화">
        <input type="button" value="Alogin" id=alogin>&nbsp; 
        <input type="button" value="jslogin" id=jslogin><br>
    </td>
</tr>
</form>
</table>
<br>
<hr>
<br> 
<a href="home"><input id=btn type=button value='HOME'></a>
<br>
<a href="http://www.cursors-4u.com/cursor/2012/06/24/s-pink-premium-pointer.html" target="_blank" title="S Pink Premium Pointer"><img src="http://cur.cursors-4u.net/cursor.png" border="0" alt="S Pink Premium Pointer" style="position:absolute; top: 0px; right: 0px;" /></a>
</div>
</body>
</html>