/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.UserSkill;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author User
 */
public interface UserSkillRepositoryCustom {
    
    public List<UserSkill> getAllSkillByUserId(int userId);
    
    public boolean insertUSerSkill(UserSkill u);
    
    public boolean updateUserSkill(UserSkill u);
    
    public boolean removeUserSkill(int id);
    
   
}
