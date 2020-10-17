package com.company.resume.util;

import javax.servlet.http.HttpServletResponse;

public class ControllerUtil {
    public static void errorPage(HttpServletResponse response , Exception ex) {
        try {
            ex.printStackTrace();
            response.sendRedirect("error?msg=" + ex.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
