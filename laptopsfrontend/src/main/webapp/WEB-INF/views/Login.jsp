<%@include file="Header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>Insert title here</title> -->
</head>
<body>
<div class="container">
<form action="chkLogin" method="post" role="form">
<div class="form-group">
<label for="txtemail">Enter Email:</label><input type="text" name="txtemail" required class="form-control">
<label for="txtpass">Enter Password:</label><input type="password" name="txtpass" required class="form-control">
<button type="submit" class="btn btn-success">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
<button type="button" class="btn btn-danger">Cancel</button>
</div>
</form>
</div>
</body>
</html>