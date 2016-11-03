<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			//BOM - load 이벤트
			window.onload = function(){
				console.log("0");
			};
			
			//DOM - ready 이벤트
			$(document).on("ready", function(){
				console.log("1");
			});
			$(document).ready(function(){
				console.log("2");
			});
			$(function(){
				console.log("3");
			});
		</script>
	</head>
	
	<body>
		ready 이벤트 처리
		<hr/>
		
		
	</body>
	
</html>