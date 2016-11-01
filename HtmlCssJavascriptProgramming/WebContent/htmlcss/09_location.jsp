<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			#div1{
				position: absolute;
				left : 100px;
				top: 200px;
				width: 100px;
				height: 100px;
				background-color: red;
			}
			#div2{
				width: 200px;
				height: 100px;
				background-color: blue;
			}
			#div3{
				position: fixed;
				left : 300px;
				top: 200px;
				width: 100px;
				height: 100px;
				background-color: red;
			}
			#div4{
				position: relative;
				left : 500px;
				top: 100px;
				width: 100px;
				height: 100px;
				background-color: yellow;
			}
			#div5{
				position: absolute;
				left : 200px;
				top: 100px;
				width: 50px;
				height: 50px;
				background-color: green;
			}
		</style>
	</head>
	
	<body>
		
		<div id="div1"></div>
		<div id="div2"></div>
		<div id="div3"></div>
		<div id="div4">
			<div id="div5"></div>
		</div>
		
		<%for(int i =0;i<30;i++) {%>
			<br/>
		<%} %>
	</body>
	
</html>