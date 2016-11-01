<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css"
	href="../common/bootstrap-3.3/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="../common/js/jquery-1.12.4.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script
	src="../common/bootstrap-3.3/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#container {
	display: flex;
	flex-direction: column;
	height: 95vh;
	border: 1px solid gray;
}

#header, #footer {
	padding: 1em;
	color: white;
	background-color: black;
	text-align: center;
}

#content {
	display: flex;
	flex-direction: row;
}
#content #menu{
	background-color: orange;
	padding: 1em;
}
#content #center{
	padding: 1em;
}
ul{
	list-style-type: none;
	padding: 0px;
}
</style>
</head>
</head>
	
	
<body>
	<div id="container">
	<div id="header" class="row">
		<div class="col-md-12"><h1>City Callery</h1></div>
	</div>
	<div id="content" class="row">
		<div id="menu" class="col-xs-12 col-md-3">
			<ul>
					<li><a href="#">London</a></li>
					<li><a href="#">Paris</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
					<li><a href="#">Tokyo</a></li>
			</ul>
		</div>
		<div id="center" class="col-md-9">
			<h1>London</h1>
				<p>London is the capital city of England. It is the most
					populous city in the United Kingdom, with a metropolitan area of
					over 13 million inhabitants.</p>
				<p>Standing on the River Thames, London has been a major
					settlement for two millennia, its history going back to its
					founding by the Romans, who named it Londinium.</p>
		</div>
	</div>
	<div id="footer" class="col-md-12">Copyright @ W3CSchool.com</div>
	</div>
</body>

</html>