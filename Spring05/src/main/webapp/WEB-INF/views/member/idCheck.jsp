<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** ID 중복 확인 **</title>
<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/inCheck.js"></script>
<script>
   function idOk(){
      //joinForm(parent window : opener)으로 id를 전달하고 ,
      //현재의 창은 닫는다.
      opener.document.getElementById('id').value="${id}";
      opener.document.getElementById('sss').disabled="";
      opener.$('#id').prop("readonly",true);
      opener.$('#password').focus();
      self.close();
   }//idOk
   //=> attr()는 HTML의 속성을 취급
   //=> prop()는 JavaScript의 프로퍼티를 취급
   
</script>
<style>
   body{
   background-color:#FAC1C1;
   font-size:12px;
      }
   
</style>
</head>

<body>

<h3><b>** ID 중복 확인 **</b></h3>
<form action="idcheck" method="get">
User ID :
<input type="text" id="id" name="id" value="">
<input type="submit" value="ID 중복확인" onclick="return idCheck()">
<br><hr><br>
<div>
   <c:if test="${idCheck=='T'}">   
       <script>
      opener.alert("사용가능!!!");
      self.close(); 
      </script>
   </c:if>
   <c:if test="${idCheck!='T'}">   
       <script>
      opener.alert("사용불가능 !!!");
      self.close(); 
      </script>
      <!-- 부모창의 id 값을 clear 하려면? -> only JS만 가능 -->
      <script>
      opner.document.getElementById('id').value="";
      </script>
   </c:if>
</div>

</form>

</body>
</html>