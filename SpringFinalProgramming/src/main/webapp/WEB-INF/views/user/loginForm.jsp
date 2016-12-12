<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%--2016-11-18(금)--%>

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

			<input type="text" name="user_id" placeholder="아이디" value="${findUser_id}"><br/>

			

			<input type="password" name="user_pw" placeholder="비밀번호"><br/>
			
			<c:choose>
				<c:when test="${error == 'LOGIN_FAIL_USER_ID'}">아이디가 존재하지 않습니다.</c:when>
				<c:when test="${error == 'LOGIN_FAIL_USER_PW'}">패스워드가 틀립니다.</c:when>
			</c:choose>
			<%-- 
			<c:if test="${error == 'LOGIN_FAIL_USER_ID'}">아이디가 존재하지 않습니다.</c:if>

			<c:if test="${error == 'LOGIN_FAIL_USER_PW'}">패스워드가 틀립니다.</c:if><br/>

			 --%>

			<input type="submit" value="로그인"/>

		</form>

		

		<a href ="${pageContext.servletContext.contextPath}/user/join">회원 가입</a><br/><%--상대경로 --%>

		<a href ="findUser_id">아이디 찾기</a><br/>											<%--절대경로 --%>

		<a href ="findUser_pw">비밀번호 찾기</a><br/>

	</body>

</html>