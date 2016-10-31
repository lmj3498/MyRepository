<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	
	<body>
		아이디 찾기
		<hr/>
		<form method="post"><!-- action지정 안하면 똑같은 경로로 재 요청 됨 단,method에 따라-->
		이메일 : <input type="email" name="memail"/>${error}<br/>
			<input type="submit" value="찾기">
		</form>
	</body>
	
</html>