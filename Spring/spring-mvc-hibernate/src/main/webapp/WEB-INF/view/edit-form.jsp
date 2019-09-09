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

<form:form action="postEdit" modelAttribute="editC" method="post">
id<form:input path="id" value="${editC.id}" readonly="true"/>
First Name:<form:input path="fname" value="${editC.fname}"/><br>
Last Name:<form:input path="lname"  value="${editC.lname}"/><br>
Email:<form:input path="email"  value="${editC.email}"/><br>
<input type="submit" value="Add Customer">
</form:form>
</body>
</html>