/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author User
 */
@Repository("skillDao")
public class SkillRepositoryCustomImpl extends AbstractDAO implements SkillRepositoryCustom {

    @Autowired
    EntityManager em;

    @Override
    public List<Skill> getAll() {
        String jpql = "select s from Skill s";
        Query q = em.createQuery(jpql, Skill.class);
        return q.getResultList();
    }

    @Override
    public Skill getById(int id) {
        Query q = em.createQuery("select s from Skill s where s.id=:i", Skill.class);
        q.setParameter("i", id);
        List<Skill> list = q.getResultList();
        return list.get(0);
    }

    @Override
    public boolean updateSkill(Skill u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeSkill(int id) {
        Skill s = em.find(Skill.class,id);
        em.remove(s);
        return true;
    }

    @Override
    public boolean insertSkill(Skill s) {
        em.persist(s);
        return true;
    }

}
