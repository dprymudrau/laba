package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.VisitorCategory;
import com.solvd.laba.dao.interfaces.IVisitorCategoryDAO;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorCategoryDAOImpl extends AbstractDAO implements IVisitorCategoryDAO {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM VisitorCategories";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM VisitorCategories WHERE ";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM VisitorCategories WHERE idVisitorCategory = ?";
    private static final String INSERT_NEW_VISITOR_CATEGORY_QUERY = "INSERT INTO VisitorCategories(idVisitorCategory, healthConditionCategory, visitCategory) VALUES (?, ?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_VISITOR_CATEGORY_QUERY = "INSERT INTO VisitorCategories(healthConditionCategory, visitCategory) VALUES (?, ?)";
    private static final String UPDATE_VISITOR_CATEGORY_QUERY = "UPDATE VisitorCategories SET healthConditionCategory = ?, visitCategory = ? WHERE idVisitorCategory = ?";
    private static final String DELETE_VISITOR_CATEGORY_BY_ID_QUERY = "DELETE FROM VisitorCategories WHERE idVisitorCategory = ?";
    private static final String DELETE_VISITOR_CATEGORY_WITH_CONDITION_QUERY = "DELETE FROM VisitorCategories WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(VisitorCategoryDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("VisitorCategories:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorCategory");
                String healthConditionCategory = resultSet.getString("healthConditionCategory");
                String visitCategory = resultSet.getString("visitCategory");
                LOGGER.info("id -> " + id +
                        ", health condition category -> " + healthConditionCategory +
                        ", visit category -> " + visitCategory);
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
            LOGGER.info("VisitorCategories:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorCategory");
                String healthConditionCategory = resultSet.getString("healthConditionCategory");
                String visitCategory = resultSet.getString("visitCategory");
                LOGGER.info("id -> " + id +
                        ", health condition category -> " + healthConditionCategory +
                        ", visit category -> " + visitCategory);
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
    public ArrayList<VisitorCategory> getAll() {
        ArrayList<VisitorCategory> visitorCategories = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorCategory");
                String healthConditionCategory = resultSet.getString("healthConditionCategory");
                String visitCategory = resultSet.getString("visitCategory");
                VisitorCategory visitorCategory = new VisitorCategory(id, healthConditionCategory, visitCategory);
                visitorCategories.add(visitorCategory);
                LOGGER.debug(visitorCategory + "\n is selected and received.");
            }
            LOGGER.info("Total amount of values: " + visitorCategories.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitorCategories;
    }

    @Override
    public ArrayList<VisitorCategory> getAllWithFilter(String pastWhereOperatorCondition) {
        ArrayList<VisitorCategory> visitorCategories = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorCategory");
                String healthConditionCategory = resultSet.getString("healthConditionCategory");
                String visitCategory = resultSet.getString("visitCategory");
                VisitorCategory visitorCategory = new VisitorCategory(id, healthConditionCategory, visitCategory);
                visitorCategories.add(visitorCategory);
                LOGGER.debug(visitorCategory + "\n is selected and received.");
            }
            LOGGER.info("Found values by condition: " + visitorCategories.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitorCategories;
    }

    @Override
    public VisitorCategory getById(Integer id) {
        VisitorCategory visitorCategory = new VisitorCategory();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                visitorCategory.setId(resultSet.getInt("idVisitorCategory"));
                visitorCategory.setHealthConditionCategory(resultSet.getString("healthConditionCategory"));
                visitorCategory.setVisitCategory(resultSet.getString("visitCategory"));
                LOGGER.debug(visitorCategory + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitorCategory;
    }

    @Override
    public void insertToTable(VisitorCategory entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_VISITOR_CATEGORY_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setString(2, entity.getHealthConditionCategory());
            prepStatement.setString(3, entity.getVisitCategory());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into VisitorCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(String healthConditionCategory, String visitCategory) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_VISITOR_CATEGORY_QUERY)) {
            prepStatement.setString(1, healthConditionCategory);
            prepStatement.setString(2, visitCategory);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into VisitorCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(VisitorCategory entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_VISITOR_CATEGORY_QUERY)) {
            prepStatement.setString(1, entity.getHealthConditionCategory());
            prepStatement.setString(2, entity.getVisitCategory());
            prepStatement.setInt(3, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in VisitorCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_VISITOR_CATEGORY_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in VisitorCategories table.");
            } else {
                LOGGER.info("There is no visitor category with id " + id);
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
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_VISITOR_CATEGORY_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in VisitorCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

}
