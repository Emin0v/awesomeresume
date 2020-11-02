/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author User
 */

@Repository("countryDao")
public class CountryRepositoryCustomImpl implements CountryRepositoryCustom {

    @Autowired
    EntityManager em;

    @Override
    public List<Country> getAll() {
        String jpql = "select c from Country c ";
        Query q = em.createQuery(jpql, Country.class);
        return q.getResultList();

    }

    @Override
    public Country getById(int id) {
        Country c = em.find(Country.class, id);
        return c;
    }

    @Override
    public boolean updateCountry(Country u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeCountry(int id) {
        Country c = em.find(Country.class, id);
        em.remove(c);
        return true;
    }

}
