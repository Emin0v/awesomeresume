package com.company.dao.impl;

import com.company.entity.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSkillRepository extends JpaRepository<UserSkill,Integer>, UserSkillRepositoryCustom {

}
