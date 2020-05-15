<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
   <script src="./bootstrap/js/jquery.min.js"></script>
   <script src="./bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

  
<div class="container">
        <div class="panel panel-success">
            <div class="panel-heading" align="center">
                <h4><b><font color="black" style="font-family: fantasy;">Login</font> </b></h4>
            </div>
            <div class="panel-body"align="center">
                 
                <div class="container " style="margin-top: 10%; margin-bottom: 10%;">
   
                    <div class="panel panel-success" style="max-width: 35%;" align="left">
                       
                        
                        <div class="panel-body" >

                        <form action="user" method="post">
                            <div class="form-group">
                                <label for="exampleInputEmail1">User Name</label> <input
                                    type="text" class="form-control" name="txtUserName" id="txtUserName"
                                    placeholder="Enter User Name" required="required">
                                   
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label> <input
                                    type="password" class="form-control" name="txtPass" id="txtPass"
                                    placeholder="Password" required="required">
                            </div>
                            <button type="submit" style="width: 100%; font-size:1.1em;"  ><b>Login</b></button>
   							<a href="newuser">Dont have a Profile? Create one</a>
 							                     
                        </form>

                        </div>
                    </div>
                   
                </div>
               
            </div>
           
        </div>
    </div>
   
</body>
</html>