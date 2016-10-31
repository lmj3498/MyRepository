<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- External Style Sheet --><!-- 가장 많이 사용(프레임워크) --><!-- 장점: 재사용 용이 -->
		<link rel="stylesheet" type="text/css" href="05_style.css">
		
		<!-- Internal Style Sheet --><!-- 단점 : 재사용 불가(현 jsp에서만 적용) -->
		<style type="text/css">
			.menu{
				background-color: #ffffff;
			}
			.menu li{
				color: orange;
			}
		</style>
	</head>
	
	<body>
		CSS Location
		<hr/>
		<header>제목</header>
		<p>내용</p>
		<a href="http://tomcat.apache.org">톰캣</a>
		<div class="menu">
			<ul>
				<li>메뉴1</li>
				<li>메뉴2</li>
				<li>메뉴3</li>
				
			</ul>
		</div>
		
		<!-- In-Line Style Sheet --><!-- 일반 사용자들이 사용 --><!-- 단점 : 재사용 불가 -->
		<div style="background-color: yellow; text-align: center; ">
			본문 내용 입니다.
		</div>
	</body>
	
</html>