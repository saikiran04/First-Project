<%@include file="AdminHome.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>Add Product</title>
</head>
<body>

  <form:form method="POST" action="addprod" commandName="product" enctype="multipart/form-data">
  <table>
  <tr>
    <td><h2>Add Product</h2></td>
    </tr>
    <c:if test="${!empty product.prodname}">
     <tr>
       <td><form:label path="prodid">ID</form:label></td>
       <td><form:input path="prodid" readonly="true" disable="true"/> <form:hidden path="prodid" /></td>
       </tr>
       </c:if>
       
       <tr>
        <td><form:label path="prodname">Product Name</form:label></td>
        <td><form:input path="prodname"/></td>
        </tr>
        <tr>
         <td><form:label path="price">Price</form:label></td>
         <td><form:input path="price"/></td>
         </tr>
         
         <tr>
          <td><form:label path="quantity">Quantity</form:label></td>
          <td><form:input path="quantity"/></td>
          </tr>
          
          <!-- select:dropdown, items:collection, itemvalue:name to item -->
          
          <%-- <tr>
          <td>Category</td>
          <td><form:select path="catid" item="${categorylist}" itemValue="catid" itemLabel="catid">
          </form:select></td>
          </tr>

         <tr>
          <td>Supplier</td>
          <td><form:select path="supplierid" item="${supplierlist}" itemValue="supplierid" itemLabel="supplierid">
          </form:select></td>
          </tr> --%>
          
          <tr>
           <td><form:label path="img" >Select Image:</form:label></td>
           
           <td><form:input type="file" path="img"/></td>
           </tr>
           <tr>
           <c:if test="${empty product.prodname }">
            <td style="text-align: center;"><input type="submit" value="Add Product" style="color: green; front-size: 15pi;"/></td>
            <td><input type="reset" value="cancel" style="color: red; font-size:15pt"/></td>
            
           </c:if>
           
          <c:if test="${!empty product.prodname }">
          <td><input type="submit" value="Edit Product"/></td>
          </c:if>
          
          </tr>
          </table>
          </form:form>
          
          <h2>Product List</h2>
          
          <!--  core tags,if or choose, $-expression language -->
          
          <c:if test="${!empty productList }">
           <table class="tg">
            <tr>
             <th>Product Id</th>
             <th>ProductName</th>
             <th>Price</th>
             <th>Quantity</th>
             <th>Category Id</th>
             <th>Supplier Id</th>
             <th>Edit</th>
             <th>Delete</th>
             </tr>
             
             <c:forEach items="${productList }" var="product">
             <tr>
             <td>${product.prodid }</td>
             <td>${product.prodname }</td>
          <td>${product.price }</td>
          <td>${product.quantity }</td>
         <%-- <td>${product.category.catid }</td>
  <td>${product.supplier.supplierid }</td> --%>
   <td><a href="<c:url value='/editproducts${product.prodid }'/>">Edit</a></td>
   
   <td><a href="<c:url value='/deleteproduct${product.prodid }'/>">Delete</a></td>
   </tr>
   </c:forEach>
   
  
   </table>
   </c:if>
  <a href="AdminHome">Back</a>
  
  
</body>
</html>