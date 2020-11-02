package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmploymentHistoryRepository extends JpaRepository<User,Integer>, EmploymentHistoryRepositoryCustom {

}
