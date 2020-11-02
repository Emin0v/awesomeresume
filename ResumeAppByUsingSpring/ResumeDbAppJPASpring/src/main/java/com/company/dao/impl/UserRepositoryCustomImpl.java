/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author User
 */
@Repository("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em ;

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
         String jpql="select u from User u where 1=1";

            if (name != null && !name.trim().isEmpty()) {
                jpql += " and u.name=:name ";
            }

            if (surname != null && !surname.trim().isEmpty()) {
                jpql += " and u.surname=:surname ";
            }

            if (nationalityId != null) {
                jpql += " and u.nationality.id=:nid ";
            }
               
           
             Query q = em.createQuery(jpql, User.class);
             
            if (name != null && !name.trim().isEmpty()) {
               q.setParameter("name", name);
            }

            if (surname != null && !surname.trim().isEmpty()) {
                q.setParameter("surname", surname);
            }

            if (nationalityId != null) {
                q.setParameter("nid", nationalityId);
            }
        return q.getResultList();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query q = em.createQuery("select u from User u where u.email=:e and u.password=:p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);
        
        List<User> list = q.getResultList();
        if(list.size()==1){
            return list.get(0);
        }
        return null ;
    }

    @Override
    public User findByEmail(String email) {
        Query q = em.createQuery("select u from User u where u.email=:e", User.class);
        q.setParameter("e", email);
        
        List<User> list = q.getResultList();
        if(list.size()==1){
            return list.get(0);
        }
        return null ;
    }
    
    //  CriteriaBuilder
//    public User findByEmail(String email) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        Root<User> postRoot = q1.from(User.class);
//        
//        CriteriaQuery q2 = q1
//                .where(cb.equal(postRoot.get("email"), email));
//                
//        Query q = em.createQuery(q2);
//        List<User> list = q.getResultList();
//        if(list.size()==1){
//            return list.get(0);
//        }
//        return null ;
//    }

    @Override
    public User getById(int UserId) {
        User u = em.find(User.class, UserId);
        return u;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    public static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        em.persist(u);
        return true;
    }

}
