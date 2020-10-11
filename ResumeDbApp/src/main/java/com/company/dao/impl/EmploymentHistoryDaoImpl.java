package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eminov
 */
public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {

    private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception {
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        int userId = rs.getInt("user_id");

        EmploymentHistory emp = new EmploymentHistory(null, header, beginDate, endDate, jobDescription, new User(userId));
        return emp;
    }

    @Override
    public List<EmploymentHistory> getAllEmploymentHistory() {
        List<EmploymentHistory> result = new ArrayList<>();
        try (
                Connection c = connect()) {

            Statement stmt = c.createStatement();
            stmt.execute("select * from employment_history ");

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                EmploymentHistory emp = getEmploymentHistory(rs);
                result.add(emp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insertEmploymentHistory(EmploymentHistory s) {
        try (
                Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("insert into employment_history(header,begin_date,end_date,job_description) values(?,?,?,?)");
            stmt.setString(1, s.getHeader());
            stmt.setDate(2, s.getBeginDate());
            stmt.setDate(3, s.getEndDate());
            stmt.setString(4, s.getJobDescription());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEmploymentHistory(EmploymentHistory u) {
        try (
                Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("update employment_history set header=? , begin_date=? , end_date=? , job_description=? where id=?");
            stmt.setString(1, u.getHeader());
            stmt.setDate(2, u.getBeginDate());
            stmt.setDate(3, u.getEndDate());
            stmt.setString(4, u.getJobDescription());
            stmt.setInt(5, u.getUser().getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public EmploymentHistory getAllEmploymentHistoryByUserId(int userId) {
        EmploymentHistory result = null;
        try (
                Connection c = connect()) {

            PreparedStatement stmt = c.prepareStatement("select * from employment_history where user_id = ?");
            stmt.setInt(1, userId);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = getEmploymentHistory(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
