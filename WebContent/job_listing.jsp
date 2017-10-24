<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>

<%
	if(session.getAttribute("email_id") == null){
		response.sendRedirect("login_required.jsp");
	}
	if(session.getAttribute("member_type") == "Employer"){
		response.sendRedirect("unauthorized_access.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Training and Placement Job Portal</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE = edge">
    <meta name="viewport" content="width = device-width, initial-scale = 1">

  
    <style type="text/css">
        nav.navbar{
            border-radius: 0px;
            background-color: black;
            color: white;
        }
        body{
            background-color: lightgrey;
        }
        .jumbotron{
            background-color: lightgrey;
        }
        .bottom_ul { list-style-type:none; float:right; margin-bottom:0px;}
        .bottom_ul li { float:left; line-height:40px;}
        .bottom_ul li:after { content:"/"; color:#FFF; margin-right:8px; margin-left:8px;}
        .bottom_ul li a { color:#FFF;  font-size:12px;}
        
        #job_listing{
            text-align: left;
            padding-left: 3%;
            margin-bottom: 2%;
        }
        
        #hrline{ 
            margin-top: 0.5em;
            margin-bottom: 0.5em;
            margin-left: auto;
            margin-right: auto;
            border-width: 2px;
            color: grey;
        }
    </style>

    <!-- Bootstrap scripts -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <!-- Custom script as written on bootstrap page -->
    
    <link href="https://fonts.googleapis.com/css?family=Oxygen" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    
    
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
      <a class="navbar-brand" href="#" style="color: white">SYNTHESIZE</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" style="border-radius: 2px" size="40px">
        </div>
        <button type="submit" class="btn btn-default" style="border-radius: 2px"><span class="glyphicon glyphicon-search"></span></button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="user_home_page.jsp">Home</a></li>
        <li><a href="#">Training</a></li>
        <li><a href="job_listing.jsp">Jobs</a></li>
		<li><a href="user_profile.jsp">Account</a></li>
		<li><a href="logout.jsp">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

    
<!-- Job posting form-->
<div id="job_listing">
    <ul>
        <li>
        <%
        
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/placement";
			String username = "root";
			String password = "";
		
			Class.forName(driver);
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String sql = "(SELECT * FROM job_postings)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet resultSet = ps.executeQuery(sql);
			int c=1;
			while(resultSet.next()){
		%>
            <a href=""><h3 style="color: blue"><%=resultSet.getString("job_title") %></h3></a>
            <h4>Company:<%=resultSet.getString("company_name") %></h4>
            <h4>Location: <%=resultSet.getString("location") %></h4>
            <p>Job Description:<%=resultSet.getString("job_description") %></p>
            <!-- <h5>Application Deadline<%=resultSet.getString("deadline") %></h5>
             <h5>Employer Contact:<%=resultSet.getString("emp_id") %></h5> -->
            <h6>Job Id:<%=resultSet.getString("job_id") %></h6>
           
         	<a href="Apply?job_id=<%=resultSet.getString("job_id") %>">
        <button type="button" class="btn btn-primary" > Apply 
        </button></a>
        	
        </li><hr id="hrline">
        <%
			}
		}
        catch(Exception e){
        		e.printStackTrace();
        }
        %>
    </ul>
</div>


<footer>
<div class="copyright" style="min-height:40px; background-color:#000000;">
  <div class="container">
    <div class="col-md-6">
      <p style="text-align:left; color:#FFF; padding:10px 0; margin-bottom:0px;">© 2017 - All Rights reserved with Team-5 OOAD Group</p>
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