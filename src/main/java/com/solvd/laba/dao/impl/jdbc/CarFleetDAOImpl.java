package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.CarFleet;
import com.solvd.laba.dao.interfaces.ICarFleetDAO;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarFleetDAOImpl extends AbstractDAO implements ICarFleetDAO {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CarFleets";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM CarFleets WHERE ";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM CarFleets WHERE idCarFleet = ?";
    private static final String INSERT_NEW_CAR_FLEET_QUERY = "INSERT INTO CarFleets(idCarFleet, capacityByCars) VALUES (?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_CAR_QUERY = "INSERT INTO CarFleets(capacityByCars) VALUES (?)";
    private static final String UPDATE_CAR_FLEET_QUERY = "UPDATE CarFleets SET capacityByCars = ? WHERE idCar = ?";
    private static final String DELETE_CAR_FLEET_BY_ID_QUERY = "DELETE FROM CarFleets WHERE idCarFleet = ?";
    private static final String DELETE_CAR_FLEET_WITH_CONDITION_QUERY = "DELETE FROM CarFleets WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(CarFleetDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("CarFleets:");

            while (resultSet.next()) {
                int idCarFleet = resultSet.getInt("idCarFleet");
                int capacityByCars = resultSet.getInt("capacityByCars");
                LOGGER.info("id CarFleet -> " + idCarFleet +
                        ", capacity by cars -> " + capacityByCars);
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
            LOGGER.info("CarFleets:");

            while (resultSet.next()) {
                int idCarFleet = resultSet.getInt("idCarFleet");
                int capacityByCars = resultSet.getInt("capacityByCars");
                LOGGER.info("id CarFleet -> " + idCarFleet +
                        ", capacity by cars -> " + capacityByCars);
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
    public ArrayList<CarFleet> getAll() {
        ArrayList<CarFleet> carFleets = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int idCarFleet = resultSet.getInt("idCarFleet");
                int capacityByCars = resultSet.getInt("capacityByCars");
                CarFleet carFleet = new CarFleet(idCarFleet, capacityByCars);
                carFleets.add(carFleet);
                LOGGER.debug(carFleet + "\n is selected and received.");
            }
            LOGGER.info("Total amount of values: " + carFleets.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return carFleets;
    }

    @Override
    public ArrayList<CarFleet> getAllWithFilter(String pastWhereOperatorCondition) {
        ArrayList<CarFleet> carFleets = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int idCarFleet = resultSet.getInt("idCarFleet");
                int capacityByCars = resultSet.getInt("capacityByCars");
                CarFleet carFleet = new CarFleet(idCarFleet, capacityByCars);
                carFleets.add(carFleet);
                LOGGER.debug(carFleet + "\n is selected and received.");
            }
            LOGGER.info("Found values by condition: " + carFleets.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return carFleets;
    }

    @Override
    public CarFleet getById(Integer id) {
        CarFleet carFleet = new CarFleet();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                carFleet.setId(resultSet.getInt("idCarFleet"));
                carFleet.setCapacityByCars(resultSet.getInt("capacityByCars"));
                LOGGER.debug(carFleet + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return carFleet;
    }

    @Override
    public void insertToTable(CarFleet entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_CAR_FLEET_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setInt(2, entity.getCapacityByCars());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into CarFleets table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(int capacityByCars) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_CAR_QUERY)) {
            prepStatement.setInt(1, capacityByCars);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into CarFleets table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(CarFleet entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_CAR_FLEET_QUERY)) {
            prepStatement.setInt(1, entity.getCapacityByCars());
            prepStatement.setInt(2, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in CarFleets table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_CAR_FLEET_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in CarFleets table.");
            } else {
                LOGGER.info("There is no car fleet with id " + id);
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
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_CAR_FLEET_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in CarFleets table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }
}
