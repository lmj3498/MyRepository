<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) --%>
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
	<%-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 --%>
	<script src="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <%-- Bootstrap core CSS --%>
    <link href="${pageContext.servletContext.contextPath}/resources/bootstrap-3.3/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <%-- Custom styles for this template --%>
    <link href="${pageContext.servletContext.contextPath}/resources/css/justified-nav.css" rel="stylesheet"/>
	
	<script type="text/javascript">
		$(function(){
			$("nav li").on("click", function(){
				$("nav li").removeClass("active");
				$(this).addClass("active");
				//this.setAttribute("class","active");

			});
		});
	</script>
  </head>

  <body style='background-image: url("${pageContext.servletContext.contextPath}/resources/image/paper.gif");'>

    <div class="container">


      <div class="masthead">
        <h3 class="text-muted">이명진</h3>
        <nav>
          <ul class="nav nav-justified">
            <li class="active"><a target="iframe" href="${pageContext.servletContext.contextPath}/home">Home</a></li>
            <li><a target="iframe" href="${pageContext.servletContext.contextPath}/member/login">로그인</a></li>
            <li><a target="iframe" href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a></li>
            <li><a target="iframe" href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a></li>
          </ul>
        </nav>
      </div>

      
		<iframe name="iframe" style="width: 100%; height: 600px; border-width: 0px;" src="home">
			
		</iframe>
  
      <div class="row" style="background-color: #292929; color: #ffffff;">
        <div class="col-lg-4">
          <h2>회원 서비스</h2>
          <p class="text-danger">회원 가입</p>
          <p>로그인</p>
          <p>로그 아웃</p>
          <p><a class="btn btn-primary" href="#" role="button">자세한 설명</a></p>
        </div>
        <div class="col-lg-4">
          <h2>자유 게시판</h2>
          <p>게시물 목록</p>
          <p>게시물 쓰기</p>
          <p>게시물 보기</p>
          <p>게시물 삭제</p>
          <p><a class="btn btn-primary" href="#" role="button">자세한 설명</a></p>
       </div>
        <div class="col-lg-4">
          <h2>포토 게시판</h2>
          <p>포토 게시물 목록</p>
          <p>포토 게시물 쓰기</p>
          <p>포토 게시물 보기</p>
          <p>포토 게시물 삭제</p>
          <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>


      <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
      </footer>

    </div>

  </body>
</html>
