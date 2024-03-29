<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>

<%--
if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")){
    String url="welcome.jsp?username="+request.getParameter("username");
    response.sendRedirect(url);
}else{
    request.setAttribute("message","Username Password Error");
    request.getRequestDispatcher("login.jsp").include(request,response);
}
--%>
<%--done 2: use c:choose ,c:when c:otherwise to validate username is 'admin' and  password is 'admin'--%>
<c:choose>
    <c:when test="${param.username=='admin' && param.password=='admin'}">
        <%--done 3: when username == admin use c:url and c:param to make url = "welcome.jsp?username=admin"--%>
         <c:url var="gotoWelcom" value="welcome.jsp">
            <c:param name="username" value="admin"/>
         </c:url>
        <%-- done 4.use c:redirect to url= welcome.jsp?username=admin--%>
        <c:redirect url="${gotoWelcom}"/>
    </c:when>
    <%-- done 5. use c:otherwise --%>
<c:otherwise>
    <%-- done 6:use c:set to set a attribute name message="username password error" in request  --%>
    <c:set var="message" value="username password error" scope="request"/>
    <%--done 7:use c:import to include login.jsp --%>
    <c:import url="login.jsp"/>
</c:otherwise>
</c:choose>
</body>
</html>
