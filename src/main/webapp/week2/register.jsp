<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/3/3
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LiaoChengxin2020211001001312</title>
    <script>

        //用户名正则：
        var  usernameRegex = /^\w{3,20}$/;
        //密码正则：
        var passwordRegex = /^\w{8,}$/;
        //邮箱正则：
        var emailRegex = /^\w+@\w+(\.\w+)+$/;
        //出生日期正则：
        var birthdateRegex =
            /^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/

        function validateForm(){ //定义validateForm方法用于客户端校验
            var flag = true;
            //校验用户名
            var usernameNode = byId("username"); //获得ID值为username的节点对象
            var username = usernameNode.value;
            if(!usernameRegex.test(username)){    //验证获得到的值是否符合正则表达式
                byId("username_span2").style.color = "#DF1212"; //不符合，相应内容变成红色
                byId("username_span1").style.color = "#DF1212";
                flag = false;        //返回false
            }

            //校验密码
            var passwordNode = byId("password");  //获得ID值为password的节点对象
            var password = passwordNode.value;
            if(!passwordRegex.test(password)){

                byId("password_span2").style.color = "#DF1212"; //不符合，相应内容变成红色
                byId("password_span1").style.color = "#DF1212";
                flag = false;
            }


            //校验邮箱
            var emailNode = byId("Email");  //获得ID值为Email的节点对象
            var email = emailNode.value;
            if(!emailRegex.test(email)){

                byId("email_span2").style.color = "#DF1212"; //不符合，相应内容变成红色
                byId("email_span1").style.color = "#DF1212";
                flag = false;
            }

            var dateNode = byId("Birthdate")
            var birthdate = dateNode.value;  //得到传递过来的节点对象的值
            if(!birthdateRegex.test(birthdate)){  //验证是否符合节点对应的正则表达式
                byId("birthdate_span2").style.color = "#DF1212"; //不符合，相应内容变成红色
                byId("birthdate_span1").style.color = "#DF1212";
                flag = false;
            }

            return flag;
        }

        //判断是否提交成功
        function submitList(){
            if(validateForm()){
                alert("Account registration succeeded！");
            }
            else
                alert("Account registration failed! Registration information error, please check again!");
        }


        function byId(id){  //自定义方法，用于获取传递过来的ID值对应的节点对象
            return document.getElementById(id);
        }

        function checkUsername(node){ //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
            //校验用户名
            var username = node.value;  //得到传递过来的节点对象的值
            if(!usernameRegex.test(username)){  //验证是否符合节点对应的正则表达式
                document.getElementById("username_span2").innerText = "Invalid username! Length: 3-20 characters."
                byId("username_span2").style.color = "#DF1212"; //不符合，相应内容变成红色
                byId("username_span1").style.color = "#DF1212";
            }else{
                document.getElementById("username_span2").innerText = "Available username."
                byId("username_span1").style.color = "green";  //符合，相应内容变成绿色
                byId("username_span2").style.color = "green";
            }
        }

        function checkPassword(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
            var password1 = node.value;
            if (!passwordRegex.test(password1)) {
                document.getElementById("password_span2").innerText = "The password must be at least 8 characters long.";
                byId("password_span1").style.color = "DF1212";
                byId("password_span2").style.color = "DF1212";
            }
            else {
                document.getElementById("password_span2").innerText = "Available password.";
                byId("password_span1").style.color = "green";
                byId("password_span2").style.color = "green";
            }
        }

        function checkRePassword(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
            //确认密码
            var rePassword = node.value;
            var password = byId("password2").value;
            if(!password == rePassword){
                byId("rePassword2_span").style.color = "red";
            }else if(!passwordRegex.test(rePassword)){
                byId("rePassword2_span").style.color = "red";
            }else{
                byId("rePassword2_span").style.color = "green";
            }
        }

        function checkEmail(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
            //校验邮箱
            var email = node.value;
            if(!emailRegex.test(email)){
                document.getElementById("email_span2").innerText = "Invalid email address.";
                byId("email_span1").style.color = "DF1212";
                byId("email_span2").style.color = "DF1212";
            }else{
                document.getElementById("email_span2").innerText = "Valid email address.";
                byId("email_span1").style.color = "green";
                byId("email_span2").style.color = "green";
            }  }

        function checkGender(node){  //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
            //校验性别
            byId("gender_span1").style.color = "green";
            var gender = node.value;
            if(byId("Male").checked && byId("Female").checked)
            {
                if(gender  ==  "Male")
                    byId("Female").checked = false;
                else
                    byId("Male").checked = false;
            }
        }

        function checkDate(node){ //当鼠标离开节点时调用此方法，验证节点内容是否符合注册规范
            //校验日期
            var birthdate = node.value;  //得到传递过来的节点对象的值
            if(!birthdateRegex.test(birthdate)){  //验证是否符合节点对应的正则表达式
                document.getElementById("birthdate_span2").innerText = "Date format error or invalid."
                byId("birthdate_span2").style.color = "#DF1212"; //不符合，相应内容变成红色
                byId("birthdate_span1").style.color = "#DF1212";
            }else{
                document.getElementById("birthdate_span2").innerText = "Valid birthdate."
                byId("birthdate_span1").style.color = "green";  //符合，相应内容变成绿色
                byId("birthdate_span2").style.color = "green";
            }
        }
    </script>
</head>
<style>
    /* 整体布局效果 */
    *{
        padding: 0;
        margin: 0;
    }
    /* 标题 */
    .title{
        height: 100px;
        padding-left: 35%;
        padding-top: 50px;
        font-size: 28px;
        color: rgb(10, 10, 10);
        font-weight: 760;
        font-family: "苹方";

    }
    .user{
        padding-top: 90px;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    /* 表格整体位置调整 */
    .tableDiv{

        width: 1100px;
        height: 560px;
        /*实现透明效果 */
        background-color: rgba(255, 255, 255, 0.5);
        box-shadow: 5px 5px 15px rgba(67, 72, 83, 0.8);
        border-radius: 16px;

    }
    /* 表格字体设置 */
    table{
        font-family: "苹方";
        font-size: 11px;
        color: rgb(56,56,56);
        padding-left: 100px;
    }
    /* 单元格字体设置 */
    td{
        font-size: 20px;
        font-weight: 676;
        font-family: "苹方";
    }
    /* 对input组件样式设置 */
    input{
        font-family: "苹方";
        font-weight: 550;
        font-size: 17px;
        /*实现透明效果 */
        background-color: rgba(192, 192, 192, 0.3);
        border-style: hidden;
        border-radius: 10px;
        outline: none;
        color: rgb(0, 0, 0);
        padding-left: 10px;
    }

    /* 选择样式设置（透明效果） */
    select{
        border-radius: 10px;
        border-style: hidden;
        outline: none;
        /*实现透明效果 */
        background-color:rgba(239,239,232, 0.3);
        color: #f1f1f1;
        font-family: "苹方";
        font-weight:  600;
        font-size: 17px;
    }

    span{
        color: rgb(223, 18, 18);
    }
    /* 对未输入内容时的文字颜色设置 */
    input::-webkit-input-placeholder{
        color: #b9b6b6;
    }
    textarea::-webkit-input-placeholder{
        color: #b9b6b6;
    }
</style>
<body style = "background-color: rgb(225,223,212)">
<!-- 表单 -->
<form method="post" action="/register">
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
</body>
</html>


