/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.impl;

import com.company.dao.impl.UserSkillRepositoryCustom;
import com.company.entity.UserSkill;
import com.company.service.inter.UserSkillServiceInter;
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
public class UserSkillServiceImpl implements UserSkillServiceInter {

    @Autowired
    @Qualifier("userSkill")
    UserSkillRepositoryCustom userSkill;

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        return userSkill.getAllSkillByUserId(userId);
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        return userSkill.updateUserSkill(u);
    }

    @Override
    public boolean removeUserSkill(int id) {
        return userSkill.removeUserSkill(id);
    }

    @Override
    public boolean insertUSerSkill(UserSkill u) {
        return userSkill.insertUSerSkill(u);

    }
}