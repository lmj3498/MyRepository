<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<script type="text/javascript">
		function checkLoginForm(){
			//console.log("확인");
			
			var mid = document.getElementById("mid").value;
			var mpassword = document.querySelector("#mpassword").value;
			if(mid == ""||mpassword==""){
				alert("아이디 또는 패스워드가 입력되지 않았습니다.");
				return false;
			}else if(mid.length<4 || mid.length>10){
				alert("아이디의 길이가 맞지 않습니다.");
				return false;
			}else if(mpassword.length<4 || mpassword.lenth>10){
				alert("비밀번호의 길이가 맞지 않습니다.");
				return false;
			}
			return true;
		}
		
	</script>
	<body>
		유효성 검사(입력값 검사)
		<hr/>

		<form id="loginForm" onsubmit="return checkLoginForm()">
			아이디 : <input id="mid" type="text" name="mid"/><br/>
			비밀번호 : <input id="mpassword" type="password" name="mpassword"/><br/>
			<input type="submit" value="로그인"/>
		</form>
		
		
	</body>
	
</html>