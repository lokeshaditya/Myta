<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
	<head>
		<title>AddEvent</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
			body{
				background-color:#D9DADC;
				background-image:url("../Occasions/images4.jpg");
				background-repeat:no-repeat;
				background-position: center;
				background-size:cover;
			}
			#reg{
				font-family:"Comic Sans MS", cursive, sans-serif;
				color:red;
				font-size:60px;
			}
			.form-control{
				width:50%;
			}
			.form-group{
				background-color:#C4DEDB;
				border:2px solid gray;
				opacity:0.9;
				padding:4%;
			}
			#img1{	
			}
			h3{
				color:green;
				border:;
				background-color:
			}
		</style>
	</head>
	<body >
	
	<div class="container">
		<div class="row">
		<img alt="email" class="col-sm-6" id="img1" src="../Occasions/582.png " width="400px" height="200px">
		
		<div class="page-header" class="col-sm-6" >
			<h1 id="reg">Welcome</h1>
			
		
		<h3>Never miss any occasion or event from now. Go ahead and fill the form, we'll inform you at the right momement.</h3>
		</div>
		</div>
	</div>
	<div class="container">
		<form action="/Mypractice/RegEvent" method="post" class="form-horizontal">
			<div class="form-group">

				NAME:<input type="text" name="name" class="form-control">
				DESCRIPTION<input type="text" name="description"
					class="form-control"> DATE:<input type="date" name="dated"
					placeholder="mm/dd/yyyy" class="form-control"> E-MAIL:<input
					type="text" readonly name="email" class="form-control"
					value="<%=request.getAttribute("email")%>"> <input
					type="submit" value="confirm" class="btn btn-default" style="margin-left:20%; margin-top:5px;">
			</div>
		</form>
	</div>
	

</body>
</html>
