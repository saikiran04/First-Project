<%@include file="AdminHome.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table{ border-color:red }
th {
    background-color: #4CAF50;
    color: white;
}
tr:hover {background-color: #f5f5f5}

th, td {
    padding: 10px;
}
</style>
<title>Add Product</title>
</head>
<body>

  <form:form method="POST" action="addsupplier" commandName="supplier" enctype="multipart/form-data">
  <table>
  <tr>
    <td><h2>Add Supplier</h2></td>
    </tr>
    <c:if test="${!empty supplier.suppliername}">
     <tr>
       <td><form:label path="supplierid">ID</form:label></td>
       <td><form:input path="supplierid" readonly="true" disable="true"/> <form:hidden path="supplierid" /></td>
       </tr>
       </c:if>
       
       <tr>
        <td><form:label path="suppliername">Supplier Name</form:label></td>
        <td><form:input path="suppliername"/></td>
        </tr>
        
             <tr>
         <td><form:label path="address">Address</form:label></td>
         <td><form:input path="address"/></td>
         </tr>
         
         <tr>
          <td><form:label path="email">Email</form:label></td>
          <td><form:input path="email"/></td>
          </tr>
          <tr>
          <td><form:label path="phone">Phone</form:label></td>
          <td><form:input path="phone"/></td>
          </tr>
           <tr>
           <c:if test="${empty supplier.suppliername }">
            <td style="text-align: center;"><input type="submit" value="Add Supplier" style="color: green; front-size: 15pi;"/></td>
            <td><input type="reset" value="cancel" style="color: red; font-size:15pt"/></td>
            
           </c:if>
           
          <c:if test="${!empty supplier.suppliername }">
          <td><input type="submit" value="Edit category"/></td>
          </c:if></tr>
          </table>
          </form:form>
          
          <h2 align="center">Supplier List</h2>
          
          <!--  core tags,if or choose, $-expression language -->
          
          <c:if test="${!empty supplierList }">
           <table class="tg" align="center">
            <tr>
             <th background-color: #4CAF50;
                color: white;>Supplier Id</th>
             <th>SupplierName</th>
             <th>Address</th>
             <th>Email</th>
             <th>Phone</th>
             
             <th>Edit</th>
             <th>Delete</th>
             </tr>
             
             <c:forEach items="${supplierList }" var="supplier">
             <tr>
             <td>${supplier.supplierid }</td>
             <td>${supplier.suppliername }</td>
          <td>${supplier.address }</td>
          <td>${supplier.email }</td>
          <td>${supplier.phone }</td>
         <%-- <td>${product.category.catid }</td>
  <td>${product.supplier.supplierid }</td> --%>
   <td><a href="<c:url value='/editsupplier${supplier.supplierid }'/>">Edit</a></td>
   
   <td><a href="<c:url value='/deletesupplier${supplier.supplierid }'/>">Delete</a></td>
   </tr>
   </c:forEach>
   
  
   </table>
   </c:if>
  <a href="AdminHome">Back</a>
  
          </body>
          </html>
          