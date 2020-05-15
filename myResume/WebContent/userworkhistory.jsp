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
    <a class="nav-link "  href="<%=request.getContextPath()%>/listedu">Education Qualifications</a>
  </li>
   <li class="nav-item">
    <a class="nav-link active" href="#">Work History</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Personalize</a>
  </li>
</ul>
</div>
<form action="usereducation_submit"  method="post" class="needs-validation" >

	<div class="container">
 	 <div class="form-row">
    	<div style="float:centre">
    	  <a href="<%=request.getContextPath()%>/newwork" class="btn btn-success">Add Workhistory</a>
 		</div>
      	</div>
      	</div>
      	<div class="container">
      	<div align="center">
      	
        <table border="1" id='skillTable'>
            <tr class='table-sm'>
                <th>ID</th>
                <th>Job Title</th>
                <th>Employer</th>
                <th>City</th>
                <th>State</th>
                <th>Start Date</th>
                <th>End Date</th>
                 <th>Is current Employer?</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="listEdu" items="${UserWork}">
                <tr class='table-sm'>
                    <td><span id='RecordID'> <c:out value="${UserWork.getid()}" /></span> </td>
                    <td><c:out value="${UserWork.getJobTitle()}" /></td>
                    <td><c:out value="${UserWork.getJobEmployer()}" /></td>
                    <td><c:out value="${UserWork.getJobCity()}" /></td>
                    <td><c:out value="${UserWork.getJobState()}" /></td>
                    <td><c:out value="${UserWork.getstdate()}" /></td>
                    <td><c:out value="${UserWork.getenddate()}" /></td>
                    <td><c:out value="${UserWork.getiscurrentemp()}" /></td>
                    <td><a href="<%=request.getContextPath()%>/editwork?id=<c:out value='${UserWork.getid()}' />">Edit</a>
                                   
                    </td>
                     <td><a href="<%=request.getContextPath()%>/deletework?id=<c:out value='${UserWork.getid()}' />">Delete</a>
                                   
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    <a class="nav-link " href="<%=request.getContextPath()%>/listedu">Back</a>
      	</div>
      	
</form>
</div>

</body>

</html>
