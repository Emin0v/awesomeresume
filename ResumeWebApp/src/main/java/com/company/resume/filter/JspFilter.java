package com.company.resume.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName ="JSPFileFilter" , urlPatterns = {"*.jsp"})
public class JspFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) {

        HttpServletResponse res = (HttpServletResponse) response;
        try {
                res.sendRedirect("error?msg=not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}