/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.controller;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author User
 */
@WebServlet(name = "UserInfoController", urlPatterns = {"/userinfo"})
public class UserInfoController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    CountryDaoInter countryDao = Context.instanceCountryDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
              String action = request.getParameter("action");
              if(action.equals("back")) {
                  response.sendRedirect("users");
              }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {
//                request.setAttribute("msg", "specify id");
                throw new IllegalArgumentException("id is not specified ");
            }
            Integer userId = Integer.parseInt(userIdStr);

            UserDaoInter userDao = Context.instanceUserDao();
            User u = userDao.getById(userId);
            if (u == null) {
                throw new IllegalArgumentException("There is no user with this id");
            }
            //   request.setAttribute("owner",true);
            request.setAttribute("user", u);
            request.getRequestDispatcher("userinfo.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }
    }
}
