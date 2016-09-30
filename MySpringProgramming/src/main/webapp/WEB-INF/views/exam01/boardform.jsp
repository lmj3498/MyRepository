<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
		
	<body>
		<hr/>
		[게시판 폼]<br/>
		<form method="post" action="/mytest/exam01/board">
		
			번      호 : <input type="text" name="bno" value="1"/> <br/>
			제      목 : <input type="text" name="btitle" value="재밌는Spring"/> <br/>
			내      용 : <input type="text" name="bcontent" value="어쩌구저쩌구" size="40" /> <br/>
			글  쓴 이 : <input type="text" name="bwriter" value="이명진"/> <br/>
			조  회 수 : <input type="text" name="bhitcount" value="0"/> <br/>
			
			종      류 : <input type="radio" name="bcharater" value="소    설"/>소설
					<input type="radio" name="bcharater" value="수    필" checked/>수필
					<input type="radio" name="bcharater" value="기    타"/>기타 <br/>
			
			게시분야 : <input type="checkbox" name="bfield" value="meth" checked/>수학
			       <input type="checkbox" name="bfield" value="computer" checked/>컴퓨터
			       <input type="checkbox" name="bfield" value="bigdata"/>빅데이터
			       <input type="checkbox" name="bfield" value="iot"/>IoT <br/>
			
			 게  시 일 : <input type="date" name="bday" value="2016-09-29">
					
					<br/>
				<%-- <input type="submit" value="가입">
				<button>가입</button> --%>
				<input type="image" src="/mytest/resources/image/123.jpg" width="100">
		</form>
	</body>
	
</html>