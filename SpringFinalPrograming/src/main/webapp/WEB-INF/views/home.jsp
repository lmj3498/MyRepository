<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<%-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) --%>
		<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
		<%-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 --%>
		<script src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    	<%-- Bootstrap core CSS --%>
    	<link href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
    	<%-- Custom styles for this template --%>
    	<link href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css" rel="stylesheet"/>
	</head>
	
	<body>
		<div class="jumbotron">
        <h1>Spring Final Programming</h1>
        <p class="lead">Java, SQL, JDBC, HTML5, CSS3, JavaScript, jQuery, AJAX, JSP, Spring</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">많이 배웠네...</a></p>
      </div>
		<%-- 1. 
		<c:if test="${login == null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/login">로그인</a><br/><!-- 표현 식 -->
		</c:if>
		<c:if test="${login != null}">
			<a href="<%=pageContext.getServletContext().getContextPath()%>/member/logout">로그아웃</a><br/><!-- 표현 식 -->
		</c:if>
		
		<c:if test="${login != null}">
		2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a><br/><!-- 표현 언어 -->
		3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
		</c:if>
		 --%>
		
	</body>
	
</html>