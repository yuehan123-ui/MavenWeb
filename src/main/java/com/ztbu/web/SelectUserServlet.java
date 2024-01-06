package com.ztbu.web;

import com.ztbu.pojo.User;
import com.ztbu.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收用户名
        String username = request.getParameter("username");

        //2. 调用service查询User对象，此处不进行业务逻辑处理，直接给 flag 赋值为 true，表明用户名占用
        User user = service.selectByUsername(username);
        boolean flag = true;
        if (user!=null){
            response.getWriter().write("" + flag);
        }else {
            flag = false;
            response.getWriter().write("" + flag);
        }
        //3. 响应标记
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
