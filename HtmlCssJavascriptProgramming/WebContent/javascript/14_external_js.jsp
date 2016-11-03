<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">	
		<script type="text/javascript" src="14_library.js"></script>
		<script type="text/javascript">
			function calculator(){
				var x = parseInt(document.querySelector("#x").value);
				var y = parseInt(document.querySelector("#y").value);
				document.querySelector("#result").value = $.sum(x,y);
			}
		</script>
	</head>
	
	<body>
		외부 자바스크립트 파일 로딩
		<hr/>
		<input id="x" type="text"/> 에서
		<input id="y" type="text"/> 까지의 합
		<button onclick="calculator()">계산</button>
		<input id="result" type="text" name="result" readonly/>
		
		
	</body>
	
</html>