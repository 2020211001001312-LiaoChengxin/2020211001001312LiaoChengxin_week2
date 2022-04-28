<%@ page import="com.LiaoChengxin.week10.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/4/28
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo-2-week 10</title>
</head>
<body>
<h1>use java code to access String bean class</h1>
<jsp:useBean id="bean" class="com.LiaoChengxin.week10.StringBean"/>
<%
//    com.LiaoChengxin.week10.StringBean bean = new StringBean();
//    bean.setMessage("Hello Mr Bean - from java code");

%>
<jsp:setProperty name="bean" property="message" value="<%=request.getParameter("message")%>"/>

Message(using java code):<%=bean.getMessage()%>


<h2>use usebean to access StringBean class in jsp</h2>
message(using getProperty) : <jsp:getProperty name="bean" property="message"/>
</body>
</html>
