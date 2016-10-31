<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			body{
				background-image: url("../common/image/paper.gif");
				/* background-repeat: no-repeat; */
				/* background-position: right top; */
			}
			.album{
				width: 200px;
				height: 180px;
				background-image: url(../common/image/헤이즈.jpg);
				display: inline-block;
				/* background-size: 200px 180px; */
			}
			
		</style>
	</head>
	
	<body>
		background 관련 CSS 속성
		<hr/>
		<%for(int i=0;i<=50;i++) {%>
			<div class="album" >
				헤이즈		
			</div>
		<%} %>
	</body>
	
</html>