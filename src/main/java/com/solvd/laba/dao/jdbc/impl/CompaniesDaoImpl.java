package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Companies;
import com.solvd.laba.dao.interfaces.CompaniesDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompaniesDaoImpl extends AbstractDAO implements CompaniesDAO {

    private static Logger LOGGER = LogManager.getLogger(CompaniesDaoImpl.class);

    private static String GET_COMPANY_BY_ID_Q = "SELECT * FROM Company WHERE id = ?";


    @Override
    public void save(Companies companies) {

    }

    @Override
    public void delete(Companies companies) {

    }

    @Override
    public Companies getById(long id) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            Connection connection = connectionPool.getConnection();
            stmt = connection.prepareStatement(GET_COMPANY_BY_ID_Q);
            stmt.setLong(1,id);

            ResultSet resultSet = stmt.executeUpdate();

            if (resultSet.next()){
                Companies companies = new Companies();
                companies.setName(resultSet.getString(1));
                return companies;
            } else {
                throw new RuntimeException("");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
