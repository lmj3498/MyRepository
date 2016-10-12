<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	
	<body>
		게시물 목록
		<hr/>
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px">
			<tr style="background-color: #00D8FF">
				<th style="border: 1px solid black;">글쓴이</th>
				<th style="border: 1px solid black;">제목</th>
				<th style="border: 1px solid black;">내용</th>
				
			</tr>
			
			
			<c:forEach var="board" items="${boardlist}">
				<tr>
					<td style="border: 1px solid black">${board.bwriter }</td>
					<td style="border: 1px solid black">${board.btitle }</td>
					<td style="border: 1px solid black">${board.bcontent }</td>
					
				</tr>
			</c:forEach>
		</table>
	</body>
	
</html>