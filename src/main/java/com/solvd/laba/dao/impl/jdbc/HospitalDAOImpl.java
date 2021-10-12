package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.dao.EntityDAO;
import com.solvd.laba.binary.Hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class HospitalDAOImpl extends AbstractDAO implements EntityDAO<Hospital, Integer> {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Hospitals";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM Hospitals WHERE ";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM Hospitals WHERE idHospital = ?";
    private static final String INSERT_NEW_HOSPITAL_QUERY = "INSERT INTO Hospitals(idHospital, hospitalName, hospitalAddress, idCarFleet) VALUES (?, ?, ?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_HOSPITAL_QUERY = "INSERT INTO Hospitals(hospitalName, hospitalAddress, idCarFleet) VALUES (?, ?, ?)";
    private static final String UPDATE_HOSPITAL_QUERY = "UPDATE Hospitals SET hospitalName = ?, hospitalAddress = ?, idCarFleet = ? WHERE idHospital = ?";
    private static final String DELETE_HOSPITAL_BY_ID_QUERY = "DELETE FROM Hospitals WHERE idHospital = ?";
    private static final String DELETE_HOSPITAL_WITH_CONDITION_QUERY = "DELETE FROM Hospitals WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(HospitalDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("Hospitals:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idHospital");
                String hospitalName = resultSet.getString("hospitalName");
                String hospitalAddress = resultSet.getString("hospitalAddress");
                int idCarFleet = resultSet.getInt("idCarFleet");
                LOGGER.info("id -> " + id +
                        ", hospital name -> " + hospitalName +
                        ", hospital address -> " + hospitalAddress +
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
            LOGGER.info("Hospitals:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idHospital");
                String hospitalName = resultSet.getString("hospitalName");
                String hospitalAddress = resultSet.getString("hospitalAddress");
                int idCarFleet = resultSet.getInt("idCarFleet");
                LOGGER.info("id -> " + id +
                        ", hospital name -> " + hospitalName +
                        ", hospital address -> " + hospitalAddress +
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
    public ArrayList<Hospital> getAll() {
        ArrayList<Hospital> hospitals = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idHospital");
                String hospitalName = resultSet.getString("hospitalName");
                String hospitalAddress = resultSet.getString("hospitalAddress");
                int idCarFleet = resultSet.getInt("idCarFleet");
                Hospital hospital = new Hospital(id, hospitalName, hospitalAddress, idCarFleet);
                hospitals.add(hospital);
                LOGGER.debug(hospital + "\n is selected and received.");
            }
            LOGGER.info("Total amount of values: " + hospitals.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return hospitals;
    }

    @Override
    public ArrayList<Hospital> getAllWithFilter(String pastWhereOperatorCondition) {
        ArrayList<Hospital> hospitals = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idHospital");
                String hospitalName = resultSet.getString("hospitalName");
                String hospitalAddress = resultSet.getString("hospitalAddress");
                int idCarFleet = resultSet.getInt("idCarFleet");
                Hospital hospital = new Hospital(id, hospitalName, hospitalAddress, idCarFleet);
                hospitals.add(hospital);
                LOGGER.debug(hospital + "\n is selected and received.");
            }
            LOGGER.info("Found values by condition: " + hospitals.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return hospitals;
    }

    @Override
    public Hospital getById(Integer id) {
        Hospital hospital = new Hospital();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                hospital.setId(resultSet.getInt("idHospital"));
                hospital.setName(resultSet.getString("hospitalName"));
                hospital.setAddress(resultSet.getString("hospitalAddress"));
                hospital.setIdCarFleet(resultSet.getInt("idCarFleet"));
                LOGGER.debug(hospital + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return hospital;
    }

    @Override
    public void insertToTable(Hospital entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_HOSPITAL_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setString(2, entity.getName());
            prepStatement.setString(3, entity.getAddress());
            prepStatement.setInt(4, entity.getIdCarFleet());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Hospitals table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(String hospitalName, String hospitalAddress, int idCarFleet) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_HOSPITAL_QUERY)) {
            prepStatement.setString(1, hospitalName);
            prepStatement.setString(2, hospitalAddress);
            prepStatement.setInt(3, idCarFleet);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Hospitals table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(Hospital entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_HOSPITAL_QUERY)) {
            prepStatement.setString(1, entity.getName());
            prepStatement.setString(2, entity.getAddress());
            prepStatement.setInt(3, entity.getIdCarFleet());
            prepStatement.setInt(4, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in Hospitals table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_HOSPITAL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in Hospitals table.");
            } else {
                LOGGER.info("There is no hospital with id " + id);
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
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_HOSPITAL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in Hospitals table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }
}
