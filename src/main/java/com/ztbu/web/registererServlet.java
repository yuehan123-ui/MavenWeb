package com.ztbu.web;

import com.ztbu.pojo.User;
import com.ztbu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/registererServlet")
public class registererServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1. 获取用户名和密码数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取用户输入De 验证码
        String checkcode = request.getParameter("checkCode");

        //获取存入session的正确验证码
        HttpSession session = request.getSession();
        String checkcodeGen = (String) session.getAttribute("checkCodeGen");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (!checkcode.equalsIgnoreCase(checkcodeGen)){
            //如果不相同  注册失败
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);

            return; //强制退出    不进行下面的代码
        }
        //2. 调用service 注册
        boolean flag = service.register(user);
        //3. 判断注册成功与否
        if(flag){

            //注册功能，跳转登陆页面
/*            request.setAttribute("register_msg","注册成功，请登录");*/
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            //注册失败，跳转到注册页面

/*            request.setAttribute("register_msg","用户名已存在");*/
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
