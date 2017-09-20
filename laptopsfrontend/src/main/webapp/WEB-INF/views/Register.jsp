<%@include file="Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>Insert title here</title> -->
</head>
<body>
<div class="container">
<form action="mainpage" method="post" role="form">
<div class="form-group">
<label for="txtname">Enter Name:</label><input type="text" name="txtname" required class="form-control">
<label for="txtfirst">Enter First Name:</label><input type="text" name="txtfirst" required class="form-control">
<label for="txtlast">Enter Last Name:</label><input type="text" name="txtlast" required class="form-control">

<label for="txtemail">Enter Email:</label><input type="text" name="txtemail" required class="form-control">
<label for="txtmob">Enter MobileNumber:</label><input type="text" name="txtmob" required class="form-control">
<label for="txtpass">Enter Password:</label><input type="text" name="txtpasss" required class="form-control">

<button type="button" class="btn btn-success">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<button type="button" class="btn btn-danger">Cancel</button>
</div>
</form>
</div>
</body>
</html>