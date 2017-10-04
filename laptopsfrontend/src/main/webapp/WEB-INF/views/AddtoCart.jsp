<%@ include file="Header.jsp"%>

<!-- <h3>Basket</h3>
<div class="form-group">
<div>
 <button type="button" class="btn btn-info btn-lg" style="color:blue;">Continue Shopping</button>
</div>
<div>
<div class="row">
			<div class="col-sm-6">
			<table class="table table-hover" >
			<tr>
			<td>Type</td>
			<td>Guitar</td>
			</tr>
			<tr>
			<td>Name</td>
			<td>Bass Guitar</td>
			</tr>
			<tr>
			<td>Type</td>
			<td>Guitar</td>
			</tr>
			<tr>
			<td>Type</td>
			<td>Guitar</td>
			</tr>
			<tr>
			<td>Type</td>
			<td>Guitar</td>
			</tr>
			</table>
				

</div>
<a href="Cart"><button class="btn btn-primary dropdown-toggle" type="button">Cart</button></a>
			
</div>

</div>
</div>
 -->
 
<br>
<br>
<br>
<c:choose>
	<c:when test="${!empty mycartList}">
MY CART<br>
		<table class="table table-hover">

			<tr style="background-color: #D8D4D4">
				<th>Product Name</th>
				<th>Product Description</th>
				<th>quantity</th>
				<th>Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${mycartList}" var="cart">
				<tr>
					<td>${cart.cartproduct.name}</td>
					<td>${cart.cartproduct.description}</td>
					<td>${cart.qty}</td>
					<td>${cart.price}</td>
					<td><a href="<c:url value='cartupdate${product.prodid}'/>"><span
							class="glyphicon glyphicon-pencil"></span></a></td>
					<td><a href="<c:url value='cartitemdelete${cartid}'/>"><span
							class="glyphicon glyphicon-trash"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="checkout">checkout</a>
	</c:when>
	<c:otherwise>
No Products in your Cart
</c:otherwise>
</c:choose>

<%@ include file="Footer.jsp"%>