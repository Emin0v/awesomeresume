package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<User,Integer>, SkillRepositoryCustom {

}
