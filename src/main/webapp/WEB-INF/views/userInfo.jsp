<%@ page import="com.LiaoChengxin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/30
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>User Info</h1>

<%--<%--%>
<%--    // read cookies--%>
<%--    Cookie[] allCookies =  request.getCookies();--%>
<%--    for (Cookie c:allCookies)--%>
<%--    {--%>
<%--        out.println("<br/>"+c.getName()+"----"+c.getValue());--%>
<%--    }--%>
<%--%>--%>

<%
    User u = (User) session.getAttribute("user");
%>
<table border="2px">
    <tr>
        <td>Id:</td><td><%=u.getId()%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=u.getGender()%></td>
    </tr>

    <tr>
        <td>birthDate:</td><td><%=u.getBirthdate()%></td>
    </tr>

</table>
<a href="updateUser">Update</a>
<%@include file="footer.jsp"%>
