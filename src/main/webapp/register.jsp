<%--
  Created by IntelliJ IDEA.
  User: 王政翔
  Date: 2022/12/12
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>欢迎注册</title>
  <link href="css/register.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
  <div class="reg-content">
    <h1>欢迎注册</h1>
    <span>已有帐号？</span> <a href="login.jsp">登录</a>
  </div>
  <form id="reg-form" action="/MavenWeb/registererServlet" method="post">
    <table>
      <tr>
        <td>用户名</td>
        <td class="inputs">
          <input name="username" type="text" id="username">
          <br>
          <span id="username_err" class="err_msg" style="display:none">${register_msg}</span>
        </td>
      </tr>
      <tr>
        <td>密码</td>
        <td class="inputs">
          <input name="password" type="password" id="password">
          <br>
          <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
        </td>
      </tr>
      <tr>
        <td>验证码</td>
        <td class="inputs">
          <input name="checkCode" type="text" id="checkCode">
          <img id="checkCodeImg" src="checkcodeServlet">
          <a href="#" id="changeImg" >看不清？</a>
        </td>
      </tr>
    </table>
    <div class="buttons">
      <input value="注 册" type="submit" id="reg_btn">
    </div>
    <br class="clear">
  </form>
</div>

<script>
  document.getElementById("changeImg").onclick = function () {
    //路径后面添加时间戳的目的是避免浏览器进行缓存静态资源
    //重新设置一个值(刷新验证码)
    document.getElementById("checkCodeImg").src = "checkcodeServlet?"+new Date().getMilliseconds();//获取时间毫秒值
  }
</script>
</body>
</html>