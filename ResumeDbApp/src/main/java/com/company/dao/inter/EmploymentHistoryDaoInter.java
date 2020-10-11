/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.EmploymentHistory;
import com.company.entity.Skill;
import java.util.List;

/**
 *
 * @author Eminov
 */
public interface EmploymentHistoryDaoInter {

    public List<EmploymentHistory> getAllEmploymentHistory();
    
    public boolean insertEmploymentHistory(EmploymentHistory s);
    
    boolean updateEmploymentHistory(EmploymentHistory u);
    
   public EmploymentHistory getAllEmploymentHistoryByUserId(int userId);
    
}
