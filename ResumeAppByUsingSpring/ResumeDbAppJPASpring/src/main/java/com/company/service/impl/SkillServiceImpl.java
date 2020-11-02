/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.dao.impl.SkillRepositoryCustom;
import com.company.entity.Skill;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author User
 */
@Service
@Transactional
public class SkillServiceImpl implements SkillServiceInter {

    @Autowired
    @Qualifier("skillDao")
    SkillRepositoryCustom skillDao;

    @Override
    public List<Skill> getAll() {
        return skillDao.getAll();
    }

    @Override
    public Skill getById(int id) {
        return skillDao.getById(id);
    }

    @Override
    public boolean updateSkill(Skill u) {
        return skillDao.updateSkill(u);
    }

    @Override
    public boolean removeSkill(int id) {
        return skillDao.removeSkill(id);
    }

    @Override
    public boolean insertSkill(Skill s) {
        return skillDao.insertSkill(s);
    }
}
