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
	
		/* window.onload = function(){
			var btn1 = document.querySelector("#btn1");
			btn1.addEventListener("click", function(){
				var div1 = document.querySelector("#div1");
				div1.innerHTML = "수정 내용";
			});
		}; */
		$(function(){
			$("#btn1").on("click", function(){
				$("#div1").html("수정 내용");
			});
		});
		
	</script>
	</head>

<body>
	jQuery 라이브러리 로드
	<hr />
	
	<button id="btn1">버튼1</button>
	<div id="div1">최초 내용</div>
	
</body>

</html>