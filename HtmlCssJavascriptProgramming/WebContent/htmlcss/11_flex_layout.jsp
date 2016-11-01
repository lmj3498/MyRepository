<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#container {
	display: flex;
	flex-direction: column;
	width: 100%;
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
	flex:1;
	display: flex;
	flex-direction: row;
}
#content #menu{
	background-color: orange;
	width: 150px;
	padding: 1em;
}
#content #center{
	flex:1;
	padding: 1em;
}
ul{
	list-style-type: none;
	padding: 0px;
}
</style>
</head>

<body>
	<div id="container">
		<div id="header">
			<h1>City Callery</h1>
		</div>
		<div id="content">
			<div id="menu">
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
			<div id="center">
				<h1>London</h1>
				<p>London is the capital city of England. It is the most
					populous city in the United Kingdom, with a metropolitan area of
					over 13 million inhabitants.</p>
				<p>Standing on the River Thames, London has been a major
					settlement for two millennia, its history going back to its
					founding by the Romans, who named it Londinium.</p>
			</div>

		</div>
		<div id="footer">Copyright @ W3CSchool.com</div>

	</div>

</body>

</html>