<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/5/18
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <td>Name:</td><td><%=request.getAttribute("name")%></td>
    </tr>

    <tr>
        <td>class:</td><td><%=request.getAttribute("class")%></td>
    </tr>
    <tr>
        <td>ID:</td><td><%=request.getAttribute("ID")%></td>
    </tr>

</table>

</body>
</html>
