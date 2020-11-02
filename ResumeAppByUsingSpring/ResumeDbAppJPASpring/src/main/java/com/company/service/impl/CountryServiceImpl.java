/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.dao.impl.CountryRepositoryCustom;
import com.company.entity.Country;
import com.company.service.inter.CountryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @author User
 */
@Service
@Transactional
public class CountryServiceImpl implements CountryServiceInter {

    @Autowired
    @Qualifier("countryDao")
    CountryRepositoryCustom countryDao;

    @Override
    public List<Country> getAll() {
        return countryDao.getAll();

    }

    @Override
    public Country getById(int id) {
        return countryDao.getById(id);
    }

    @Override
    public boolean updateCountry(Country u) {
        return countryDao.updateCountry(u);
    }

    @Override
    public boolean removeCountry(int id) {
        return countryDao.removeCountry(id);
    }

}
