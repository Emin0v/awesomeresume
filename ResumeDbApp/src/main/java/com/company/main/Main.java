/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.inter.CountryDaoInter;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.Country;

/**
 *
 * @author Eminov
 */
public class Main {

    public static void main(String[] args) {

        CountryDaoInter c = Context.instanceCountryDao();
        Country con = c.getById(1);
        con.setName("AZERBAIJAN");
        c.updateCountry(con);

    }
}
