<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Member Join Spring Image**</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/inCheck2.js"></script>
<script src="resources/jsLib/axTest.js"></script>
<script>
$(function() {
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
	  
	})
	
function idDupCheck() {
	
	//document.getElementById('sss').disabled="";
	if (idCheck()==false) return ;	
// window.open()
//=> 자바스크립트에서 새창을 띄워주는 함수
//=> window.open ("[요청명]", "[창이름 또는 로딩되는 창]", "[창 속성]");
	 var url='idcheck?id='+$('#id').val();
	window.open(url,"_blank"
		,"toolbar=no,menubar=yes,scrollbars=yes,resizable=yes,width=600,height=300"); 
}; // idDupCheck 

$(function(){
	$('#id').change(function() {
		document.getElementById('sss').disabled="disabled";
	}) // change
}) //ready

function idCheck(){
   alert("중복 된 ID인지 확인하시겠습니까?");
// id 확인   
   var id=$('#id').val();
   // id : 길이확인 (4이하 오류)
   if (id.length<4) {
      $('#iMessage').text('ID 를 4글자 이상 정확하게 입력 하세요 ~~**') ;
      $('#id').focus() ;  // 해당태그에 focus In
      iCheck=false ;
   }else if (id.replace(/[a-z.0-9]/gi,'').length>0) {
      $('#iMessage').text('ID 를 영문자와 숫자로만 정확하게 입력 하세요 ~~~') ;
      $('#id').focus() ;  // 해당태그에 focus In
      iCheck=false ;
   }
      $('#iMessage').text('') ;
      iCheck=true ;
    
}
</script>

</head>
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
<body>
<div align="center">
<h3>** memberJoin [InCheck & IDdup & Image] **</h3>
<form id=myForm action="mjoin" method="post" enctype="multipart/form-data">
<!-- => enctype="multipart/form-data" : 화일 upload 를 가능하게 해줌 -->
<table>
<tr height="40"><td bgcolor="#FFCBCB">I D</td>
   <td><input type="text" id="id" name="id" value="">
      <input type="button" value="ID 중복확인" onclick="idDupCheck()"><br>
   <span id=iMessage></span></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Password</td>
   <td><input type="password" id="password" name="password" value=""><br>
   <span id=pMessage></span></td></tr>
<tr height="40"><td bgcolor="silver">Password</td>
   <td><input type="password" id="password2" name="password2"><br>
   <span id=pwMessage></span></td></tr>
    
<tr height="40"><td bgcolor="#FFCBCB">Name</td>
   <td><input type="text" id="name" name="name" value=""><br>
   <span id=nMessage></span></td></tr>
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
     <span id=lMessage></span>
   </td></tr>
<tr height="40"><td bgcolor="#FFCBCB">BirthDay</td>
   <td><input type="date" id="birthd" name="birthd" value="">
   <span id=bMessage></span></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Pay</td>
   <td><input type="text" id="pay" name="pay" value="" size="10"><br>
   <span id=ppMessage></span></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Weight</td>
   <td><input type="text" id="weight" name="weight" value=""><br>
   <span id=wMessage></span></td></tr>
<tr height="40"><td bgcolor="#FFCBCB">Image</td>
   <td><input type="file" name="uploadfilef"></td></tr>

 ><td></td><td><input type="submit" value="가입" onclick="return insertCheck()"
               disabled="disabled" id="sss">
&nbsp;&nbsp;&nbsp;
                 <input type="reset" value="취소">
                 <input type="button" value="AJoin" id=ajoin></td>   
<tr><td></td><td><a href="home"><input id=btn type=button value='HOME'></a>

</table>
</form>
<a href="http://www.cursors-4u.com/cursor/2012/06/24/s-pink-premium-pointer.html" target="_blank" title="S Pink Premium Pointer"><img src="http://cur.cursors-4u.net/cursor.png" border="0" alt="S Pink Premium Pointer" style="position:absolute; top: 0px; right: 0px;" /></a>
</div>
</body>
</html>