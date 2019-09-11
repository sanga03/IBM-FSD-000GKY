<%@page import="com.customerMVC.Entity.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Data</title>
</head>
<body>

<form:form action="postAdd" modelAttribute="customer" method="post">
First Name:<form:input path="fname"/><br>
Last Name:<form:input path="lname"/><br>
Email:<form:input path="email"/><br>
<input type="submit" value="Add Customer">
</form:form>
</body>
</html>