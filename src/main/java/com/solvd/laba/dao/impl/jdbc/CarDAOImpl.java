package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.service.EntityDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDAOImpl extends AbstractDAO<Car> implements EntityDAO<Car, Integer> {
    private String query;
    Connection connection = getConnection();
    PreparedStatement prepStatement;
    ResultSet resultSet;

    private static final Logger LOGGER = LogManager.getLogger(CarDAOImpl.class);

    @Override
    public void executeQuery(String query) {
        this.query = query;
    }

    @Override
    public void printAll() {
        query = "SELECT * FROM Cars";
        try {
            prepStatement = connection.prepareStatement(query);
            resultSet = prepStatement.executeQuery();
            LOGGER.info("Cars:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idCar");
                String brandName = resultSet.getString("carBrandName");
                String model = resultSet.getString("carModel");
                String regNumber = resultSet.getString("carRegNumber");
                int idCarFleet = resultSet.getInt("idCarFleet");
                LOGGER.info("id -> " + id +
                        ", brand name -> " + brandName +
                        ", model -> " + model +
                        ", registration number -> " + regNumber +
                        ", id CarFleet -> " + idCarFleet);
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                resultSet.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void printByFilter(String pastWhereOperatorCondition) {
        query = "SELECT * FROM Cars WHERE ";
        try {
            prepStatement = connection.prepareStatement(query + pastWhereOperatorCondition);
            resultSet = prepStatement.executeQuery();
            LOGGER.info("Cars:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idCar");
                String brandName = resultSet.getString("carBrandName");
                String model = resultSet.getString("carModel");
                String regNumber = resultSet.getString("carRegNumber");
                int idCarFleet = resultSet.getInt("idCarFleet");
                LOGGER.info("id -> " + id +
                        ", brand name -> " + brandName +
                        ", model -> " + model +
                        ", registration number -> " + regNumber +
                        ", id CarFleet -> " + idCarFleet);
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                resultSet.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public ArrayList<Car> getAll() {
        query = "SELECT * FROM Cars";
        ArrayList<Car> cars = new ArrayList<>();
        try {
            prepStatement = connection.prepareStatement(query);
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idCar");
                String brandName = resultSet.getString("carBrandName");
                String model = resultSet.getString("carModel");
                String regNumber = resultSet.getString("carRegNumber");
                int idCarFleet = resultSet.getInt("idCarFleet");
                Car car = new Car(id, brandName, model, regNumber, idCarFleet);
                cars.add(car);
                LOGGER.debug(car + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                resultSet.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        return cars;
    }

    @Override
    public ArrayList<Car> getAllWithFilter(String condition) {
        query = "SELECT * FROM Cars WHERE ";
        ArrayList<Car> cars = new ArrayList<>();
        try {
            prepStatement = connection.prepareStatement(query + condition);
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idCar");
                String brandName = resultSet.getString("carBrandName");
                String model = resultSet.getString("carModel");
                String regNumber = resultSet.getString("carRegNumber");
                int idCarFleet = resultSet.getInt("idCarFleet");
                Car car = new Car(id, brandName, model, regNumber, idCarFleet);
                cars.add(car);
                LOGGER.debug(car + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                resultSet.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        return cars;
    }

    @Override
    public Car getById(Integer id) {
        query = "SELECT idCar, carBrandName, carModel, carRegNumber, idCarFleet FROM Cars WHERE idCar = ?";
        Car car = new Car();
        try {
            prepStatement = connection.prepareStatement(query);
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                car.setId(resultSet.getInt("idCar"));
                car.setBrandName(resultSet.getString("carBrandName"));
                car.setModel(resultSet.getString("carModel"));
                car.setRegNumber(resultSet.getString("carRegNumber"));
                car.setIdCarFleet(resultSet.getInt("idCarFleet"));
                LOGGER.debug(car + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                resultSet.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
        return car;
    }

    @Override
    public void insertToTable(Car entity) {
        query = "INSERT INTO Cars(carBrandName, carModel, carRegNumber, idCarFleet) VALUES (?, ?, ?, ?)";
        try {
            prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, entity.getBrandName());
            prepStatement.setString(2, entity.getModel());
            prepStatement.setString(3, entity.getRegNumber());
            prepStatement.setInt(4, entity.getIdCarFleet());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Cars table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    public void insertToTable(String carBrandName, String carModel, String carRegNumber, int idCarFleet) {
        query = "INSERT INTO Cars(carBrandName, carModel, carRegNumber, idCarFleet) VALUES (?, ?, ?, ?)";
        try {
            prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, carBrandName);
            prepStatement.setString(2, carModel);
            prepStatement.setString(3, carRegNumber);
            prepStatement.setInt(4, idCarFleet);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Cars table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void updateEntityRow(Car entity) {
        query = "UPDATE Cars SET carBrandName = ?, carModel = ?, carRegNumber = ?, idCarFleet = ? WHERE idCar = ?";
        try {
            prepStatement = connection.prepareStatement(query);
            prepStatement.setString(1, entity.getBrandName());
            prepStatement.setString(2, entity.getModel());
            prepStatement.setString(3, entity.getRegNumber());
            prepStatement.setInt(4, entity.getIdCarFleet());
            prepStatement.setInt(5, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in Cars table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        query = "DELETE FROM Cars WHERE idCar = ?";
        try {
            prepStatement = connection.prepareStatement(query);
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in Cars table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }

    public void deleteAllByFilter(String condition) {
        query = "DELETE FROM Cars WHERE idCar IN (SELECT idCar FROM Cars WHERE ";
        try {
            prepStatement = connection.prepareStatement(query + condition + ")");
            prepStatement.setString(1, condition);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in Cars table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            try {
                prepStatement.close();
                releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e);
            }
        }
    }
}
