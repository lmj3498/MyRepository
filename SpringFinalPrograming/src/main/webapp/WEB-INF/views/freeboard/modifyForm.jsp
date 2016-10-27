<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	
	<body>
		글수정
		<form method="post">
		<input type="hidden" name="bno" value="${freeBoard.bno }">
		<table>
		<tr>
			<td style="background-color: orange; width: 70px;">제목</td> 
			<td><input type="text" name="btitle" style="width:600px;" value="${freeboard.btitle}"></td>
		</tr>
		<tr>
			<td style="background-color: orange; width: 70px;">내용</td> 
			<td><textarea name="bcontent" style="width:600px; height:500px;">${freeboard.bcontent}</textarea></td>
		</tr>		
		</table>
		<input type="submit" value="글수정">
		</form>
	</body>
	
</html>