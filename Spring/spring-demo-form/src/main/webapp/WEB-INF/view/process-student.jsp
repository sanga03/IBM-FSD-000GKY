<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<table >
<c:forEach var="student" items="${slist}">
<tr>
<td>${student.name}</td>
<td>${student.lname}</td>
<td>${student.country}</td>
<td>${student.lang}</td>
<c:forEach var="s" items="${student.os}">
${s}
 </c:forEach>
 </tr>
 </c:forEach>
 </table>
</body>

</html>