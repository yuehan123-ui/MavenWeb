package com.ztbu.web;

import com.ztbu.pojo.User;
import com.ztbu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/LogininServlet")
public class LogininServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获取复选框的值 ：1   判断用户是否选择记住此账号
        String remembrer = request.getParameter("remember");
        //2. 调用service查询
        User user = service.login(username, password);

        //3. 判断
        if(user != null){
            //登录成功，跳转到查询所有的BrandServlet

            //将登陆成功后的user对象，存储到session
            if ("1".equals(remembrer)){
                Cookie user_namecookie = new Cookie("username",username);
                Cookie user_passwordcookie = new Cookie("password",password);
                user_namecookie.setMaxAge(60*3);
                user_passwordcookie.setMaxAge(60*3);

                //发送cookie
                response.addCookie(user_namecookie);
                response.addCookie(user_passwordcookie);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath+"/selectAllServlet");
        }else {
            // 登录失败,
            // 存储错误信息到request
            request.setAttribute("login_msg", "用户名或密码错误");
            // 跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
