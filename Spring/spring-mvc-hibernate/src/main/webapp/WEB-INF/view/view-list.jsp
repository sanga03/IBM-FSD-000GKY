<%@page import="java.util.List"%>
<%@page import="com.customerMVC.Entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>COUSTOMER REALATION MANAGEMENT</title>

</head>
<body>
<H2>COUSTOMER REALATION MANAGEMENT</H2>
<input type="button" class="btn btn-primary" value="Add new Customer" onclick="window.location.href='addC'">
<br>
<br>

<form:form action="search" modelAttribute="sea">
<div class="form-group">
	Search <form:input  class="form-control" path="sname" />
	</div>
<div class="form-group">	
	<form:select  class="form-control" path="stype">
	<form:option class="form-control"  value="Name"/>
	<form:option  class="form-control" value="Email"/>
	</form:select>
	</div>
	<div class="form-group">
	<input type="submit"  class="btn btn-primary" value="search">
</div>	
</form:form>
<br>
<br>
<br>
<br>
<br>

<table  class="table">
<thead>

<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
<th>Edit</th>
<th>Delete</th>
</thead>
<tbody>
 <%
List<Customer> lc=(List<Customer>)request.getAttribute("lists");
for(Customer c:lc){
//	out.prinln(c);
	request.setAttribute("CData", c);
	
	out.println("<tr><td>"+c.getFname()+"</td><td>"+c.getLname()+"</td><td>"+c.getEmail()+"</td><td>"+"<a href='edit?id="+c.getId()+"&fname="+c.getFname()+"&lname="+c.getLname()+"&email="+c.getEmail()+"'>edit</a></td>" +"<td>"+"<a href='delete?id="+c.getId()+"&fname="+c.getFname()+"&lname="+c.getLname()+"&email="+c.getEmail()+"'>delete</a></td>"+"</tr>");	
}

%>
<c:forEach var="tempCustomer" items="${customers}">
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
					</tr>
				
				</c:forEach>

</tbody>
</table>

</body>
</html>