<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
name : LiaoChengxin ID:2020211001001312
<h2>Welcome,
    <%--todo 9 : use jsp:useBean to access the same instance of login bean from request scope--%>
    <jsp:useBean id="user" class="com.Lab2.Login" scope="request"/>
    <%--todo 10 : use jsp:getProperty to display username --%>
    <%
        out.println("<h2>"+user.getUsername()+"</h2>");
    %>
</h2>
</body>
</html>
