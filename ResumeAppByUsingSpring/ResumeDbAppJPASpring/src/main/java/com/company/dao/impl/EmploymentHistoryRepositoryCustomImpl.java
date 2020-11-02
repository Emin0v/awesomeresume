
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.entity.EmploymentHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author User
 */
@Repository("employHistory")
public class EmploymentHistoryRepositoryCustomImpl extends AbstractDAO implements EmploymentHistoryRepositoryCustom {

    @Autowired
    EntityManager em ;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {

        String jpql = "select e from EmploymentHistory e where e.user_id=:id";
        Query q = em.createQuery(jpql,EmploymentHistory.class);
        q.setParameter("id", userId);

        return q.getResultList();
    }


}
