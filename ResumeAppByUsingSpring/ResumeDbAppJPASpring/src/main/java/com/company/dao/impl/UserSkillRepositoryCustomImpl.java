/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.UserSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 */
@Service("userSkill")
@Transactional
public class UserSkillRepositoryCustomImpl implements UserSkillRepositoryCustom {

    @Autowired
    EntityManager em;

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {

        String jpql = "select us from UserSkill us where us.user.id =:id";
        Query q = em.createQuery(jpql, UserSkill.class);
        q.setParameter("id", userId);

        return q.getResultList();
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        UserSkill s = em.find(UserSkill.class, id);
        em.remove(s);
        return true;
    }

    @Override
    public boolean insertUSerSkill(UserSkill u) {
        em.persist(u);
        return true;
    }

}
