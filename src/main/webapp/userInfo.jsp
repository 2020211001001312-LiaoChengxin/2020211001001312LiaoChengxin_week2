<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/30
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table border="2px">
    <tr>
        <td>Id:</td><td><%=request.getAttribute("id")%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=request.getAttribute("password")%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=request.getAttribute("email")%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=request.getAttribute("gender")%></td>
    </tr>

    <tr>
        <td>birthDate:</td><td><%=request.getAttribute("birthdate")%></td>
    </tr>

</table>
<%@include file="footer.jsp"%>
