<%@include file="AdminHome.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>Add Product</title>
</head>
<body>

  <form:form method="POST" action="addcat" commandName="category" >
  <table>
  <tr>
    <td><h2>Add Category</h2></td>
    </tr>
    <c:if test="${!empty category.categoryname}">
     <tr>
       <td><form:label path="catid">ID</form:label></td>
       <td><form:input path="catid" readonly="true" disable="true"/> <form:hidden path="catid" /></td>
       </tr>
       </c:if>
       
       <tr>
        <td><form:label path="categoryname">Category Name</form:label></td>
        <td><form:input path="categoryname"/></td>
        </tr>
        
          
          <tr>
           <c:if test="${empty category.categoryname }">
            <td style="text-align: center;"><input type="submit" value="Add Category" style="color: green; front-size: 15pi;"/></td>
            <td><input type="reset" value="cancel" style="color: red; font-size:15pt"/></td>
            
           </c:if>
           
          <c:if test="${!empty category.categoryname}">
          <td><input type="submit" value="Edit category"/></td>
          </c:if>
          
          </tr>
          </table>
          </form:form>
          <h2>Category List</h2>
          
          <!--  core tags,if or choose, $-expression language -->
          
          <c:if test="${!empty categoryList}">
           <table class="tg">
            <tr>
             <td>Category Id</td>
             <td>CategoryName</td>
             
            <!--  <td>Supplier Id</td> -->
             <td>Edit</td>
             <td>Delete</td>
             </tr>
             
             <c:forEach items="${categoryList}" var="category">
             <tr>
             <td>${category.catid}</td>
             <td>${category.categoryname}</td>
          
         <%-- <td>${product.category.catid }</td>
  <td>${product.supplier.supplierid }</td> --%>
   <td><a href="<c:url value='/editcategory${category.catid}'/>">Edit</a></td>
   
   <td><a href="<c:url value='/deletecategory${category.catid}'/>">Delete</a></td>
   </tr>
   </c:forEach>
   
  
   </table>
   </c:if>
  <a href="AdminHome">Back</a>
  
          </body>
          </html>
          