<%@ include file="Header.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="col-sm-6">
				<div class="thumbnail">
					<img src="/laptopsfrontend/pics/${loggedInUser}.jpg" alt="user image">
				</div>
			</div>
			<div class="col-sm-6">
				<table class="table table-responsive">
					<tr>
						<td>User Name</td>
						<td>${user.username}</td>
					</tr>
					<tr>
						<td>First Name</td>
						<td>${user.firstname}</td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td>${user.lastname}</td>
					</tr>
					<tr>
						<td>Email Id</td>
						<td>${user.emailid}</td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td>${user.mobile}</td>
					</tr>
					<tr>
						<td><a href="LoginDisplay"><input type="submit" value="OK" /></a></td>
					</tr>

				</table>
			</div>

		</div>

	</div>
	<div class="col-sm-3"></div>
</div>
<%-- <html>
<body>
<br>
<br>
<br>
<c:choose>
	<c:when test="${!empty userList}">
Profile<br>
		<table class="tg" style="border:'1'">

			<tr style="background-color: #D8D4D4">
				<th>Name</th></tr>
				<tr><th>First Name</th></tr>
				<tr><th>Last Name</th></tr>
				<!-- <th>Product Description</th> -->
				<tr><th>Email</th></tr>
				<tr><th>Mobile</th>
				
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.username}</td></tr>
					<td>${cart.cartproduct.description}</td>
					<tr><td>${user.firstname}</td></tr>
					<tr><td>${user.lastname}</td></tr>
					<tr><td>${user.emailid}</td></tr>
					<tr><td>${user.mobile}</td>
					
				</tr>
			</c:forEach>
		</table>
		<a href="LoginDisplay">Ok</a>
	</c:when>
	
</c:choose> --%>

<%@ include file="Footer.jsp"%>