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
<div class="form-row">
  


<div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${existSkill != null}">
                            <form action="update" method="get">
                        </c:if>
                        <c:if test="${existSkill == null}">
                            <form action="insert" method="get">
                        </c:if>

</div>
                       
                                <c:if test="${existSkill != null}">
                                    Edit Skill
                                </c:if>
                                <c:if test="${existSkill == null}">
                                    Add New Skill
                                </c:if>
                           

                        <c:if test="${existSkill != null}">
                            <input type="hidden" name="id" value="<c:out value='${existSkill.getSkillID()}' />" />
                        </c:if>
                    </div></div></div>
                        
<div class="container">
 	 <div class="form-row">
    	<div class="form-group col-md-6">
      		<label for="txtSkill">Skill</label>
      		<textarea name="txtSkill" id="txtSkill" name="txtSkill" rows="4" cols="50">${existSkill.getSkill()}</textarea>
      	</div>
    	 <div style="float:right">
 		 	<input type="submit" class="btn btn-primary" name="btnSubmit" value="Save">
 		</div>
      	</div>
      	</div>
      	</form>
      	</body>
      	</html>