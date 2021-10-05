package com.solvd.laba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class TestDataBase {
    private Connection connection;
    private static PreparedStatement prepStatement;
    private static ResultSet resultSet;
    private String query;

    private static final Logger LOGGER = LogManager.getLogger(TestDataBase.class);

    @BeforeClass
    public void getConnection() {
        String databaseURL = "jdbc:mysql://localhost:3306/HospitalsDB";
        String username = "root";
        String password = "MySQLSolvdLaba2564";
        connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            LOGGER.info("Connecting to Database...");
            connection = DriverManager.getConnection(databaseURL, username, password);
            if (connection != null) {
                LOGGER.info("Connected to Database.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error(e);
        }
    }

    @Test
    public void getAll() {
        try {
            query = "SELECT * FROM Cars";
            prepStatement = connection.prepareStatement(query);
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int idCar = resultSet.getInt("idCar");
                String brandName = resultSet.getString("carBrandName");
                String model = resultSet.getString("carModel");
                String regNumber = resultSet.getString("carRegNumber");
                int idCarFleet = resultSet.getInt("idCarFleet");
                LOGGER.info(idCar + "\t" + brandName + "\t" + model + "\t" + regNumber + "\t" + idCarFleet);
            }
        } catch (SQLException e) {

        }
    }
}
