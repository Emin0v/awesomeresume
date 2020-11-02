package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<User,Integer>, CountryRepositoryCustom {


}
