<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style type="text/css">
		a{
			text-decoration: none;
			color: black;
		}
		a:HOVER {
			color: green;
		}
	</style>
</head>

<body>
	포토 게시판
	<hr />
	
	<c:if test="${login!=null }">
	<a href="write">[글쓰기]</a>
	</c:if>
	
	
	<table style="width: 600px;">
		<tr>
			<td>
			<c:forEach begin="1" end="8">
				<div style="width:120px; height:130px; margin:5px; display: inline-block;">
					<div style="background-image: url(../resources/image/photo2.jpg); height: 100px;"></div>
					<div>
						<table style="width:100%; height: 30px; background-color: black;">
							<tr>
								<td style="text-align: left; color: white;">할슈타트</td>
								<td style="text-align: right; color: aqua;">10</td>
								
							</tr>
						</table>
					</div>
				</div>
			</c:forEach>	
			</td>
		</tr>
	</table>
	
	<!-- <a href="#" >1&nbsp;</a>
	<a href="#" >2&nbsp;</a>
	<a href="#" style="color:red">3&nbsp;</a>
	<a href="#" >4&nbsp;</a>
	<a href="#" >5&nbsp;</a> -->
	
	<div style="width: 600px">
	<a href="list?pageNo=1">[처음]</a>
	<c:if test="${groupNo>1 }">
	<a href="list?pageNo=${startPageNo-1 }">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${startPageNo}" end="${endPageNo }">
	 <a href="list?pageNo=${i}" 
	 	<c:if test="${pageNo==i }">style="color:red"</c:if>
	 >${i}</a>
	</c:forEach>
	 
	<c:if test="${groupNo<totalGroupNo }">
	<a href="list?pageNo=${endPageNo+1 }">[다음]</a>
	</c:if>
	<a href="list?pageNo=${totalPageNo }">[맨끝]</a>
	</div>
</body>

</html>