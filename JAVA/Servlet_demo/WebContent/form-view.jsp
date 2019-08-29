<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>form</title>
</head>
<body>
<font color="red">
<c:if test="${err !=null}">
<br/>
 <c:forEach var="s" items="${err}">
${s}
<br/>
</c:forEach>
</c:if>
<% 
//if(request.getAttribute("err")!=null){
//	List<String> err = (List<String>)request.getAttribute("err");
//for(String a:err){
	
//	out.println(a);
//	out.println("<br/>");
//}

//}	
	%> 
</font>
<form action='addPlayContoller'>
<input type='text' name='season'>
<input type='text' name='year'>
<select name='league'>
<option value='un'></option>
<option value='Barcyls' >Barcyls EPL</option>

<option value='SeriaA'>Serial A</option>
<option value='LaLiga'>LaLiga</option>
<option value='Bundas'>Bundes liga</option>

</select>

<input type='submit' value='submit'>
</form>
</body>
</html>