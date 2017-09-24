<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Training and Placement Job Portal</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE = edge">
    <meta name="viewport" content="width = device-width, initial-scale = 1">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <style type="text/css">
        .navbar{
            border-radius: 0;
            margin-bottom: 0px;
        }
        body{
            background-color: lightgrey;
        }
        .jumbotron-primary{
          margin-top: 30px;
          background-color:#3498db;
          background-image: url("https://i.imgur.com/2o6cukD.png"),
        linear-gradient(165deg,
        rgba(255, 255, 255, 0),
        rgba(255, 255, 255, 0) 65%, rgba(38, 38, 38, 0.1) 65.1%,
        rgba(38, 38, 38, 0.1));
                color:#ffffff;
            }
          #register_form{
            margin: 0px 10px;
            color: black;
            margin-top: 0px;
          }
        
        .bottom_ul { list-style-type:none; float:right; margin-bottom:0px;}
        .bottom_ul li { float:left; line-height:40px;}
        .bottom_ul li:after { content:"/"; color:#FFF; margin-right:8px; margin-left:8px;}
        .bottom_ul li a { color:#FFF;  font-size:12px;}
    </style>
    <script type="text/javascript">
    function match_password(){  
    	var firstpassword = document.register_form.signupPassword.value;  
    	var secondpassword = document.register_form.signupPasswordagain.value;  
    	  
    	if(firstpassword == secondpassword){  
    	return true;  
    	}  
    	else{  
    	alert("Passwords must be same!");  
    	return false;  
    	}  
    	}  
    </script>
    <link href="https://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#" style="color: white">SYNTHESIZE</a>
    </div>

                <form class="navbar-form navbar-right" method="POST" action="Login">
                    <div class="form-group">
                        <input type="email" class="form-control" id="signinEmail" name="signinEmail" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="signinPassword" name="signinPassword" placeholder="Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign In</button>
                    <a href="#" style="color: white;">Forgot Password?</a>
                </form>
    
  </div><!-- /.container-fluid -->
</nav>

<div class="jumbotron jumbotron-primary">
<div class="container" style="max-width: 360px;">
<div class="panel panel-primary">
        <div class="panel-body">
          <form id="register_form" name="register_form" action="Registration" method="POST" role="form" onsubmit="return match_password()">
            <div class="form-group">
              <h3 style="text-align: center;">Create your account</h3>
            </div>
            <div class="form-group">
              <label class="control-label" for="firstname">First name</label>
              <input id="firstname" name="firstname" type="text" pattern="[A-Za-z]{1,32}" title="Ex:- Peter" maxlength="50" class="form-control" required>
            </div>
            <div class="form-group">
              <label class="control-label" for="lastname">Last name</label>
              <input id="lastname" name="lastname" type="text" pattern="[A-Za-z]{1,32}" title="Ex:- Parker" maxlength="50" class="form-control" required>
            </div>
            <div class="form-group">
              <label class="control-label" for="signupEmail">Email</label>
              <input id="signupEmail" name="signupEmail" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" maxlength="50" title="Ex:- xyz@example.com" class="form-control" required>
            </div>
            <div class="form-group">
              <label class="control-label" for="signupPassword">Password</label>
              <input id="signupPassword" name="signupPassword" type="password" minlength="6" maxlength="25" class="form-control" placeholder="at least 6 characters" length="40" required>
            </div>
            <div class="form-group">
              <label class="control-label" for="signupPasswordagain">Password again</label>
              <input id="signupPasswordagain" name="signupPasswordagain" type="password" minlength="6" maxlength="25" class="form-control" required>
            </div>
            <div class="form-group">
            <label class="control-label" for="signupPassword">You are an</label>
            <input id="member_type" type="radio" name="member_type" value="0" required> Applicant
            <input id="member_type" type="radio" name="member_type" value="1" required> Employer
            </div>
            <div class="form-group">
              <input id="signupSubmit" type="submit" name="submit" value="Create your account" class="btn btn-info btn-block">
            </div>
            
          </form>
          </div>
          </div>
        
</div>
</div>


<footer style="margin-top: 0px;">
<div class="copyright" style="min-height:40px; background-color:#000000;">
  <div class="container">
    <div class="col-md-6">
      <p style="text-align:left; color:#FFF; padding:10px 0; margin-bottom:0px;">&copy; 2017 - All Rights reserved with Team-5 OOAD Group</p>
    </div>
    <div class="col-md-6">
      <ul class="bottom_ul">
        <li><a href="#">synthesize.com</a></li>
        <li><a href="#">Training</a></li>
        <li><a href="#">Jobs</a></li>
        <li><a href="#">Profile</a></li>
        <li><a href="#">Employers</a></li>
        <li><a href="#">Careers</a></li>
      </ul>
    </div>
  </div>
</div>
</footer>
 
</body>
</html>
