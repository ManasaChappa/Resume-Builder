<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
   <head>
    	<meta charset="UTF-8">
       		<title>User Profile </title>
        	 <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
   <script src="./bootstrap/js/jquery.min.js"></script>
   <script src="./bootstrap/js/bootstrap.min.js"></script>
    </head>
    
<body>
<div class="container">
<div class="form-row">

<ul class="nav nav-pills nav-fill">
  <li class="nav-item">
    <a class="nav-link " href=userprofile_view>Title</a>
  </li>
  <li class="nav-item">
    <a class="nav-link " href="<%=request.getContextPath()%>/list">Skills</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active"  href="#">Education Qualifications</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="<%=request.getContextPath()%>/listwork">Work History</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
  </li>
</ul>
</div>
<form action="usereducation_submit"  method="post" class="needs-validation" >

	<div class="container">
 	 <div class="form-row">
    	<div style="float:centre">
    	  <a href="<%=request.getContextPath()%>/newedu" class="btn btn-success">Add Education</a>
 		</div>
      	</div>
      	</div>
      	<div class="container">
      	<div align="center">
      	
        <table border="1" id='skillTable'>
            <tr class='table-sm'>
                <th>ID</th>
                <th>Degree</th>
                <th>School Name</th>
                <th>Major</th>
                <th>School Location</th>
                <th>Grad Month</th>
                <th>Grad Year</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="listEdu" items="${UserEdu}">
                <tr class='table-sm'>
                    <td><span id='RecordID'> <c:out value="${listEdu.getid()}" /></span> </td>
                    <td><c:out value="${listEdu.getDegree()}" /></td>
                    <td><c:out value="${listEdu.getSchoolName()}" /></td>
                    <td><c:out value="${listEdu.getMajor()}" /></td>
                    <td><c:out value="${listEdu.getSchoolLocation()}" /></td>
                    <td><c:out value="${listEdu.getGradMonth()}" /></td>
                    <td><c:out value="${listEdu.getGradYear()}" /></td>
                    <td><a href="<%=request.getContextPath()%>/editedu?id=<c:out value='${listEdu.getid()}' />">Edit</a>
                                   
                    </td>
                     <td><a href="<%=request.getContextPath()%>/deleteedu?id=<c:out value='${listEdu.getid()}' />">Delete</a>
                                   
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    <a class="nav-link " href="<%=request.getContextPath()%>/list">Back</a>
        <a class="nav-link " href="<%=request.getContextPath()%>/listwork">Back</a>
    
      	</div>
      	
</form>
</div>

</body>

</html>
