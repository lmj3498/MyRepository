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
div {
	border: 1px solid gray;
}
</style>
</head>
</head>

<body>
	Grid System(Layout 작성)
	<hr />
	<div class="row">
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
	</div>
	<div class="row">
		<div class="col-md-8">.col-md-8</div>
		<div class="col-md-4">.col-md-4</div>
	</div>

	<!-- 모바일에서 컬럼들이 하나는 꽉찬너비로, 다른 하나는 절반너비로 쌓이게 합니다 -->
	<div class="row">
		<div class="col-xs-12 col-md-8">.col-xs-12 .col-md-8</div>
		<div class="col-xs-6 col-md-4">.col-xs-6 .col-md-4</div>
	</div>
</body>

</html>