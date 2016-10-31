<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			/* *{color: red;} *//* 글자 색상 */
			
			div{background-color: yellow;}
			#div2{background-color: green;}/* id가 div2인 것에 대한 css 적용 */
			.div3{background-color: blue;}/* class가 div3인 그룹에 대한 css 적용 */
			
			#div4,#p1,#h1{background-color: orange;}
			#div5 p{background-color: green;}
			#div6 > p{background-color: fuchsia;}
			
			[checked]{background-color: lime;}
			[selected=true]{color:maroon;}
			
			a{color:black; text-decoration: none;}
			a:active{color:red;}
			a:link{color: blue;}
			a:hover{color:lime; text-decoration: underline;}
			/* a:visited {color: orange;} */
			#form1 [checked]{background-color: green;}
		</style>
	</head>
	
	<body>
		CSS 선택자
		<hr/>
		
		<div>A</div>
		<div id="div2" class="div3">B</div><!-- id : 다른 태그와 식별할 수 있도록 --><!-- 우선순위 :  id > class > 태그 -->
		<div class="div3">C</div>
		<div class="div3">D</div><!-- class : 태그 그룹 이름 -->
		<br/>
		<div id="div4">E</div>
		<p id = "p1">F</p>
		<h3 id="h1">G</h3>
		<br/>
		<div id="div5">
			<p>A</p>
			<p>A</p>
			
		</div>	
		<div id="div6">
			<div><p>A</p></div>
			<p>A</p>
		</div>
		<div>
			<div checked="true">A</div>
			<div checked="false">B</div>
			
			<div selected="false">C</div>
			<div selected="true">D</div>
			<div selected="true">E</div>
		</div>
		<form id="form1">
			<div checked="true">A</div>
			<div checked="false">B</div>
		</form>
		<div style="background-color: white;">
			<a href="http://www.naver.com">네이버</a><br/>
			<a href="http://tomcat.apache.org">톰캣</a><br/>
			<a href="http://www.w3c.org">w3c</a><br/>
		</div>
		
		
	</body>
	
</html>