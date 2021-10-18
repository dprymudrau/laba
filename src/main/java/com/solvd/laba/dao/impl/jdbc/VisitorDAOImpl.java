package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.Visitor;
import com.solvd.laba.dao.interfaces.IVisitorDAO;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.util.DateConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class VisitorDAOImpl extends AbstractDAO implements IVisitorDAO {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Visitors";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM Visitors WHERE ";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM Visitors WHERE idVisitor = ?";
    private static final String INSERT_NEW_VISITOR_QUERY = "INSERT INTO Visitors(idVisitor, visitorName, visitorSurname, visitorDayOfBirth, visitorAddress, diagnosis, visitDate, dischargeDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_VISITOR_QUERY = "INSERT INTO Visitors(visitorName, visitorSurname, visitorDayOfBirth, visitorAddress, diagnosis, visitDate, dischargeDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_VISITOR_QUERY = "UPDATE Visitors SET visitorName = ?, visitorSurname = ?, visitorDayOfBirth = ?, visitorAddress = ?, diagnosis = ?, visitDate = ?, dischargeDate = ? WHERE idVisitor = ?";
    private static final String DELETE_VISITOR_BY_ID_QUERY = "DELETE FROM Visitors WHERE idVisitor = ?";
    private static final String DELETE_VISITOR_WITH_CONDITION_QUERY = "DELETE FROM Visitors WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(VisitorDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("Visitors:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitor");
                String name = resultSet.getString("visitorName");
                String surname = resultSet.getString("visitorSurname");
                Date dayOfBirth = resultSet.getDate("visitorDayOfBirth");
                String address = resultSet.getString("visitorAddress");
                String diagnosis = resultSet.getString("diagnosis");
                Date visitDate = resultSet.getDate("visitDate");
                Date dischargeDate = resultSet.getDate("dischargeDate");
                LOGGER.info("id -> " + id +
                        ", name -> " + name +
                        ", surname -> " + surname +
                        ", birthday -> " + dayOfBirth +
                        ", address -> " + address +
                        ", diagnosis -> " + diagnosis +
                        ", visit date -> " + visitDate +
                        ", discharge date -> " + dischargeDate);
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
            LOGGER.info("Visitors:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitor");
                String name = resultSet.getString("visitorName");
                String surname = resultSet.getString("visitorSurname");
                Date dayOfBirth = resultSet.getDate("visitorDayOfBirth");
                String address = resultSet.getString("visitorAddress");
                String diagnosis = resultSet.getString("diagnosis");
                Date visitDate = resultSet.getDate("visitDate");
                Date dischargeDate = resultSet.getDate("dischargeDate");
                LOGGER.info("id -> " + id +
                        ", name -> " + name +
                        ", surname -> " + surname +
                        ", birthday -> " + dayOfBirth +
                        ", address -> " + address +
                        ", diagnosis -> " + diagnosis +
                        ", visit date -> " + visitDate +
                        ", discharge date -> " + dischargeDate);
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
    public ArrayList<Visitor> getAll() {
        ArrayList<Visitor> visitors = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitor");
                String name = resultSet.getString("visitorName");
                String surname = resultSet.getString("visitorSurname");
                Date dayOfBirth = resultSet.getDate("visitorDayOfBirth");
                String address = resultSet.getString("visitorAddress");
                String diagnosis = resultSet.getString("diagnosis");
                Date visitDate = resultSet.getDate("visitDate");
                Date dischargeDate = resultSet.getDate("dischargeDate");
                Visitor visitor = new Visitor(id, name, surname, dayOfBirth, address, diagnosis, visitDate, dischargeDate);
                visitors.add(visitor);
                LOGGER.debug(visitor + "\n is selected and received.");
            }
            LOGGER.info("Total amount of values: " + visitors.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitors;
    }

    @Override
    public ArrayList<Visitor> getAllWithFilter(String pastWhereOperatorCondition) {
        ArrayList<Visitor> visitors = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitor");
                String name = resultSet.getString("visitorName");
                String surname = resultSet.getString("visitorSurname");
                Date dayOfBirth = resultSet.getDate("visitorDayOfBirth");
                String address = resultSet.getString("visitorAddress");
                String diagnosis = resultSet.getString("diagnosis");
                Date visitDate = resultSet.getDate("visitDate");
                Date dischargeDate = resultSet.getDate("dischargeDate");
                Visitor visitor = new Visitor(id, name, surname, dayOfBirth, address, diagnosis, visitDate, dischargeDate);
                visitors.add(visitor);
                LOGGER.debug(visitor + "\n is selected and received.");
            }
            LOGGER.info("Found values by condition: " + visitors.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitors;
    }

    @Override
    public Visitor getById(Integer id) {
        Visitor visitor = new Visitor();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                visitor.setId(resultSet.getInt("idVisitor"));
                visitor.setName(resultSet.getString("visitorName"));
                visitor.setSurname(resultSet.getString("visitorSurname"));
                visitor.setBirthday(resultSet.getDate("visitorDayOfBirth"));
                visitor.setAddress(resultSet.getString("visitorAddress"));
                visitor.setDiagnosis(resultSet.getString("diagnosis"));
                visitor.setVisitDate(resultSet.getDate("visitDate"));
                visitor.setDischargeDate(resultSet.getDate("dischargeDate"));
                LOGGER.debug(visitor + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitor;
    }

    @Override
    public void insertToTable(Visitor entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_VISITOR_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setString(2, entity.getName());
            prepStatement.setString(3, entity.getSurname());
            prepStatement.setDate(4, DateConverter.convertToSqlDate(entity.getBirthday()));
            prepStatement.setString(5, entity.getAddress());
            prepStatement.setString(6, entity.getDiagnosis());
            prepStatement.setDate(7, DateConverter.convertToSqlDate(entity.getVisitDate()));
            prepStatement.setDate(8, DateConverter.convertToSqlDate(entity.getDischargeDate()));
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Visitors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(String name, String surname, Date birthday, String address, String diagnosis, Date visitDate, Date dischargeDate) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_VISITOR_QUERY)) {
            prepStatement.setString(1, name);
            prepStatement.setString(2, surname);
            prepStatement.setDate(3, birthday);
            prepStatement.setString(4, address);
            prepStatement.setString(5, diagnosis);
            prepStatement.setDate(6, visitDate);
            prepStatement.setDate(7, dischargeDate);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Visitors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(Visitor entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_VISITOR_QUERY)) {
            prepStatement.setString(1, entity.getName());
            prepStatement.setString(2, entity.getSurname());
            prepStatement.setDate(3, DateConverter.convertToSqlDate(entity.getBirthday()));
            prepStatement.setString(4, entity.getAddress());
            prepStatement.setString(5, entity.getDiagnosis());
            prepStatement.setDate(6, DateConverter.convertToSqlDate(entity.getVisitDate()));
            prepStatement.setDate(7, DateConverter.convertToSqlDate(entity.getDischargeDate()));
            prepStatement.setInt(8, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in Visitors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_VISITOR_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in Visitors table.");
            } else {
                LOGGER.info("There is no visitor with id " + id);
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
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_VISITOR_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in Visitors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }
}
