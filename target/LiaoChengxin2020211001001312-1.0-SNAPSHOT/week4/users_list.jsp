<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/18
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.LiaoChengxin.week3.homework.users"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>ID</td>
            <td>UserName</td>
            <td>Password</td>
            <td>Email</td>
            <td>Gender</td>
            <td>Birthdate</td>
        </tr>
        <%
            // 在这里写java代码
            // request：内置对象（这个对象已经创建好，名字也起好，就叫request）
            ArrayList<users> list = (ArrayList<users>) request.getAttribute("list");
            for (users user : list) {
        %>
        <tr>
            <td><%=user.getId()%></td>
            <td><%=user.getUsername()%></td>
            <td><%=user.getPassword()%></td>
            <td><%=user.getEmail()%></td>
            <td><%=user.getGender()%></td>
            <td><%=user.getBirthdate()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
