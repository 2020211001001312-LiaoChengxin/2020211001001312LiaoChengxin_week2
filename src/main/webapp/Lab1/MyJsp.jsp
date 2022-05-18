<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/24
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="header.jsp"%>--%>
<%--<span>This is my JSP page.</span>--%>
<%--<%@include file="footer.jsp"%>--%>
<h3>I am MyJsp.jsp</h3>
<form action="MyDearJspServlet" method="post">
    <table>
        <tr>
            <td>name:</td><td><input type="text" name="name" style="width: 300px;height: 30px"></td>
        </tr>
        <tr>
            <td>class:</td><td><input type="text" name="class" style="width: 300px;height: 30px"></td>
        </tr>
        <tr>
            <td>ID:</td><td><input type="text" name="ID" style="width: 300px;height: 30px"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Send data to server"/></td>
        </tr>

    </table>
</form>
