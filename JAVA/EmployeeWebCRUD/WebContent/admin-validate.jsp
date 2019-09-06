<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,code.D_28_08.Model.Employee"%>
 <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response </title>
</head>

<body>
<%!
String msg;
 %>
<jsp:useBean id="usr" class="code.D_28_08.Model.User" scope="page">
<jsp:setProperty property="*" name="usr"/>
</jsp:useBean>
<jsp:useBean id="empdb" class="code.D_28_08.DAO.EmployeeToDb">
</jsp:useBean>
<jsp:getProperty property="name" name="usr"/>
<jsp:getProperty property="password" name="usr"/>
<jsp:useBean id="msg" class="java.lang.String" scope="page"></jsp:useBean>
<% 
List<Employee> el=empdb.getAllEmployee();
int flag=0;
msg="User is Not Found";
for(Employee e:el){
	//out.println(e.getName());
	if(usr.getName().equals(e.getName())){
			flag=1;
		msg="User found";
		if(usr.getPassword().equals(e.getPassword())){
			msg="Good to GO";
			flag=2;
		}
	}
}

%>
${msg}
<font color="red">
<% out.println(msg); %>

</font>
</body>
</html>