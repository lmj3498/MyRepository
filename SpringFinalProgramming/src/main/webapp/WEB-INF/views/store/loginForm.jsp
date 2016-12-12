<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--2016-11-16(수)--%>
<%-- 보나 20161122 STORE ID/PW 관련 수정 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript"
				src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript"
				src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/js/bootstrap.min.js"></script>
		<link
			href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/css/bootstrap.min.css"
			rel="stylesheet" />
		<link
			href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css"
			rel="stylesheet" />
	</head>
	<body>
		로그인
		<hr/>
		<form method="post"><%--action=~ 이 없으면 현재 넘어간 요청경로로 다시 이동하다.--%>
			아이디: <input type="text" name="sid" value="${findSid}"><br/>
			<c:if test="${error == 'LOGIN_FAIL_USER_ID'}">*아이디가 존재하지 않습니다.</c:if>
			패스워드: <input type="password" name="spw" value="${findSpw}"><br/>
			<c:if test="${error == 'LOGIN_FAIL_USER_PW'}">*패스워드가 틀립니다.</c:if>
			<br/>
			<input type="submit" value="로그인"/>
		</form>
		
		<a href ="${pageContext.servletContext.contextPath}/user/join">회원 가입</a><br/><%--상대경로 --%>
		<a href ="findSid">아이디 찾기</a><br/>											<%--절대경로 --%>
		<a href ="findSpw">비밀번호 찾기</a><br/>
	</body>
</html>