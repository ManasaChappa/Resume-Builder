<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
   <head>
    	<meta charset="UTF-8">
       		<title>User Profile </title>
        	 <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
   <script src="./bootstrap/js/jquery.min.js"></script>
   <script src="./bootstrap/js/bootstrap.min.js"></script>
    </head>
    
<body>
<form action="userprofile_submit"  method="post" class="needs-validation" >
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
    <a class="nav-link" href="#">Education Qualifications</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="#">Work History</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
  </li>
  <
</ul>
</div>
 	 <div class="form-row">
    	<div class="form-group col-md-6">
      		<label for="txtUserName">User Name</label>
      		<c:if test="${UserProfile != null}">
      			<input type="hidden" name ="hdnMode" value="1">
      			<input type="text" disabled class="form-control" id="txtUserName" name="txtUserName" value="${UserProfile.getUserName()}" placeholder="User Name">
      		  </c:if>
      		  <c:if test="${UserProfile == null}">
      		  	<input type="hidden" name ="hdnMode" value="0">
      		  	<input type="text" class="form-control" id="txtUserName" name="txtUserName" placeholder="User Name">
      		  </c:if>
      		  	
      	</div>
    	<div class="form-group col-md-6">
      		<label for="inputPassword4">Password</label>
      		<c:if test="${UserProfile != null}">
      			<input type="password" class="form-control" id="txtPassword" name="txtPassword" placeholder="Password" disabled>
      		</c:if>
      		 <c:if test="${UserProfile == null}">
      			<input type="password" class="form-control" id="txtPassword" name="txtPassword" placeholder="Password" >
      		</c:if>
      		
    	</div>
 	  	<div class="form-group col-md-6">
    	  	<label for="txtFirstName">First Name</label>
      		<input type="text" class="form-control" id="txtFirstName" name="txtFirstName" value="${UserProfile.getFirstName()}"  placeholder="First Name" >
    	</div>
    	<div class="form-group col-md-2">
      		<label for="txtMiddleName">Middle Name</label>
      		<input type="text" class="form-control" id="txtMiddleName" name="txtMiddleName" value="${UserProfile.getMiddleName()}"   placeholder="Middle Name">
    	</div>
    	<div class="form-group col-md-4">
      		<label for="txtLastName">Last Name</label>
      		<input type="text" class="form-control" id="txtLastName" name="txtLastName" value="${UserProfile.getLastName()}"  placeholder="Last Name">
    	</div>
 		<div class="form-group col-md-6">
    		<label for="txtAddress">Address</label>
    		<input type="text" class="form-control" id="txtAddress" name="txtAddress" value="${UserProfile.getAddress()}"  placeholder="1234 Main St">
  		</div>
  		<div class="form-group col-md-6">
    		<label for="txtAddress2">Address 2</label>
    		<input type="text" class="form-control" id="txtAddress2" name="txtAddress2"  value="${UserProfile.getAddress1()}"  placeholder="Apartment, studio, or floor">
  		</div>
    	<div class="form-group col-md-6">
      		<label for="txtCity">City</label>
      		<input type="text" class="form-control" id="txtCity" value="${UserProfile.getCity()}" name="txtCity">
    	</div>
    	<div class="form-group col-md-3">
    		<label for="cmbState">State</label>    	
    		
      		<select name="cmbState">
   				 <c:forEach items="${State}" var="state">
       				 <option value="${state.getStateCode()}" selected>${state.getStateName()}</option>
    			</c:forEach>
			</select>
      	</div>
    	<div class="form-group col-md-3">
      		<label for="txtZip">Zip</label>
      		<input type="text" class="form-control" id="txtZip" value="${UserProfile.getZipcode()}"  name="txtZip">
    	</div>
  	</div>
	 <div style="float:right">
 		 <input type="submit" class="btn btn-primary" name="btnSubmit" placeholder="Next">
 	</div>
	</div>
 </form>

</body>
</html>
