/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eminov
 */
public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter{

    private Country getCountry(ResultSet rs)throws Exception{
          int id = rs.getInt("id");
          String name = rs.getString("name");
          String nationality = rs.getString("nationality");
          
          Country c = new Country(id, name, nationality);
          return c;
          
    }
    
    @Override
    public List<Country> getAll() {
        List<Country> result = new ArrayList<>();
        
        try(Connection c = connect()){
            Statement stmt = c.createStatement();
            stmt.execute("select * from country");
            ResultSet rs = stmt.getResultSet();
            
            while(rs.next()){
                Country country = getCountry(rs);
                result.add(country);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public Country getById(int id) {
        Country country = null;
        try(Connection c = connect()){
            Statement stmt = c.createStatement();
            stmt.execute("select * from country where id="+id);
            ResultSet rs = stmt.getResultSet();
            
            while(rs.next()){
                country = getCountry(rs);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return country;
    }

    @Override
    public boolean updateCountry(Country c) {
        try(Connection cn = connect()){
            PreparedStatement stmt = cn.prepareStatement("update country set name=? , nationality=? where id=?");
            stmt.setString(1, c.getName());
            stmt.setString(2, c.getNationality());
            stmt.setInt(3, c.getId());
            
            return stmt.execute();
            
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCountry(int id) {
        try(Connection c = connect()){
            Statement stmt = c.createStatement();
            return stmt.execute("delete from country where id="+id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
}
