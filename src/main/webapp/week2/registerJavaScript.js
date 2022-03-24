
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