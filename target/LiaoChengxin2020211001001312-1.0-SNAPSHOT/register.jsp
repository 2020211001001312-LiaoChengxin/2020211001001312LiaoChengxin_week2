<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/3
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<!-- 表单 -->
<script src="week2/registerJavaScript.js"></script>
<link href="week2/registerStyle.css" rel="stylesheet" type="text/css">
<h1 style="text-align: center">This is my register JSP page.</h1>
<form method="post" action="register">
    <!-- 使用div来控制表单位置-->
    <div class = "user">

        <div class = "tableDiv">

            <p class = "title">New User Registration</p>
            <!-- 表单内容 -->

            <table cellspacing = "18px">

                <!-- 用户名部分 使用placeholder确定文本框在未输入下的内容-->
                <tr>
                    <td><span id = "username_span1">*</span>Username:</td>
                    <td> <input name = "username"  id = "username" onBlur = "checkUsername(this)" style = "width: 300px; height: 35px;" type = "text"
                                placeholder = "Please enter your name" maxlength = "20" size = "15px"> </td>
                    <td><span id = "username_span2" style = "font-size: 15px;"></span></td>
                </tr>

                <!-- 密码部分 文本框-->
                <tr>
                    <td><span id = "password_span1">*</span>Password:</td>
                    <td>  <input name = "password" id = "password" onBlur = "checkPassword(this)" style = "width: 300px; height: 35px;" type = "password"
                                 placeholder = "Please enter your password" maxlength = "18" size = "15px"> </td>
                    <td><span id = "password_span2" style = "font-size: 15px;"></span></td>
                </tr>

                <!-- email部分 -->
                <tr>
                    <td><span id = "email_span1">*</span>Email:</td>
                    <td><input name = "email" id = "Email" onBlur = "checkEmail(this)" style = "width: 300px; height: 35px;" type = "text"
                               placeholder = "Please enter your email address" maxlength = "18" size = "15px"> </td>
                    <td><span id = "email_span2" style = "font-size: 15px;"></span></td>
                </tr>

                <!-- 性别 单选框-->
                <tr>
                    <td><span id = "gender_span1">*</span>Gender:</td>
                    <td style = "font-size: 18px;"> <input id = "Male" onclick = "checkGender(this)" type = "radio"  name="gender" value = "Male" style = "width: 15px; height: 15px;"> Male
                        <input id = "Female" onclick = "checkGender(this)" type = "radio"  name="gender" value = "Female" style = "width: 15px; height: 15px;"> Female  </td>
                </tr>

                <!-- 生日 文本框-->
                <tr>
                    <td><span id = "birthdate_span1">*</span>Date of birth:</td>
                    <td>  <input name = "birthdate" id = "Birthdate" onblur = "checkDate(this)" style = "width: 300px; height: 35px;" type = "text"
                                 placeholder = "Date of birth(yyyy-mm-dd)" maxlength = "18" size = "15px"> </td>
                    <td><span id = "birthdate_span2" style = "font-size: 15px;"></span></td>
                </tr>

                <!-- 注册提交按钮 -->
                <tr>
                    <td><input onclick = "submitList()" style = "width: 130px;height: 46px; font-size: 18px; font-weight: 700; padding-left: 0%;
                    letter-spacing: 2px; background-color: rgba(198,116,2,0.8); color: #fff;" type = "submit" value = "Register"></td>
                </tr>

            </table>

        </div>

    </div>

</form>
<%@include file="footer.jsp"%>


