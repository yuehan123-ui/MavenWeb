<%--
  Created by IntelliJ IDEA.
  User: 王政翔
  Date: 2022/12/12
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>login</title>
  <link href="css/login.css" rel="stylesheet">
</head>

<body>

<div id="loginDiv" style="height: 350px">
  <form action="/MavenWeb/LogininServlet" method="post" id="form">
    <h1 id="loginMsg">LOGIN IN</h1>
    <div id="errorMsg">${login_msg}${register_msg}</div>
    <%--页面中获取cookie的值     cookie.key.value   key ： 键的名称--%>
    <p>Username:<input id="username" name="username" value="${cookie.username.value}" type="text"></p>
    <p>Password:<input id="password" name="password" value="${cookie.password.value}" type="password"></p>
    <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
    <div id="subDiv">
      <input type="submit" class="button" value="login up">
      <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
      <a href="register.jsp">没有账号？</a>
    </div>
  </form>
</div>
</body>
</html>
