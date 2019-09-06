<%@page import="com.mysql.fabric.xmlrpc.base.Param"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.*,code.D_28_08.Model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<div class="container">
        <div class="row justify-content-center align-items-center" style="height:100vh">
            <div class="col-4">
                <div class="card">
                    <div class="card-body">
                    <span color="red">
                    <%
                
                    	if(request.getAttribute("error")!=null){
	 		 out.println(request.getAttribute("error"));
  				}
          
  			
%>
<c:if test="${fn:length(param.name) > 0}">

   <jsp:include page="name.jsp"></jsp:include>
</c:if>
                    </span>
                       <!-- <form action="admin.varify" autocomplete="off" > -->
                        
                        <form action="admin-validate.jsp" autocomplete="off" >
                        
                            <div class="form-group">
                                <input type="text" value="name" class="form-control" name="name">
                            </div>
                            <div class="form-group">
                                <input type="password" value="password"class="form-control" name="password">
                            </div>
                            <button type="submit" id="sendlogin" class="btn btn-primary">login</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>