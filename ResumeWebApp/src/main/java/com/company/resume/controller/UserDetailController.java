/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.controller;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author User
 */
@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    private UserDaoInter userDao = Context.instanceUserDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    CountryDaoInter countryDao = Context.instanceCountryDao();
    List<Country> countryList = countryDao.getAll();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.valueOf(request.getParameter("id"));
            String action = request.getParameter("action");
            if (action.equals("update")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");

                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String birthdate = request.getParameter("birthdate");
                Date dt = null;
                if (birthdate != null && !birthdate.trim().isEmpty()) {
                    dt = new Date(sdf.parse(birthdate).getTime());
                }


                User user = userDao.getById(id);
                user.setName(name);
                user.setSurname(surname);

                user.setAddress(address);
                user.setPhone(phone);
                user.setEmail(email);
                user.setBirthDate(dt);

                String country = request.getParameter("country");
                for (Country c : countryList) {
                        if ((c.toString()).equals(country)) {
                                user.setBirthplace(c);
                        }
                }

                userDao.updateUser(user);

            } else if (action.equals("delete")) {
                userDao.removeUser(id);
            }
            response.sendRedirect("users");
        } catch (ParseException ex) {
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
            request.getRequestDispatcher("userdetail.jsp").forward(request, response);

        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }
    }
}
