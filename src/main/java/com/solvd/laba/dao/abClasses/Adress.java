package com.solvd.laba.dao.abClasses;

import com.solvd.laba.Main;
import com.solvd.laba.dao.interfaces.generics.IEntityDAO;
import com.solvd.laba.dao.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.solvd.laba.dao.pool.ConnectionPool.getInstance;

public abstract class Adress implements IEntityDAO {
    private static final Logger LOGGER = LogManager.getLogger(Adress.class);

    public static class getSmth {
        ConnectionPool connectionPool = getInstance();
        Connection conName;

        {
            try {
                conName = connectionPool.getConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        Statement statement;

        {
            try {
                statement = conName.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        ResultSet resultSet;

        {
            try {
                resultSet = statement.executeQuery("SELECT * FROM Adress");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String adress = resultSet.getString(2);
                    LOGGER.info("id = "+id);
                    LOGGER.info("adress = "+adress);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }


}
