<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/23
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1 style="text-align: center">Login</h1>

<%
    if (!(request.getAttribute("message")==null)){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>

<form method="post" action="login">
    <table cellspacing = "10px">
        <tr>
            <td><span>Username:</span></td>
            <td><input style = "width: 300px; height: 35px;" name="loginName" type = "text"></td>
        </tr>

        <tr>
            <td><span>Password:</span></td>
            <td><input style = "width: 300px; height: 35px;" name="loginPassword" type = "password"></td>
        </tr>

        <tr>
            <td>
                <div style="width: 90px;height: 35px;"></div>
            </td>
            <td><input style = "width: 120px;height: 35px; font-size: 18px; font-weight: 700;
                letter-spacing: 2px; background-color: rgba(23, 139, 233, 0.8); color: #fff;" type = "submit" value="Login"></td>
        </tr>
    </table>
</form>
<%@include file="footer.jsp"%>>