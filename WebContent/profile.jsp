<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Training and Placement Job Portal</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE = edge">
    <meta name="viewport" content="width = device-width, initial-scale = 1">

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style type="text/css">
        .navbar{
            border-radius: 0;
        }
        body{
            background-color: lightgrey;
        }
        .jumbotron{
            background-color: lightgrey;
        }
    </style>
    <link href="https://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="profile.jsp" style="color: white">SYNTHESIZE</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" style="border-radius: 2px">
        </div>
        <button type="submit" class="btn btn-default" style="border-radius: 2px">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="profile.jsp">Home</a></li>
        <li><a href="#">Training</a></li>
        <li><a href="#">Jobs</a></li>

        <li class="dropdown">
          <a href="user_profile.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Account<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="user_profile.jsp">Profile</a></li>
            <li><a href="logout.jsp">Logout</a></li>
          </ul>
        </li> 
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


	<%
		String username = (String) request.getAttribute("username");
	%>

<div class="jumbotron">
  <h2 class="text-center">Hello <%=username%>!</h2>
  <p class="text-center">Welcome to Training and Placement Job Portal site</p>
  <p class="text-center"><a class="btn btn-primary btn-lg" href="user_profile.html" role="button">Learn more by creating your profile page!</a></p>
</div>


  
</div>
</body>
</html>
