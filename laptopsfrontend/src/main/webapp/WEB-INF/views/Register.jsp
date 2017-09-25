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
<!-- <div class="container">
<form action="mainpage" method="post" role="form">
<div class="form-group">
<label for="txtname">Enter Name:</label><input type="text" name="txtname" required class="form-control">
<label for="txtfirst">Enter First Name:</label><input type="text" name="txtfirst" required class="form-control">
<label for="txtlast">Enter Last Name:</label><input type="text" name="txtlast" required class="form-control">

<label for="txtemail">Enter Email:</label><input type="text" name="txtemail" required class="form-control">
<label for="txtmob">Enter MobileNumber:</label><input type="text" name="txtmob" required class="form-control">
<label for="txtpass">Enter Password:</label><input type="text" name="txtpasss" required class="form-control">

<button type="submit" class="btn btn-success">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<button type="button" class="btn btn-danger">Cancel</button>
</div>
</form>
</div> -->
<h2 align="center" style="color:green">Register Here</h2>
<hr>
<form:form method="POST" action="addus" commandName="user" enctype="multipart/form-data">
  <table align="center">
  
     <%-- <tr>
       <td><form:label path="userid">ID</form:label></td>
       <td><form:input path="userid" readonly="true" disable="true"/> <form:hidden path="userid" /></td>
       </tr>
       --%>
       <tr>
        <td><form:label path="username">Enter User Name</form:label></td>
        <td><form:input path="username"/></td>
        </tr>
        <tr></tr>
        
        <tr>
        <td><form:label path="firstname">Enter First Name</form:label></td>
        <td><form:input path="firstname"/></td>
        </tr>
        <tr>
        <td><form:label path="lastname">Enter Last Name</form:label></td>
        <td><form:input path="lastname"/></td>
        </tr>
        <tr>
        <td><form:label path="emailid">Enter Email ID</form:label></td>
        <td><form:input path="emailid"/></td>
        </tr>
        <tr>
         <td><form:label path="password">Enter Password</form:label></td>
         <td><form:input path="password" type="password"/></td>
         </tr>
         
         <tr>
          <td><form:label path="cpassword">Enter Confirm Password</form:label></td>
          <td><form:input path="cpassword" type="password"/></td>
          </tr>
          <tr>
        <td><form:label path="mobile">Enter Mobile number</form:label></td>
        <td><form:input path="mobile"/></td>
        </tr>
          
          
          <tr>
           <td><form:label path="img" >Select Image:</form:label></td>
           
           <td><form:input type="file" path="img"/></td>
           </tr>
           <tr></tr>
           <tr></tr>
           <tr>
           
           
            <td style="text-align: center;"><input type="submit" value="Register" style="color: green; front-size: 15pi;"/></td>
            <td><input type="reset" value="cancel" style="color: red; font-size:15pi"/></td>
            
           
          
          </tr>
          </table>
          </form:form>



</body>
<style>
h2{
color:"green";
}
table {
border:"1";
}
</style>
</html>