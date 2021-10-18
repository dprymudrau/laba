package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.VisitorAgeGroupCategory;
import com.solvd.laba.dao.interfaces.IVisitorAgeGroupCategoryDAO;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VisitorAgeGroupCategoryDAOImpl extends AbstractDAO implements IVisitorAgeGroupCategoryDAO {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM VisitorAgeGroupCategories";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM VisitorAgeGroupCategories WHERE ";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM VisitorAgeGroupCategories WHERE idVisitorAgeGroupCategory = ?";
    private static final String INSERT_NEW_AGE_GROUP_CATEGORY_QUERY = "INSERT INTO VisitorAgeGroupCategories(idVisitorAgeGroupCategory, ageGroupCategory) VALUES (?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_AGE_GROUP_CATEGORY_QUERY = "INSERT INTO VisitorAgeGroupCategories(ageGroupCategory) VALUES (?)";
    private static final String UPDATE_AGE_GROUP_CATEGORY_QUERY = "UPDATE VisitorAgeGroupCategories SET ageGroupCategory = ? WHERE idVisitorAgeGroupCategory = ?";
    private static final String DELETE_AGE_GROUP_CATEGORY_BY_ID_QUERY = "DELETE FROM VisitorAgeGroupCategories WHERE idVisitorAgeGroupCategory = ?";
    private static final String DELETE_AGE_GROUP_CATEGORY_WITH_CONDITION_QUERY = "DELETE FROM VisitorAgeGroupCategories WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(VisitorAgeGroupCategoryDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("VisitorAgeGroupCategories:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorAgeGroupCategory");
                String ageGroupCategory = resultSet.getString("ageGroupCategory");
                LOGGER.info("id -> " + id +
                        ", age group category -> " + ageGroupCategory);
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
            LOGGER.info("VisitorAgeGroupCategories:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorAgeGroupCategory");
                String ageGroupCategory = resultSet.getString("ageGroupCategory");
                LOGGER.info("id -> " + id +
                        ", age group category -> " + ageGroupCategory);
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
    public ArrayList<VisitorAgeGroupCategory> getAll() {
        ArrayList<VisitorAgeGroupCategory> visitorAgeGroupCategories = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorAgeGroupCategory");
                String ageGroupCategory = resultSet.getString("ageGroupCategory");
                VisitorAgeGroupCategory visitorAgeGroupCategory = new VisitorAgeGroupCategory(id, ageGroupCategory);
                visitorAgeGroupCategories.add(visitorAgeGroupCategory);
                LOGGER.debug(visitorAgeGroupCategory + "\n is selected and received.");
            }
            LOGGER.info("Total amount of values: " + visitorAgeGroupCategories.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitorAgeGroupCategories;
    }

    @Override
    public ArrayList<VisitorAgeGroupCategory> getAllWithFilter(String pastWhereOperatorCondition) {
        ArrayList<VisitorAgeGroupCategory> visitorAgeGroupCategories = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idVisitorAgeGroupCategory");
                String ageGroupCategory = resultSet.getString("ageGroupCategory");
                VisitorAgeGroupCategory visitorAgeGroupCategory = new VisitorAgeGroupCategory(id, ageGroupCategory);
                visitorAgeGroupCategories.add(visitorAgeGroupCategory);
                LOGGER.debug(visitorAgeGroupCategory + "\n is selected and received.");
            }
            LOGGER.info("Found values by condition: " + visitorAgeGroupCategories.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitorAgeGroupCategories;
    }

    @Override
    public VisitorAgeGroupCategory getById(Integer id) {
        VisitorAgeGroupCategory visitorAgeGroupCategory = new VisitorAgeGroupCategory();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                visitorAgeGroupCategory.setId(resultSet.getInt("idVisitorAgeGroupCategory"));
                visitorAgeGroupCategory.setAgeGroupCategory(resultSet.getString("ageGroupCategory"));
                LOGGER.debug(visitorAgeGroupCategory + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return visitorAgeGroupCategory;
    }

    @Override
    public void insertToTable(VisitorAgeGroupCategory entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_AGE_GROUP_CATEGORY_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setString(2, entity.getAgeGroupCategory());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into VisitorAgeGroupCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(String ageGroupCategory) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_AGE_GROUP_CATEGORY_QUERY)) {
            prepStatement.setString(1, ageGroupCategory);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into VisitorAgeGroupCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(VisitorAgeGroupCategory entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_AGE_GROUP_CATEGORY_QUERY)) {
            prepStatement.setString(1, entity.getAgeGroupCategory());
            prepStatement.setInt(2, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in VisitorAgeGroupCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_AGE_GROUP_CATEGORY_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in VisitorAgeGroupCategories table.");
            } else {
                LOGGER.info("There is no visitor age group category with id " + id);
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
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_AGE_GROUP_CATEGORY_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in VisitorAgeGroupCategories table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }
}
