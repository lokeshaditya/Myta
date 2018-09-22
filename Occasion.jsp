<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Occasions</title>
		
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<style>
			body{
				background-color:#FFF8DC;
			}
			#reg{
	
				font-family:"Comic Sans MS", cursive, sans-serif;
				color:yellow;
				font-size:20px;
			}
			
		</style>
		<script>
			var countDownDate = new Date("Feb 12, 2019").getTime();
		
			// Update the count down every 1 second
			var x = setInterval(function() {
		
				// Get todays date and time
				var now = new Date().getTime();
		
				// Find the distance between now and the count down date
				var distance = countDownDate - now;
		
				// Time calculations for days, hours, minutes and seconds
				var days = Math.floor(distance / (1000 * 60 * 60 * 24));
				var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
						/ (1000 * 60 * 60));
				var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
				var seconds = Math.floor((distance % (1000 * 60)) / 1000);
		
				// Output the result in an element with id="demo"
				document.getElementById("timer").innerHTML = days + "d " + hours + "h "
						+ minutes + "m " + seconds + "s ";
		
				// If the count down is over, write some text 
				if (distance < 0) {
					clearInterval(x);
					document.getElementById("timer").innerHTML = "EXPIRED";
				}
			}, 1000);
		</script>
	</head>
	
	<body id="body" >
		<table class="table">
			<thead>
				<tr>
					
					<th width=25% height=100px></th>
					
					<th width=50% height=100px><div class="text-center" style="">
						<h1 style="color:#e6005c;">Time to next occasion is:</h1>
						<h2><p id="timer"></p></h2>
					</div></th>	
					
					<th width=15% height=100px><button title="Logout" class="glyphicon glyphicon-log-out btn btn-link" ;
					href="/Mypractice/servlethtml/Enterance.html" style=" text-align:right; padding:20% 0; font-size:30px; "></button></th>
				</tr>
			</thead>
		</table>
		<%
			response.setContentType("text/html");
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
				PreparedStatement ps = con.prepareStatement("select * from occasion where email = ?");
				ps.setString(1, (String) request.getAttribute("email"));
				ResultSet rs = ps.executeQuery();
		%>
	
		<div class="container">
			
			<table class="table table-responsive table-hover" style="">
				<thead>
					<tr>
						<th id="reg" class="text-center text-uppercase" style="background-color:#DEB887;">NAME</th>
						<th id="reg" class="text-center text-uppercase" style="background-color:#DEB887;">DESCRIPTION</th>
						<th id="reg" class="text-center text-uppercase" style="background-color:#DEB887;">DATED</th>
						<th style="background-color:#DEB887;"></th>
					</tr>
				</thead>
				<%
					while (rs.next()) {
				%>
				<tbody>
				<tr>
					<td class="text-center">
						<%
							out.print(rs.getString("name"));
						%>
					</td>
					<td class="text-center ">
						<%
							out.print(rs.getString("description"));
						%>
					</td>
					<td class="text-center">
						<%
							out.print(rs.getDate("dated"));
						%>
					</td>
					<td><input type="button" name="delete" value="Delete" 
					style="background-color: #FFB286; border-color:#D6A64F;" 
					class = "btn center-block btn-sm "></td>
						
				</tr>
				<%
					}
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
				</tbody>
			</table>
			
		</div>
		<form action="servlethtml/AddEvent.jsp" class="text-center">
			<input type="submit" value="+" title="Add an Occasion" class="btn btn-round-lg btn-lg "
			style="border-radius: 50px;  position: fixed; bottom: 3%; border:2px solid #0199CB; 
			color:black; font-size:25px; background-color:#0BB5FF;" >
		</form>
		<div title="Write2Us" style="position:fixed; bottom:3%; left:3%; font-size:40px; "><i class="glyphicon glyphicon-envelope"></i></div>
		<div title="About This Site" style="position:fixed; bottom:3%; right:3%; font-size:40px; "><i class="glyphicon glyphicon-list-alt"></i></div>
	</body>
</html>