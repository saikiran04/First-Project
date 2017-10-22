<%@include file="AdminHome.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table#t1{border-spacing:30px;
}
table{
   border-color:red }
th {
    background-color: #4CAF50;
    color: white;
}
tr:hover {background-color: #f5f5f5}
th {
    padding: 10px;
    }
td {
    padding:5px;
    }    


</style>

<title>Add Product</title>
</head>
<body>

  <form:form method="POST" action="addprod" commandName="product" enctype="multipart/form-data">
  <table id="t1">
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
        <td><span><form:errors path="prodname" cssStyle="color:#ff0000;"/></span></td>
        </tr>
        <tr>
         <td><form:label path="price">Price</form:label></td>
         <td><form:input path="price"/></td>
         <td><span><form:errors path="price" cssStyle="color:#ff0000;"/></span></td>
         </tr>
         
         <tr>
          <td><form:label path="quantity">Quantity</form:label></td>
          <td><form:input path="quantity"/></td>
          <td><span><form:errors path="quantity" cssStyle="color:#ff0000;"/></span></td>
          </tr>
          
          <!-- select:dropdown, items:collection, itemvalue:name to item -->
          
          <tr>
          <td>Category </td>
          <td><form:select path="catid" items="${categoryList}" itemValue="catid" itemLabel="catid">
          </form:select></td>
          </tr>

         <tr>
          <td>Supplier </td>
          <td><form:select path="supplierid" items="${supplierList}" itemValue="supplierid" itemLabel="supplierid">
          </form:select></td>
          </tr>
          
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
          
          <h2 align="center">Product List</h2>
          
          <!--  core tags,if or choose, $-expression language -->
          
          <c:if test="${!empty productList }">
           <table class="tg" align="center">
            <tr>
             <th>Product Id</th>
             <th>ProductName</th>
             <th>Price</th>
             <th>Quantity</th>
             <th>Category Name</th>
             <th>Supplier Name</th>
             <th>Edit</th>
             <th>Delete</th>
             </tr>
             
             <c:forEach items="${productList }" var="product">
             <tr>
             <td>${product.prodid }</td>
             <td>${product.prodname }</td>
          <td>${product.price }</td>
          <td>${product.quantity }</td>
         <td>${product.category.categoryname }</td>
  <td>${product.supplier.suppliername }</td>
   <td><a href="<c:url value='/editproduct${product.prodid }'/>">Edit</a></td>
   
   <td><a href="<c:url value='/deleteproduct${product.prodid }'/>">Delete</a></td>
   </tr>
   </c:forEach>
   
  
   </table>
   </c:if>
  <a href="AdminHome">Back</a>
  
  
</body>
</html>