package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.dao.interfaces.IRegistrationCardDAO;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class RegistrationCardDAOImpl extends AbstractDAO implements IRegistrationCardDAO {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM RegistrationCards";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM RegistrationCards WHERE ";
    private static final String SELECT_BY_VISITOR_ID_QUERY = "SELECT * FROM RegistrationCards WHERE idVisitor = ?";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM RegistrationCards WHERE idRegistrationCard = ?";
    private static final String INSERT_NEW_REG_CARD_QUERY = "INSERT INTO RegistrationCards(idRegistrationCard, idHospital, idVisitor, idVisitorAgeGroupCategory, idVisitorCategory) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_REG_CARD_QUERY = "INSERT INTO RegistrationCards(idHospital, idVisitor, idVisitorAgeGroupCategory, idVisitorCategory) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_REG_CARD_QUERY = "UPDATE RegistrationCards SET idHospital = ?, idVisitor = ?, idVisitorAgeGroupCategory = ?, idVisitorCategory = ? WHERE idRegistrationCard = ?";
    private static final String DELETE_REG_CARD_BY_ID_QUERY = "DELETE FROM RegistrationCards WHERE idRegistrationCard = ?";
    private static final String DELETE_REG_CARD_WITH_CONDITION_QUERY = "DELETE FROM RegistrationCards WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(RegistrationCardDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("RegistrationCards:");

            while (resultSet.next()) {
                int idRegCard = resultSet.getInt("idRegistrationCard");
                int idHospital = resultSet.getInt("idHospital");
                int idVisitor = resultSet.getInt("idVisitor");
                int idVisitorAgeGroupCategory = resultSet.getInt("idVisitorAgeGroupCategory");
                int idVisitorCategory = resultSet.getInt("idVisitorCategory");
                LOGGER.info("idRegCard -> " + idRegCard +
                        ", idHospital -> " + idHospital +
                        ", idVisitor -> " + idVisitor +
                        ", idVisitorAgeGroupCategory -> " + idVisitorAgeGroupCategory +
                        ", idVisitorCategory -> " + idVisitorCategory);
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
            LOGGER.info("RegCards:");

            while (resultSet.next()) {
                int idRegCard = resultSet.getInt("idRegistrationCard");
                int idHospital = resultSet.getInt("idHospital");
                int idVisitor = resultSet.getInt("idVisitor");
                int idVisitorAgeGroupCategory = resultSet.getInt("idVisitorAgeGroupCategory");
                int idVisitorCategory = resultSet.getInt("idVisitorCategory");
                LOGGER.info("idRegCard -> " + idRegCard +
                        ", idHospital -> " + idHospital +
                        ", idVisitor -> " + idVisitor +
                        ", idVisitorAgeGroupCategory -> " + idVisitorAgeGroupCategory +
                        ", idVisitorCategory -> " + idVisitorCategory);
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
    public ArrayList<RegistrationCard> getAll() {
        ArrayList<RegistrationCard> registrationCards = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int idRegCard = resultSet.getInt("idRegistrationCard");
                int idHospital = resultSet.getInt("idHospital");
                int idVisitor = resultSet.getInt("idVisitor");
                int idVisitorAgeGroupCategory = resultSet.getInt("idVisitorAgeGroupCategory");
                int idVisitorCategory = resultSet.getInt("idVisitorCategory");
                RegistrationCard regCard = new RegistrationCard(idRegCard, idHospital, idVisitor, idVisitorAgeGroupCategory, idVisitorCategory);
                registrationCards.add(regCard);
                LOGGER.debug(regCard + "\n is selected and received.");
            }
            LOGGER.info("Total amount of values: " + registrationCards.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return registrationCards;
    }

    @Override
    public RegistrationCard getById(Integer id) {
        RegistrationCard regCard = new RegistrationCard();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                regCard.setId(resultSet.getInt("idRegistrationCard"));
                regCard.setIdHospital(resultSet.getInt("idHospital"));
                regCard.setIdVisitor(resultSet.getInt("idVisitor"));
                regCard.setIdVisitorAgeGroupCategory(resultSet.getInt("idVisitorAgeGroupCategory"));
                regCard.setIdVisitorCategory(resultSet.getInt("idVisitorCategory"));
                LOGGER.debug(regCard + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return regCard;
    }

    @Override
    public RegistrationCard getByVisitorId(int idVisitor) {
        RegistrationCard regCard = new RegistrationCard();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_BY_VISITOR_ID_QUERY)) {
            prepStatement.setInt(1, idVisitor);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                regCard.setId(resultSet.getInt("idRegistrationCard"));
                regCard.setIdHospital(resultSet.getInt("idHospital"));
                regCard.setIdVisitor(resultSet.getInt("idVisitor"));
                regCard.setIdVisitorAgeGroupCategory(resultSet.getInt("idVisitorAgeGroupCategory"));
                regCard.setIdVisitorCategory(resultSet.getInt("idVisitorCategory"));
                LOGGER.debug(regCard + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return null;
    }

    @Override
    public void insertToTable(RegistrationCard entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_REG_CARD_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setInt(2, entity.getIdHospital());
            prepStatement.setInt(3, entity.getIdVisitor());
            prepStatement.setInt(4, entity.getIdVisitorAgeGroupCategory());
            prepStatement.setInt(5, entity.getIdVisitorCategory());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into RegistrationCards table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(int idHospital, int idVisitor, int idVisitorAgeGroupCategory, int idVisitorCategory) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_REG_CARD_QUERY)) {
            prepStatement.setInt(1, idHospital);
            prepStatement.setInt(2, idVisitor);
            prepStatement.setInt(3, idVisitorAgeGroupCategory);
            prepStatement.setInt(4, idVisitorCategory);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into RegistrationCards table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(RegistrationCard entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_REG_CARD_QUERY)) {
            prepStatement.setInt(1, entity.getIdHospital());
            prepStatement.setInt(2, entity.getIdVisitor());
            prepStatement.setInt(3, entity.getIdVisitorAgeGroupCategory());
            prepStatement.setInt(4, entity.getIdVisitorCategory());
            prepStatement.setInt(5, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in RegistrationCards table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_REG_CARD_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in RegistrationCards table.");
            } else {
                LOGGER.info("There is no registration card with id " + id);
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
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_REG_CARD_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in RegistrationCards table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }
}
