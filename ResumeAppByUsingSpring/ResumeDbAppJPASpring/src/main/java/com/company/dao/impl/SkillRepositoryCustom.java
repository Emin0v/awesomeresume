/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.Skill;

import java.util.List;

/**
 *
 * @author User
 */
public interface SkillRepositoryCustom {
    
    public List<Skill> getAll();
    
    public boolean insertSkill(Skill s);
    
    public Skill getById(int id);
    
    boolean updateSkill(Skill u);
    
    boolean removeSkill(int id);
    
   
}
