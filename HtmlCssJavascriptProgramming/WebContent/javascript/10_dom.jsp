<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function onClickButton1(){
				console.log("onClickButton1() 실행");
				//var div1 = document.getElementById("div1");
				var div1 = document.querySelector("#div1");
				console.log(div1);
				div1.innerHTML = "수정 내용";
			}
			
			var flag = false;
			function onClickButton2(){
				
				if(flag==false){
					console.log("onClickButton2() 실행");
					//var photo1 = document.getElementsByClassName("photo");
					var photo1 = document.querySelectorAll(".photo");
					console.log(photo1[0]);
					photo1[0].src = "../common/image/헤이즈.jpg";
					flag = true;
				}else if(flag==true){
					console.log("onClickButton2() 실행");
					var photo1 = document.getElementsByClassName("photo");
					console.log(photo1[0]);
					photo1[0].src = "../common/image/paper.gif";
					flag = false;
					
				}
			}
			function onClickButton3(){
				var mid;
				var mpassword;
				
				//how1
				//입력된 mid와 mpassword 얻기
				//1차 유효성 검사하기 위해서
				mid = document.querySelector("#form1 [name=mid]").value;
				mpassword = document.querySelector("#form1 [name=mpassword]").value;
				console.log(mid);
				console.log(mpassword);
				
				//유효성 검사
				if(mid == ""){
					alert("아이디를 입력하세요");
				}else if(mpassword == ""){
					 alert("비밀번호를 입력하세요"); 
				}else{
					document.querySelector("#form1").submit();
				}
				
				//how2
				//비추
				//form에 name ="form1" 주어져야 함
				//mid = document.form1.mid.value;
				//mpassword = document.form1.mpassword.value;
				//console.log(mid.value);
				//console.log(mpassword);
				
				//how3
				//id 이용
				//mid = document.querySelector("#mid");
				//mpassword = document.querySelector("#mpassword").value;
				//console.log(mid.value);
				//console.log(mpassword);
			}
			/* function onClickButton2(){
			console.log("onClickButton2() 실행");
			var img1 = document.getElementById("img1");
			console.log(img1);
			img1.src = "../common/image/헤이즈.jpg";
			} */
			
			/* function onClickButton2(){
			console.log("onClickButton2() 실행");
			var img1 = document.getElementsByTagName("img");
			console.log(img1[0]);
			img1[0].src = "../common/image/헤이즈.jpg";
			} */
		</script>
	</head>
	
	<body>
		DOM 사용
		<hr/>

		
		<button onclick="onClickButton1()">버튼 1</button>
		<div id="div1">최초 내용</div>
		<button onclick="onClickButton2()">버튼 2</button>
		<div>
			<img id="img1" class="photo" src="../common/image/paper.gif" width="200px"/>
		</div>
		<button onclick="onClickButton3()">버튼 3</button>
		<div>
			<form id="form1">
				아이디 : <input id="mid" type="text" name="mid"/><br/>
				비밀번호 : <input id="mpassword" type="password" name="mpassword"/><br/>
				
			</form>
		</div>
	</body>
	
</html>