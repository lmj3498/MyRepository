<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- <script src="http://code.jquery.com/jquery-migrate-3.0.0.min.js"
		integrity="sha256-JklDYODbg0X+8sPiKkcFURb5z7RvlNMIaE3RA2z97vw="
		crossorigin="anonymous">
	</script> -->
	<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		//함수 (객체) 대입
		var $ = function(selector){
			console.log("aaa");
			return document.querySelectorAll(selector);
		};
		
		//동적 메소드 추가
		$.ajax = function(){
				console.log("bbb");
		};
		function test(){
			$("#div1")[0].innerHTML = "수정 내용";
			$.ajax();
		}
	</script>
	</head>

<body>
	$는 함수형 객체
	<hr />
	<button onclick="test()">버튼</button>
	<div id="div1">최초 내용</div>
	<script type="text/javascript">
		
	</script>
</body>

</html>