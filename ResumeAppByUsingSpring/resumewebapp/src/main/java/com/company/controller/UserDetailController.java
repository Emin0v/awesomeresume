package com.company.controller;


import com.company.entity.Country;
import com.company.entity.User;
import com.company.form.UserDetailForm;
import com.company.service.inter.CountryServiceInter;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UserDetailController {

    @Autowired
    private UserServiceInter userService;

    @Autowired
    private CountryServiceInter countryService;

    private User u = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(method = RequestMethod.POST, value = "/userdetail")//1
    public ModelAndView index(@ModelAttribute("userdetail") UserDetailForm ud, HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("userdetail geldi");
            u = userService.getById(ud.getId());
            ModelAndView mv = new ModelAndView("userdetail");

            u.setName(ud.getName());
            u.setSurname(ud.getSurname());
            u.setAddress(ud.getAddress());
            u.setPhone(ud.getPhone());
            u.setEmail(ud.getEmail());
            String birthdate = ud.getBirthdate();
            Date dt = null;
            if (birthdate != null && !birthdate.trim().isEmpty()) {
                dt = new Date(sdf.parse(birthdate).getTime());
            }
            u.setBirthdate(dt);

            List<Country> countryList =  countryService.getAll();

            String country = ud.getBirthplace();
            System.out.println("country="+country);

            for (Country c : countryList) {
                if ((c.toString()).equals(country)) {
                    System.out.println("add olundu="+c);
                    u.setBirthplace(c);
                }
            }

            userService.updateUser(u);

            mv.addObject("country", countryList);
            mv.addObject("user" , u);

            String answer = request.getParameter("action");
            if (answer != null) {
                if (answer.equals("save")) {
                    response.sendRedirect("users");
                }
            }

            return mv;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @ModelAttribute("userdetail")
    public UserDetailForm getEmptyUserDetailForm(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        u = userService.getById(id);
        System.out.println("Birthplace="+u.getBirthplace());
        return new UserDetailForm(null, u.getName(), u.getSurname(), u.getAddress(), u.getPhone(), u.getEmail(), u.getBirthdate().toString(), u.getBirthplace().toString());
    }
}
