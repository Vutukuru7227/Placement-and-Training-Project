<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" style="border-radius: 2px">
        </div>
        <button type="submit" class="btn btn-default" style="border-radius: 2px">Submit</button>
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


<!-- General Informnation -->
<div class="container">
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <tr>
      <th>General Details</th>
    </tr>
    <tr>
      <td>
        <!-- General Information Goes here -->
        <span style="float: right;">
        <button type="button" class="btn btn-default glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editGenModal">
        </button>
      </span>
      </td>
    </tr>
  </table>
</div>

<!-- Edit GenModal-->
<div class="modal fade" id="editGenModal" tabindex="-1" role="dialog" aria-labelledby="editGenModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Add General Details</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="" method="POST" action="">
          <label>First Name</label><br>
          <input type="text" name="" id=""><br>

          <label>Last Name</label><br>
          <input type="text" name="" id=""><br>

          <label>Email</label><br>
          <input type="text" name="" id=""><br>

          <label>Primary Phone</label><br>
          <input type="text" name="" id=""><br>

          <label>Address</label><br>
          <input type="text" name="" id="" placeholder="Street/Apt No."><br>

          <label>Zipcode</label><br>
          <input type="text" name="" id=""><br>

          

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Save</button>
        <button type="button" class="btn btn-danger" style="float: left;">Delete</button>
      </div>
    </div>
  </div>
</div>


<!-- Education Information -->
<div class="container">
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <tr>
      <th>Education<span style="float: right;">
        <button type="button" class="btn btn-default glyphicon glyphicon-plus-sign" data-toggle="modal" data-target="#addEduModal">
        </button>
      </span></th>
    </tr>
    <tr>
      <td>
        <!-- Education Information Goes here -->
        <span style="float: right;">
        <button type="button" class="btn btn-default glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editEduModal">
        </button>
      </span>
      </td>
    </tr>
  </table>
</div>

<!-- add EduModal -->
<div class="modal fade" id="addEduModal" tabindex="-1" role="dialog" aria-labelledby="addEduModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Add education</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="" method="POST" action="">
          <label>University</label><br>
          <input type="text" name="" id=""><br>

          <label>Degree</label><br>
          <input type="text" name="" id=""><br>

          <label>Major</label><br>
          <input type="text" name="" id=""><br>

          <label>GPA</label><br>
          <input type="text" name="" id=""><br>

          <label>Time Period</label><br>
          From: <input type="number" name="" id="" min="2000" max="2017"> To (or expected): <input type="number" name="" id="" min="2000" max="2024">

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Save</button>
      </div>
    </div>
  </div>
</div>


<!-- Edit EduModal-->
<div class="modal fade" id="editEduModal" tabindex="-1" role="dialog" aria-labelledby="editEduModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Edit education</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="" method="POST" action="">
          <label>University</label><br>
          <input type="text" name="" id=""><br>

          <label>Degree</label><br>
          <input type="text" name="" id=""><br>

          <label>Major</label><br>
          <input type="text" name="" id=""><br>

          <label>GPA</label><br>
          <input type="text" name="" id=""><br>

          <label>Time Period</label><br>
          From: <input type="number" name="" id="" min="2000" max="2017"> To (or expected): <input type="number" name="" id="" min="2000" max="2024">

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Save</button>
        <button type="button" class="btn btn-danger" style="float: left;">Delete</button>
      </div>
    </div>
  </div>
</div>



<!-- Work Experience Information -->
<div class="container">
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <tr>
      <th>Work Experience<span style="float: right;">
        <button type="button" class="btn btn-default glyphicon glyphicon-plus-sign" data-toggle="modal" data-target="#addWorkModal">
        </button>
      </span></th>
    </tr>
    <tr>
      <td>
        <!-- Education Information Goes here -->
        <span style="float: right;">
        <button type="button" class="btn btn-default glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editWorkModal">
        </button>
      </span>
      </td>
    </tr>
  </table>
</div>

<!-- add WorkModal -->
<div class="modal fade" id="addWorkModal" tabindex="-1" role="dialog" aria-labelledby="addWorkModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Add Work Experience</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="" method="POST" action="">
          <label>Title of the position</label><br>
          <input type="text" name="" id=""><br>

          <label>Organisation Name</label><br>
          <input type="text" name="" id=""><br>

          <label>Location</label><br>
          <input type="text" name="" id=""><br>

          <label>Time Period</label><br>
          From: <input type="number" name="" id="" min="2000" max="2017"> To: <input type="number" name="" id="" min="2000" max="2024"><br>

          <label>Achievements</label><br>
          <textarea rows="4" cols="50"></textarea>

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Save</button>
      </div>
    </div>
  </div>
</div>


<!-- Edit WorkModal-->
<div class="modal fade" id="editWorkModal" tabindex="-1" role="dialog" aria-labelledby="editWorkModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Edit Work Experience</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="" method="POST" action="">
          <label>Title of the position</label><br>
          <input type="text" name="" id=""><br>

          <label>Organisation Name</label><br>
          <input type="text" name="" id=""><br>

          <label>Location</label><br>
          <input type="text" name="" id=""><br>

          <label>Time Period</label><br>
          From: <input type="number" name="" id="" min="2000" max="2017"> To: <input type="number" name="" id="" min="2000" max="2024"><br>

          <label>Achievements</label><br>
          <textarea rows="4" cols="50"></textarea>

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Save</button>
        <button type="button" class="btn btn-danger" style="float: left;">Delete</button>
      </div>
    </div>
  </div>
</div>


<!-- Technical Skills Information -->
<div class="container">
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <tr>
      <th>Skills<span style="float: right;">
        <button type="button" class="btn btn-default glyphicon glyphicon-plus-sign" data-toggle="modal" data-target="#addSkillsModal">
        </button>
      </span></th>
    </tr>
    <tr>
      <td>
        <!-- Technical Skills Goes here -->
        <span style="float: right;">
        <button type="button" class="btn btn-default glyphicon glyphicon-pencil" data-toggle="modal" data-target="#editSkillsModal">
        <button type="button" class="btn btn-danger glyphicon glyphicon-trash" id="">
        </button>
      </span>
      </td>
    </tr>
  </table>
</div>

<!-- add SkillsModal -->
<div class="modal fade" id="addSkillsModal" tabindex="-1" role="dialog" aria-labelledby="addSkillsModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Add Skill</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="" method="POST" action="">
          <label>Skill Category</label><br>
          <select>
  			<option value="Programming">Programming</option>
  			<option value="Frameworks">Frameworks</option>
  			<option value="Operating Systems">Operating Systems</option>
  			<option value="Protocols">Protocols</option>
 			<option value="Others">Others</option>
		</select><br>
          <label>Skill</label><br>
          <input type="text" name="" id="" placeholder="Ex:- Java">

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Save</button>
      </div>
    </div>
  </div>
</div>


<!-- Edit SkillsModal-->
<div class="modal fade" id="editSkillsModal" tabindex="-1" role="dialog" aria-labelledby="editSkillsModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><b>Edit Technical Skill</b></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="" method="POST" action="">
          <label>Skill</label><br>
          <input type="text" name="" id="">

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-success">Save</button>
        <button type="button" class="btn btn-danger" style="float: left;">Delete</button>
      </div>
    </div>
  </div>
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
