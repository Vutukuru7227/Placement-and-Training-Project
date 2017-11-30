<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

	if(session.getAttribute("email_id") == null){
		response.sendRedirect("login.jsp");
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
      <!--  <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" style="border-radius: 2px">
        </div>
        <button type="submit" class="btn btn-default" style="border-radius: 2px">Submit</button>
      </form>-->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="user_home_page.jsp">Home</a></li>
        <li><a href="#">Training</a></li>
        <li><a href="job_listing.jsp">Jobs</a></li>
		<li><a href="user_account.jsp">Account</a></li>
		<li><a href="logout.jsp">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

	  <%
		String username = (String) session.getAttribute("username");
	  	String email = (String) session.getAttribute("email_id");
	  %>
	  <h2 class="text-center">Hello <%=username%>!</h2>
	  <h4 class="text-center"><%=email%></h4><br>

<!-- General Information -->
<h4 class="text-center">General Information</h4>
<div class="container">
<span style="float: right;">
<a href="ProfileController?controller=GeneralInfo&action=insert">
        <button type="button" class="btn btn-primary">Add General Info
        </button></a>
      </span>
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${general}" var="info">
    <tr>
      <td>
      <b>Phone No.:</b> <c:out value="${info.phone_no}" /><br>
      <b>Address:</b> <c:out value="${info.address}" /><br>
      
      <b>Zip Code:</b> <c:out value="${info.zip_code}" /><br>
      
      </td>
        <td><span style="float: right;">
        <a href="ProfileController?controller=GeneralInfo&action=edit&userId=<c:out value="${info.user_id}"/>">
        <button type="button" class="btn btn-primary glyphicon glyphicon-pencil" >
        </button></a>
      </span></td>
      <td><span style="float: right;">
      <a href="ProfileController?controller=GeneralInfo&action=delete&userId=<c:out value="${info.user_id}"/>">
        <button type="button" class="btn btn-danger glyphicon glyphicon-trash">
        </button></a>
      </span></td>
    </tr>
    </c:forEach>
  </table>
</div>


<!-- Education Details -->
<h4 class="text-center">Education Details</h4>
<div class="container">
<span style="float: right;">
<a href="ProfileController?controller=Education&action=insert">
        <button type="button" class="btn btn-primary">Add Education
        </button></a>
      </span>
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${education}" var="edu">
    <tr>
      <td>
      <b>School Name:</b> <c:out value="${edu.institution}" /><br>
      <b>Degree:</b> <c:out value="${edu.level}" /><br>
      
      <b>Major:</b> <c:out value="${edu.major}" /><br>
      <b>GPA:</b> <c:out value="${edu.gpa}" /><br>
      <b>From - To:</b> <c:out value="${edu.edu_from}" /> -
      <c:out value="${edu.edu_to}" />
      </td>
        <td><span style="float: right;">
        <a href="ProfileController?controller=Education&action=edit&userId=<c:out value="${edu.user_id}"/>">
        <button type="button" class="btn btn-primary glyphicon glyphicon-pencil" >
        </button></a>
      </span></td>
      <td><span style="float: right;">
      <a href="ProfileController?controller=Education&action=delete&userId=<c:out value="${edu.user_id}"/>">
        <button type="button" class="btn btn-danger glyphicon glyphicon-trash">
        </button></a>
      </span></td>
    </tr>
    </c:forEach>
  </table>
</div>


<!-- Work Experience Details -->
<h4 class="text-center">Work Experience Details</h4>	  
<div class="container">
<span style="float: right;">
<a href="ProfileController?controller=WorkExperience&action=insert">
        <button type="button" class="btn btn-primary">Add Work Experience
        </button></a>
      </span>
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${workex}" var="work">
    <tr>
      <td>
      <c:out value="${work.title}" /><br>
      <c:out value="${work.organization_name}" /><br>
      <c:out value="${work.location}" /><br>
      <c:out value="${work.exp_from}" /> -
      <c:out value="${work.exp_to}" /> <br>
      <c:out value="${work.achievements}" />
      </td>
        <td><span style="float: right;">
        <a href="ProfileController?controller=WorkExperience&action=edit&userId=<c:out value="${work.user_id}"/>">
        <button type="button" class="btn btn-primary glyphicon glyphicon-pencil" >
        </button></a>
      </span></td>
      <td><span style="float: right;">
      <a href="ProfileController?controller=WorkExperience&action=delete&userId=<c:out value="${work.user_id}"/>">
        <button type="button" class="btn btn-danger glyphicon glyphicon-trash">
        </button></a>
      </span></td>
    </tr>
    </c:forEach>
  </table>
</div>


<!-- Skills Details -->
<h4 class="text-center">Skills</h4>	  
<div class="container">
<span style="float: right;">
<a href="Skills?action=insert">
        <button type="button" class="btn btn-primary">Add Skill
        </button></a>
      </span>
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${skills}" var="skill">
    <tr>
      <td>
      <b><c:out value="${skill.category}" />:</b>
      <c:out value="${skill.skill}" /><br>
      
      </td>
        <td><span style="float: right;">
        <a href="ProfileController?controller=Skills&action=edit&userId=<c:out value="${skill.user_id}"/>">
        <button type="button" class="btn btn-primary glyphicon glyphicon-pencil" >
        </button></a>
      </span></td>
      <td><span style="float: right;">
      <a href="ProfileController?controller=Skills&action=delete&userId=<c:out value="${skill.user_id}"/>">
        <button type="button" class="btn btn-danger glyphicon glyphicon-trash">
        </button></a>
      </span></td>
    </tr>
    </c:forEach>
  </table>
</div>

<footer>
<div class="copyright" style="min-height:40px; background-color:#000000;">
  <div class="container">
    <div class="col-md-6">
      <p style="text-align:left; color:#FFF; padding:10px 0; margin-bottom:0px;">Â© 2017 - All Rights reserved with Team-5 OOAD Group</p>
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
