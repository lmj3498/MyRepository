<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.mycompany.myapp.exam07.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	
	<body>
		데이터 찾기
		<hr/>
		[HttpServletRequest 를 이용해서 찾기] <br/>
		데이터1: <%=(String)request.getAttribute("data1") %> <br/>	
		데이터2: <%=(String)request.getAttribute("data2") %> <br/>	 <br/>	
		
		[HttpSession 를 이용해서 찾기] <br/>
		데이터1: <%=(String)session.getAttribute("data1") %> <br/>	
		데이터2: <%=(String)session.getAttribute("data2") %> <br/>	 <br/>	
		
		[EL를 이용해서 찾기] <br/>
		데이터1: ${data1} <br/>	
		데이터2: ${data2} <br/> <br/>	
		
		
		[객체의 속성(필드) 값 얻기]<br/> <br/>	
		<!-- JSP 용 --> 
		<%Board board = (Board) request.getAttribute("board");%>
		<%if(board != null) {%>
			번호:<%=board.getBno() %> <br/>
			제목:<%=board.getTitle() %> <br/>
			내용:<%=board.getContent() %> <br/>
			조회수:<%=board.getHitcount() %> <br/> <br/>
		<%}%>
		<!-- MVC , 스프링 용 -->
		<%-- 번호:${board.bno} <br/>
		제목:${board.title} <br/>
		내용:${board.content} <br/>
		조회수:${board.hitcount} <br/> <br/> --%>
		
		[컬렉션 이용하기]<br/>
		
		<table style="border-collapse: collapse; border: 1px solid black; width: 600px">
			<tr style="background-color: #00D8FF">
				<th style="border: 1px solid black;">번호</th>
				<th style="border: 1px solid black;">제목</th>
				<th style="border: 1px solid black;">내용</th>
				<th style="border: 1px solid black;">조회수</th>
			</tr>
			
			<%-- <%List<Board> list = (List<Board>) request.getAttribute("boardlist"); %>
			<%if(list != null){%>
				<%for(Board b : list) {%>
				<tr>
					<td style="border: 1px solid black"><%=b.getBno() %></td>
					<td style="border: 1px solid black"><%=b.getTitle() %></td>
					<td style="border: 1px solid black"><%=b.getContent() %></td>
					<td style="border: 1px solid black"><%=b.getHitcount() %></td>
				</tr>
			   <%}%>
			<%}%> --%>
			<c:forEach var="b" items="${boardlist}">
				<tr>
					<td style="border: 1px solid black">${b.bno }</td>
					<td style="border: 1px solid black">${b.title }</td>
					<td style="border: 1px solid black">${b.content }</td>
					<td style="border: 1px solid black">${b.hitcount }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
	
</html>