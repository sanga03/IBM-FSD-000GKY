<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Details</title>
</head>
<body>
<form:form action="performProcess" modelAttribute="student">
First Name:<form:input path="name"/><br/>
Last Name:<form:input path="lname"/></br>
Country:<form:select path="country">
<form:options items="${student.lc}"/>
</form:select>
<br>
java<form:radiobutton path="lang" value="java"/>
c#<form:radiobutton path="lang" value="c#"/>
c<form:radiobutton path="lang" value="c"/>
python<form:radiobutton path="lang" value="python"/>
<br>FAvo OS<br>
Linux Mint<form:checkbox path="os" value="Linux Mint"/>
Deepin<form:checkbox path="os" value="Deepin"/>
Ubuntu<form:checkbox path="os" value="Ubuntu"/>
Manjaro<form:checkbox path="os" value="Manjaro"/>
Arch<form:checkbox path="os" value="Arch"/>
Elementry OS<form:checkbox path="os" value="Elementry OS"/>
Kali Linux<form:checkbox path="os" value="Kali Linux"/>
Debian OS<form:checkbox path="os" value="Debian OS"/>
Windows<form:checkbox path="os" value="Windows"/>
<br>
<input type="submit">
</form:form>
</body>
</html>