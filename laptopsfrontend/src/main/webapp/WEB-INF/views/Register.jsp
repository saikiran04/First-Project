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

<h2 align="center" style="color:green">Register Here</h2>
<hr>
<form:form method="POST" action="addus" commandName="user" enctype="multipart/form-data">
  <table align=center>
  
     <%-- <tr>
       <td><form:label path="userid">ID</form:label></td>
       <td><form:input path="userid" readonly="true" disable="true"/> <form:hidden path="userid" /></td>
       </tr>
       --%>
       <tr>
        <td><form:label path="username">Enter User Name</form:label></td>
        <td><form:input path="username"/></td>
        <td><span><form:errors path="username" cssStyle="color:#ff0000;"/></span></td>
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
        <td><span><form:errors path="emailid" cssStyle="color:#ff0000;"/></span></td>
        </tr>
        <tr>
         <td><form:label path="password">Enter Password</form:label></td>
         <td><form:input path="password" type="password"/></td>
         <td><span><form:errors path="password" cssStyle="color:#ff0000;"/></span></td>
         </tr>
         
         <tr>
          <td><form:label path="cpassword">Enter Confirm Password</form:label></td>
          <td><form:input path="cpassword" type="password"/></td>
          <td><span><form:errors path="cpassword" cssStyle="color:#ff0000;"/></span></td>
          </tr>
          <tr>
        <td><form:label path="mobile">Enter Mobile number</form:label></td>
        <td><form:input path="mobile" required="true" /></td>
        <%-- <td><span><form:errors path="mobile" cssstyle="color:#ff0000;"/></span></td> --%>
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
          <form:errors path="cpassword" cssClass="error message" cssStyle="width:900px"/>
          <c:if test="${not empty errMsg}">
          <h4 class="error message" style="width:900px; color:red;">${errMsg}</h4>
          </c:if>
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