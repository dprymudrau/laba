package com.solvd.laba.dao.jdbc.realisation;

import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfaces.IMyDAO;
import com.solvd.laba.poJo.Emploee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyDAO extends AbstractDAO implements IMyDAO {

    @Override
    public Emploee getByID(int ID) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //closing resources
        }
    return null;//?
    }
}
