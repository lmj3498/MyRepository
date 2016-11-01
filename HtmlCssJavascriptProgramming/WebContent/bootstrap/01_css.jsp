<%@ page contentType="text/html;charset=UTF-8"%>

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
</head>

<body>
	Bootstrap
	<hr />
	[버튼]
	<br />
	<!-- Standard button -->
	<button type="button" class="btn btn-default">Default</button>

	<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
	<button type="button" class="btn btn-primary">Primary</button>

	<!-- Indicates a successful or positive action -->
	<button type="button" class="btn btn-success">Success</button>

	<!-- Contextual button for informational alert messages -->
	<button type="button" class="btn btn-info">Info</button>

	<!-- Indicates caution should be taken with this action -->
	<button type="button" class="btn btn-warning">Warning</button>

	<!-- Indicates a dangerous or potentially negative action -->
	<button type="button" class="btn btn-danger">Danger</button>

	<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
	<button type="button" class="btn btn-link">Link</button>

	<br />
	<br /> [테이블]
	<br />
	<table class="table table-bordered">
		<tr class="success">
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
		</tr>
		<tr class="warning">
			<td>번호1</td>
			<td>제목1</td>
			<td>글쓴이1</td>
		</tr>
		<tr class="danger">
			<td>번호2</td>
			<td>제목2</td>
			<td>글쓴이2</td>
		</tr>
		<tr class="info">
			<td>번호3</td>
			<td>제목3</td>
			<td>글쓴이3</td>
		</tr>
	</table>
	<br />
	<br /> [이미지]
	<br />
	<img src="../common/image/헤이즈.jpg" class="img-rounded" width="100px"
		height="100px">
	<img src="../common/image/헤이즈.jpg" class="img-circle" width="100px"
		height="100px">
	<img src="../common/image/헤이즈.jpg" class="img-thumbnail" width="100px"
		height="100px">


	<br />
	<br /> [아이콘]
	<br />
	<span class="glyphicon glyphicon-align-left" aria-hidden="true">헤이즈</span>


	<br />
	<br /> [분할 된 버튼]
	<br />
	<!-- Split button -->
	<div class="btn-group">
		<button type="button" class="btn btn-danger">Action</button>
		<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			<span class="caret"></span> <span class="sr-only">Toggle Dropdown</span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">Action</a></li>
			<li><a href="#">Another action</a></li>
			<li><a href="#">Something else here</a></li>
			<li class="divider"></li>
			<li><a href="#">Separated link</a></li>
		</ul>
	</div>
</body>

</html>