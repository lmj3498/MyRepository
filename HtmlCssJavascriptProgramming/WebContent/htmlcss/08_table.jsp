<!DOCTYPE html>
<html>
<head>
<style>
#table1 {
    border-collapse: collapse;
    width: 100%;
}

#table1 th, #table1 td {
    text-align: center;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

#table1 th {
    background-color: #4CAF50;
    color: white;
}

#table1 tr:nth-child(even){
	background-color: #a2a2a2;
}
</style>
</head>
<body>
	table 관련 CSS 속성
		<hr/>
	
<h2>Colored Table Header</h2>

<table id="table1">
  <tr>
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Savings</th>
  </tr>
  <tr>
    <td>Peter</td>
    <td>Griffin</td>
    <td>$100</td>
  </tr>
  <tr>
    <td>Lois</td>
    <td>Griffin</td>
    <td>$150</td>
  </tr>
  <tr>
    <td>Joe</td>
    <td>Swanson</td>
    <td>$300</td>
  </tr>
  <tr>
    <td>Cleveland</td>
    <td>Brown</td>
    <td>$250</td>
</tr>
</table>

</body>
</html>

