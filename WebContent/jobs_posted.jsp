<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jobs Posted</title>
</head>
<body>
  <table class="table table-bordered table-condensed" align="center" style="background-color: white; max-width: 800px">
    <c:forEach var="job" items="${jobsPosted}">
    <tr>
      <td>
      <b>Job Id:</b> <c:out value="${job.job_id}"/><br>
      </td>
      
      <td>
      <b>Employee Id:</b> <c:out value="${job.emp_id}"/><br>
      </td>
      
      <td>
      <b>Company Name:</b> <c:out value="${job.company}"/><br>
      </td>
      
      <td>
      <b>Location:</b> <c:out value="${job.location}"/><br>
      </td>
      
      <td>
      <b>Job title:</b> <c:out value="${job.job_title}"/><br>
      </td>
      
      <td>
      <b>Job Description:</b> <c:out value="${job.job_description}"/><br>
      </td>
      <hr id="hrline">
    </tr>
    </c:forEach>
  </table>


</body>
</html>