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
    <a class="nav-link active" href="<%=request.getContextPath()%>/list">Skills</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<%=request.getContextPath()%>/listedu">Education Qualifications</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="#">Work History</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
  </li>
</ul>
</div>
<form action="userskill_submit"  method="post" class="needs-validation" >

	<div class="container">
 	 <div class="form-row">
    	<div style="float:centre">
    	  <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Skill</a>
 		</div>
      	</div>
      	</div>
      	<div class="container">
      	<div align="center">
      	
        <table border="1" id='skillTable'>
            <tr class='table-sm'>
                <th>Skill</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="listSkill" items="${UserSkill}">
                <tr class='table-sm'>
                    <td><span id='RecordID'> <c:out value="${listSkill.getSkillID()}" /></span> </td>
                    <td><c:out value="${listSkill.getSkill()}" /></td>
                    <td><a href="<%=request.getContextPath()%>/edit?id=<c:out value='${listSkill.getSkillID()}' />">Edit</a>
                                   
                    </td>
                     <td><a href="<%=request.getContextPath()%>/delete?id=<c:out value='${listSkill.getSkillID()}' />">Delete</a>
                                   
                    </td>
                </tr>
            </c:forEach>
            
        </table>
    </div> 
      	</div>
      	 <td><a href="<%=request.getContextPath()%>/listedu">Next</a>
</form>
</div>

</body>

</html>
