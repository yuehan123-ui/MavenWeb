package com.ztbu.web.fitter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "loginFilter")
public class loginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);//放行



    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
