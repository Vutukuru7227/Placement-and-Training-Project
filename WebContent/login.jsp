<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/register.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <title>Login to Your Account</title>
    </head>
    <body>
    	<h2>Login to Training and Placement Job Portal Site</h2>
    	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form method="POST" action="Login" role="form">
						<div class="form-group">
							<h3>Sign in</h3>
						</div>
						<div class="form-group">
							<strong>Email</strong>
							<input id="signinEmail" name="signinEmail" type="email" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<strong>Password</strong>
							<span class="right"><a href="#">Forgot your password?</a></span>
							<input id="signinPassword" name="signinPassword" type="password" maxlength="25" class="form-control">
						</div>
						<div class="form-group" style="padding-top: 12px;">
							<button id="signinSubmit" type="submit" class="btn btn-success btn-block">Sign in</button>
						</div>
						<div class="form-group divider">
							<hr class="left"><small>New to site?</small><hr class="right">
						</div>
						<p class="form-group"><a href="#" class="btn btn-info btn-block">Create an account</a></p>
						<p class="form-group">By signing in you are agreeing to our <a href="#">Terms of Use</a> and our <a href="#">Privacy Policy</a>.</p>
					</form>
				</div>
			</div>
		</div>
		</div>

</body>
</html>