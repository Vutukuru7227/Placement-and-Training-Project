<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
if(session.getAttribute("email_id") == null){
	response.sendRedirect("login.jsp");
}
	if(session.getAttribute("member_type") == "Applicant"){
		response.sendRedirect("unauthorized_access.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Applicant Profile</title>
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
     <!--   <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" style="border-radius: 2px">
        </div>
        <button type="submit" class="btn btn-default" style="border-radius: 2px">Submit</button>
      </form>-->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="employer_home_page.jsp">Home</a></li>
        <% 
        		String emp_id = session.getAttribute("email_id").toString();
        		request.setAttribute("emp_id", emp_id);
        	%>
        <li><a href="JobPosting?emp_id=<%=emp_id %>">Jobs Posted</a></li>
		<li><a href="#">Account</a></li>
		<li><a href="logout.jsp">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<h2 class="text-center">Applicant Details</h2>

<!-- General Information -->
<h4 class="text-center">General Information</h4>
<div class="container">
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${profile}" var="info">
    <tr>
      <td>
      <b>Phone No.:</b><c:out value="${info.phone_no}" /><br>
      <b>Address:</b> <c:out value="${info.address}" /><br>
      <b>Zip Code:</b> <c:out value="${info.zip_code}" /><br>
      
    </tr>
    </c:forEach>
  </table>
</div>

<!-- Education Details -->
<h4 class="text-center">Education Details</h4>
<div class="container">

  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${profile}" var="edu">
    <tr>
      <td>
      <c:forEach items="${edu.education}" var="obj">
      <b>School Name:</b> <c:out value="${obj.institution}" /><br>
      <b>Degree:</b> <c:out value="${obj.level}" /><br>
      <b>Major:</b> <c:out value="${obj.major}" /><br>
      <b>GPA:</b> <c:out value="${obj.gpa}" /><br>
      <b>From - To:</b> <c:out value="${obj.edu_from}" /> -
      <c:out value="${obj.edu_to}" />
      </c:forEach>
      </td>     
    </tr>
    </c:forEach>
  </table>
</div>

<!-- Work Experience Details -->
<h4 class="text-center">Work Experience Details</h4>	  
<div class="container">
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${profile}" var="work">
    <tr>
      <td>
      <c:forEach items="${work.workexperience}" var="obj">
      <c:out value="${obj.title}" /><br>
      <c:out value="${obj.organization_name}" /><br>
      <c:out value="${obj.location}" /><br>
      <c:out value="${obj.exp_from}" /> -
      <c:out value="${obj.exp_to}" /> <br>
      <c:out value="${obj.achievements}" /> <br>
                          <hr>
      
      </c:forEach>
      </td>
    </tr>
    </c:forEach>    
  </table>
</div>


<!-- Skills Details -->
<h4 class="text-center">Skills</h4>	  
<div class="container">
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach items="${profile}" var="skill">
    <tr>
    <td>
    <c:forEach items="${skill.skills}" var="obj" >
      <b><c:out value="${obj.category}" />:</b>
      	<c:out value="${obj.skill}" /><br>
    </c:forEach>
     </td>
    </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>