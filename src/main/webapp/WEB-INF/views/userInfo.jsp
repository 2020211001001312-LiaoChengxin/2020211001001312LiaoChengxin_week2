<%@ page import="com.LiaoChengxin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/30
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user = (User) request.getAttribute("user");

%>
<table border="2px">
    <tr>
        <td>Id:</td><td><%=user.getId()%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=user.getGender()%></td>
    </tr>

    <tr>
        <td>birthDate:</td><td><%=user.getBirthdate()%></td>
    </tr>

</table>
<%@include file="footer.jsp"%>
