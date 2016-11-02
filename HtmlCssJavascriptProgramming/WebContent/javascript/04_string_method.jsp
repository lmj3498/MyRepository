<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	
	<body>
		String 객체의 메소드
		<hr/>

		<script type="text/javascript">
			var v1 = "abc";
			console.log(v1.length);
			
			var v2 = "JavaScript is easy";
			console.log(v2.indexOf("easy"));
			console.log(v2.indexOf("spring"));
			console.log(v2.search("easy"));
			
			var v3 = "123456-1234567";
			console.log(v3.substring(7,14));
			console.log(v3.substr(7,7));
			console.log(v3.charAt(7));
			
			var v4 = "Apple, Banana, Kiwi";
			var v5 = v4.slice(7,13);
			console.log(v5);
			
			var v6 = "a,b,c,d,e";   // String
			console.log(v6.split(","));// Split on commas
			console.log(v6.split(" "));// Split on spaces
			console.log(v6.split("|"));// Split on pipe
			          
			          
			
		</script>
		
		
	</body>
	
</html>