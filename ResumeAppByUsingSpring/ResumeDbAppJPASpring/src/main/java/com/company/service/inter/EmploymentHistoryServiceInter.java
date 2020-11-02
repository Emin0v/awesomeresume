/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

/**
 *
 * @author User
 */
public interface EmploymentHistoryServiceInter {

    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId);

}
