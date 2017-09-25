<%@include file="Header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>Insert title here</title> -->
</head>
<body>
<div class="container">
<form action="perform_login" method="post" role="form">
<div class="form-group">
<label for="txtemail">Enter Email:</label><input type="text" name="username" required class="form-control">
<label for="txtpass">Enter Password:</label><input type="password" name="password" required class="form-control">
<button type="submit" class="btn btn-success">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<button type="button" class="btn btn-danger">Cancel</button>
</div>
</form>
</div>
<%-- <form:form method="POST" action="perform_login" commandName="user" >
  <table>
  <tr>
    <td><h2>Login</h2></td>
    </tr>
    
     
       <tr>
        <td><form:label path="emailid">Email Id</form:label></td>
        <td><form:input path="emailid"/></td>
        </tr>
        <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password"/></td>
        </tr>
        <tr>
           
            <td style="text-align: center;"><input type="submit" value="Login" style="color: green; front-size: 15pi;"/></td>
            <td><input type="reset" value="cancel" style="color: red; font-size:15pt"/></td>
            
           
          
          </tr>
          </table>
          </form:form>
         --%>
</body>
</html>