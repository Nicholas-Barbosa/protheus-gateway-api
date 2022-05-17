<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gateway API OAuth Server - Login</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Gateway API OAuth Server - Login</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">

<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="./resources/css/style.css">


</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-2"></div>
			<div class="col-lg-6 col-md-8 login-box">
				<div class="col-lg-12 login-key">
					<i class="fa fa-key" aria-hidden="true"></i>
				</div>
				<div class="col-lg-12 login-title">Gateway OAuth Server</div>

				<div class="col-lg-12 login-form">
					<div class="col-lg-12 login-form">
						<form action="auth" method="post" >
							<div class="form-group">
								<label class="form-control-label">USERNAME</label> <input
									id="username" name="username" type="text" class="form-control">
							</div>
							<div class="form-group">
								<label class="form-control-label">PASSWORD</label> <input
									id="password" name="password" type="password"
									class="form-control">
							</div>
							<div class="form-group">
								<label class="form-control-label" for="envs">Ambiente</label> <select
									class="form-control" name="envs" id="envs">
									<option value="CDG">CDG</option>
									<option value="GAUSS">GAUSS</option>
									<option value="NSG">NSG</option>
									<option value="SPG">SPG</option>
								</select>
							</div>
							<input id="redirectUri" name="redirectUri" type="hidden"
								class="form-control">

							<div class="col-lg-12 loginbttm">
								<div class="col-lg-6 login-btm login-text">
									<!-- Error Message -->
								</div>
								<div class="col-lg-6 login-btm login-button">
									<button type="submit" class="btn btn-outline-primary"
										onclick="">LOGIN</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		let queryParams = new URLSearchParams(window.location.search);
		document.getElementById("redirectUri").value = queryParams.get("redirect_uri");
	</script>
</body>
</html>