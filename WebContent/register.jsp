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
        <title>Create Your Account</title>
    </head>
    <body>
    	<h2>Welcome to Training and Placement Job Portal Site</h2>
		<div class="container">
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form action="registration" method="POST" role="form">
						<div class="form-group">
							<h3>Create account</h3>
						</div>
						<div class="form-group">
							<label class="control-label" for="firstname">First name</label>
							<input id="firstname" name="firstname" type="text" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="lastname">Last name</label>
							<input id="lastname" name="lastname" type="text" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmail">Email</label>
							<input id="signupEmail" name="signupEmail" type="email" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Password</label>
							<input id="signupPassword" name="signupPassword" type="password" maxlength="25" class="form-control" placeholder="at least 6 characters" length="40">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPasswordagain">Password again</label>
							<input id="signupPasswordagain" name="signupPasswordagain" type="password" maxlength="25" class="form-control">
						</div>
						<div class="form-group">
							<input id="signupSubmit" type="submit" name="submit" value="Create your account" class="btn btn-info btn-block">
						</div>
						<p class="form-group">By creating an account, you agree to our <a href="#">Terms of Use</a> and our <a href="#">Privacy Policy</a>.</p>
						<hr>
						<p></p>Already have an account? <a href="#">Sign in</a></p>
					</form>
				</div>
			</div>
		</div>
		</div>
			    
    </body>
</html>