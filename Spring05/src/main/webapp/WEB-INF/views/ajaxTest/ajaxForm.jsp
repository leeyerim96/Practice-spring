<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Ajax Test Main Form **</title>
<style>
 div>span {
		color:red; font-style: italic; font-size:small;
		}
		
#header {
	background-color: #FFB4B4;
	width: 100%;
	height: 30px;
}

#resultArea {
	height: 1000px;
}

#btn_top {
	position: fixed;
	right: 2%;
	bottom: 50px;
	display: none;
	z-index: 9999;
	cursor: pointer;
}
</style>

<script src="resources/jsLib/jquery-3.2.1.min.js"></script>
<script src="resources/jsLib/axTest.js"></script>
<script src="resources/jsLib/axTest2.js"></script>
<script src="resources/jsLib/axTest3.js"></script>

<script>
$(document).ready(function() {
	$(window).scroll(function(){
		// 상단 Header고정
		if($(this).scrollTop() > 0) {
			$('#header').css({
				position: "fixed",
				top: 0
			});
			$('#top_margin').show();
		}
		if($(this).scrollTop() > 300) {
			$('#btn_top').fadeIn();
		} else {
			$('#btn_top').fadeOut();
		}
	});
	$('#btn_top').click(function(){
		$('html,body').animate({
			scrollTop: 0
		},200);
	});
	
});
</script>
</head>
<body>
<h3>** Ajax Test Main Form **</h3>
<div id="header" align="center"><span id=aloginf class=textLink>LOGIN </span>&nbsp;|&nbsp;
<span id=ploginf class=textLink>POPUPLOGIN </span>&nbsp;|&nbsp;
<span id=ajoinf class=textLink>JOIN </span>&nbsp;|&nbsp;
<span id=amlist class=textLink>AMEMBERLIST </span>&nbsp;|&nbsp;
<span id=ablist class=textLink>ABOARDLIST </span>&nbsp;|&nbsp;
<span id=jsloginf class=textLink>JSLOGIN</span></div>
<!-- <img src="resources/image/bar.gif"><br>
<span id=aloginf class=textLink>[Login]</span>&nbsp;
<span id=ploginf class=textLink>[PopUpLogin]</span>&nbsp;
<span id=ajoinf class=textLink>[Join]</span>&nbsp;
<span id=amlist class=textLink>[aMemberList]</span>&nbsp;
<span id=ablist class=textLink>[aBoardList]</span>&nbsp; -->
<hr>
<div id=resultArea></div>
<div id="btn_top">
	<img src="resources/image/top_button.png" width=50/>
</div>

</body>
</html>