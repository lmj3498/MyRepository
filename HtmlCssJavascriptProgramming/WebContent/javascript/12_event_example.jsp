<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">	
		<script type="text/javascript">
			window.onload = function(){
				var input1 = document.querySelector("[name=mid]");
				input1.addEventListener("keypress",function(){
					input1.value = input1.value.toUpperCase();	
				});
				input1.addEventListener("change",function(){
					input1.value = input1.value.toUpperCase();
				});
			};
			
			function chageImg1(){
				var img1 = document.querySelector("#img1");
				img1.src = "../common/image/123.jpg";
			};
			function chageImg2(){
				var img1 = document.querySelector("#img1");
				img1.src = "../common/image/헤이즈.jpg";
			};
			
			//event.type 중요
			function chageImg(img){
				if(event.type=="mouseover"){
					img.src = "../common/image/123.jpg";
				}else if(event.type=="mouseout"){
					img.src = "../common/image/헤이즈.jpg";
				}
				
			};
			function chageImg2(){
				var img = event.target;
				if(event.type=="mouseover"){
					img.src = "../common/image/123.jpg";
				}else if(event.type=="mouseout"){
					img.src = "../common/image/헤이즈.jpg";
				}
				
			};
			
			/* window.addEventListener("load",function(){
				var img4 = document.querySelector("#img4");
				
				img4.addEventListener("mouseover",chageImg2);
				img4.addEventListener("mouseout",chageImg2);
				
				
			}); */
			
			/* function checkMid(){
				var input1 = document.querySelector("[name=mid]");
				input1.value = input1.value.toUpperCase();
			} */
			
			window.onload = function(){
				var img2 = document.querySelector("#img2");
				img2.addEventListener("mouseover",function(){
					img2.src = "../common/image/123.jpg";	
				});
				img2.addEventListener("mouseout",function(){
					img2.src = "../common/image/헤이즈.jpg";
				});
			};
			
			function changeColor(){
				var div1 = document.querySelector("#div1");
				div1.addEventListener("mouseover",function(){
					div1.style.backgroundColor = "blue";
				});
				div1.addEventListener("mouseout",function(){
					div1.style.backgroundColor = "red";
				});
			};
		</script>
	</head>
	
	<body>
		다양한 Event 처리
		<hr/>
		<h3>[Exam1]</h3>
		<form>
			<!-- <input type="text" name="mid" onkeypress="checkMid()" onchange="checkMid()"/> -->
			<input type="text" name="mid" />
		</form><br/>
		
		<h3>[Exam2]</h3>
		<img id="img1" src="../common/image/헤이즈.jpg" width="400" onmouseover="chageImg1()" onmouseout="chageImg2()"/>
		<br/><br/>
		<img id="img2" src="../common/image/헤이즈.jpg" width="400"/>
		<br/><br/>
		<img id="img3" src="../common/image/헤이즈.jpg" width="400" onmouseover="chageImg(this)" onmouseout="chageImg(this)"/>
		<br/><br/>
		
		<h3>[Exam3]</h3>
		<div id="div1" style="width: 200px; height: 200px; background-color: red;" onmouseover="changeColor()" onmouseout="changeColor()" ></div>
		
		
		
	</body>
	
</html>