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
<form action="insertedu" >

<div class="container">

<div class="form-row">

<ul class="nav nav-pills nav-fill">
  <li class="nav-item">
    <a class="nav-link active" href="#">Title</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<%=request.getContextPath()%>/list">Skills</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Education</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="#">Work History</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
  </li>
</ul>
</div>

<div class="form-row">
    <div class="form-group col-md-6">
      	<label for="txtSchoolName">School Name</label>
      		<input type="text" class="form-control" id="txtSchoolName" name="txtSchoolName" placeholder="School Name">
      	</div>
    
      <div class="form-group col-md-6">
      	<label for="txtSchoolLocation">School Location</label>
      		<input type="text" class="form-control" id="txtSchoolLocation" name="txtSchoolLocation" placeholder="School Location">
      	</div>
     </div>


<div class="form-row">
    <div class="form-group col-md-6">
      	<label for="txtDegree">Degree</label>
      		<input type="text" class="form-control" id="txtDegree" name="txtDegree" placeholder="Degree">
      	</div>
    
      <div class="form-group col-md-6">
      	<label for="txtMajor">Major</label>
      		<input type="text" class="form-control" id="txtMajor" name="txtMajor" placeholder="Major - Field of study">
      	</div>
     </div>
		<div class="form-row">
	  <div class="form-group col-md-3">


<div class="form-row">
	<div class="form-group col-md-3">
  		<label for="cmbMonth">Graduation Date</label>   
  	</div> 	
  </div>
  <div class="form-row">
  	<div class="form-group col-md-3">
    	<select name="cmbMonth">
    		<option value="0" selected>All</option>
    		<option value="1" >Jan</option>
			<option value="2" >Feb</option>
			<option value="3" >Mar</option>
			<option value="4" >Apr</option>
			<option value="5" >May</option>
			<option value="6" >Jun</option>
			<option value="7" >Jul</option>
			<option value="8" >Aug</option>
			<option value="9" >Sep</option>
			<option value="10" >Oct</option>
			<option value="11" >Nov</option>
			<option value="12">Dec</option>
		</select>
    	<select name="cmbYear">
    		<option value="0" selected>All</option>
   			<c:forEach var="i" begin="2000" end="2022">
             <option value="${i}">${i}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-row">
	  <div class="form-group col-md-3">
	
	</div>
 	</div>
</div>
<div style="float:right">
 		 <input type="submit" class="btn btn-primary" name="btnSubmit" placeholder="Next">
 	</div>
</div>

</form>
</body>

</html>