<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
<!-- Design by foolishdeveloper.com -->
<title>Gateway API - OAuth Server Login</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./resources/css/login.css">
</head>
<body>
	<div class="background">
		<div class="shape"></div>
		<div class="shape"></div>
	</div>
	<form action="auth" method="post">
		<h3>Login Here</h3>

		<label for="username">Username</label> <input type="text"
			placeholder="USERNAME" id="username" name="username"> <label
			for="password">Password</label> <input type="password"
			placeholder="Password" id="password" name="password"> <br>
		<div class="select">
			<select name="envs" id="envs">
				<option value="CDG">CDG</option>
				<option value="GAUSS">GAUSS</option>
				<option value="NSG">NSG</option>
				<option value="SPG">SPG</option>
			</select>
		</div>
		<div>
			<input id="redirectUri" name="redirectUri" type="hidden"
				class="form-control">
		</div>
		<button>Log In</button>
	</form>

	<script type="text/javascript">
		let queryParams = new URLSearchParams(window.location.search);
		document.getElementById("redirectUri").value = queryParams
				.get("redirect_uri");
	</script>
</body>
</html>