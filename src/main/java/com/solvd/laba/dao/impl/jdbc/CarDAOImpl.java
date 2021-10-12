package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.dao.EntityDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarDAOImpl extends AbstractDAO implements EntityDAO<Car, Integer> {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Cars";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM Cars WHERE ";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM Cars WHERE idCar = ?";
    private static final String INSERT_NEW_CAR_QUERY = "INSERT INTO Cars(idCar, carBrandName, carModel, carRegNumber, idCarFleet) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_CAR_QUERY = "INSERT INTO Cars(carBrandName, carModel, carRegNumber, idCarFleet) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CAR_QUERY = "UPDATE Cars SET carBrandName = ?, carModel = ?, carRegNumber = ?, idCarFleet = ? WHERE idCar = ?";
    private static final String DELETE_CAR_BY_ID_QUERY = "DELETE FROM Cars WHERE idCar = ?";
    private static final String DELETE_CAR_WITH_CONDITION_QUERY = "DELETE FROM Cars WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(CarDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
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
            closeResource(resultSet);
            releaseConnection(connection);
        }
    }

    @Override
    public void printByFilter(String pastWhereOperatorCondition) {
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
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
            closeResource(resultSet);
            releaseConnection(connection);
        }
    }

    @Override
    public ArrayList<Car> getAll() {
        ArrayList<Car> cars = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
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
            LOGGER.info("Total amount of values: " + cars.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return cars;
    }

    @Override
    public ArrayList<Car> getAllWithFilter(String pastWhereOperatorCondition) {
        ArrayList<Car> cars = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
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
            LOGGER.info("Found values by condition: " + cars.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return cars;
    }

    @Override
    public Car getById(Integer id) {
        Car car = new Car();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
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
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return car;
    }

    @Override
    public void insertToTable(Car entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_CAR_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setString(2, entity.getBrandName());
            prepStatement.setString(3, entity.getModel());
            prepStatement.setString(4, entity.getRegNumber());
            prepStatement.setInt(5, entity.getIdCarFleet());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Cars table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(String carBrandName, String carModel, String carRegNumber, int idCarFleet) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_CAR_QUERY)) {
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
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(Car entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_CAR_QUERY)) {
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
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_CAR_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in Cars table.");
            } else {
                LOGGER.info("There is no car with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteByFilter(String pastWhereOperatorCondition) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_CAR_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in Cars table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }
}
