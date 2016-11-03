<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function changeImg1(){
				var img1 = document.querySelector("#img1");
				img1.src = "../common/image/123.jpg";
			}
			
			function changeImg2(){
				var img2 = document.querySelector("#img2");
				img2.src = "../common/image/12345.jpg";
			}
			window.onload = function(){
				var btn2 = document.querySelector("#btn2");
				btn2.onclick = changeImg2;
				
				var btn3 = document.querySelector("#btn3");
				btn3.addEventListener("click",function(){
					var img3 = document.querySelector("#img3");
					img3.src = "../common/image/헤이즈.jpg";
				});
			};
			/* function init(){
				var btn2 = document.querySelector("#btn2");
				btn2.onclick = changeImg2;
			} */
			
			/* window.onload = function(){
				var btn2 = document.getElementById("btn2");
				btn2.onclick = changeImg2;
			}; */
			
			//button.onclick = changeImg2;
			//윈도우 객체에 온로드 이벤트 발생했을 때, 함수를 실행하라 
			/* window.onload = function(){
				console.log("window.onload");
			}; */
			
			/* function fun1(){
				console.log("window.onload");
			} */
			//window.onload = fun1; //window.onload 이벤트 시 fun1 함수를 실행하라 (o)
			//window.onload = fun1();//fun1() 함수 호출(실행) 이후, window.onload에 값을 리턴하라(x)
			
			
		</script>
	</head>
	
	<body><!-- onload="init()" -->
		event 처리
		<hr/>

		<h3>[how1]</h3>
		<button onclick="changeImg1()">버튼1</button><br/>
		<img id="img1" src="" width="400px"/>
		
		<h3>[how2]</h3>
		<button id="btn2">버튼2</button><br/>
		<img id="img2" src="" width="400px"/>
		
		<!-- <script type="text/javascript">
			document.getElementById("#btn2").onclick = changeImg2;
		</script> -->
		
		<h3>[how3]</h3>
		<button id="btn3">버튼3</button><br/>
		<img id="img3" src="" width="400px"/>
	</body>
	
</html>