<%--
  Created by IntelliJ IDEA.
  User: 廖承心
  Date: 2022/6/1
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<script type="text/javascript">
    function checkFromVal(Node){
        var val1 = document.getElementById("firstVal").value;
        var val2 = document.getElementById("secondVal").value;

        if(!/^[0-9]+$/.test(val1)){
            alert("First Value is not a number!");
        }
        else if(!/^[0-9]+$/.test(val2)){
            alert("Second Value is not a number!");
        }
        else{
            Node.type = "hidden";
            document.getElementById("myForm").submit();
        }
    }

    function checkFromName(Node){
        var name = document.getElementById("name").value;
        if(!/^(?!\d+$)[\da-zA-Z]+$/.test(name)){
            alert("Name is valid!");
        }
        else{
            Node.type = "hidden";
            document.getElementById("myForm").submit();
        }
    }

</script>

<form id="myForm" action="CalServlet" method="post">

    <table cellspacing="20px">
        <tr>
            <td>First val :<input name="firstVal" id="firstVal" type="text" value="${cookie.cFirstVal.value}"></td>
            <td>Enter a name :<input name="name" id="name" type="text" value="${cookie.cName.value}"></td>
        </tr>
        <tr>
            <td>Second val :<input name="secondVal" id="secondVal" type="text" value="${cookie.cSecondVal.value}"></td>
            <td>Length :<input name="length" type="text" value="${cookie.cLength.value}"></td>
        </tr>
        <tr>
            <td>Result :<input name="result" type="text" value="${cookie.cResult.value}"></td>
        </tr>
    </table>
    <input name="action" type="button" value="Add" onclick="checkFromVal(this)"/>
    <input name="action" type="button" value="Subtract" onclick="checkFromVal(this)"/>
    <input name="action" type="button" value="Multiply" onclick="checkFromVal(this)"/>
    <input name="action" type="button" value="Divide" onclick="checkFromVal(this)"/>
    <input name="action" type="button" value="ComputeLength" onclick="checkFromName(this)"/>
    <input name="reset" type="reset" value="Reset" id="reset"/>
</form>
</body>
</html>

