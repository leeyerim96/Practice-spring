<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** 내장함수 eval를 이용한 계산기</title>
<style>
	button {width: 50px;}
</style>
<script>
	var expression='';
	function input(b){
		expression+=b;
		document.getElementById('display').value
		= expression;
	}
	function compute(){
		var result = eval(expression);
		document.getElementById('display').value
		= result;
	}
	function clearExpression(){
		expression='';
		document.getElementById('display').value = expression;
	}
	
	
	function finish(){
		self.close();
	}
</script>
</head>
<body>
<h3>** 내장함수 eval를 이용한 계산기</h3>
=> eval : 문자열을 수식으로 바꾸어 계산해줌<br>
display :<br>
<input id="display" value="0" size="30"><br>
<button onclick="input('7')">7</button>
<button onclick="input('8')">8</button>
<button onclick="input('9')">9</button>
<button onclick="input('/')">/</button><br>

<button onclick="input('4')">4</button>
<button onclick="input('5')">5</button>
<button onclick="input('6')">6</button>
<button onclick="input('*')">*</button><br>

<button onclick="input('1')">1</button>
<button onclick="input('2')">2</button>
<button onclick="input('3')">3</button>
<button onclick="input('-')">-</button><br>

<button onclick="input('0')">0</button>
<button onclick="input('+')">+</button>
<button onclick="clearExpression()">Clear</button>
<button onclick="compute()">Enter</button>

<br><br>
<button onclick="finish()">finish</button>
</body>
</html>