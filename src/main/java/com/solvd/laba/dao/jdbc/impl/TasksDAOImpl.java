package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.Tasks;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfases.TasksDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TasksDAOImpl extends AbstractDAO implements TasksDAO {
    private static final Logger LOGGER = LogManager.getLogger(TasksDAOImpl.class);
    private final static String MY_QUERY = "SELECT * FROM Tasks WHERE id = ?";
    private String task;

    @Override
    public void save(Tasks tasks) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public void delete(Tasks tasks) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Tasks getById(Long id) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        Tasks tasks = new Tasks();
        try (PreparedStatement preparedStatement = connection.prepareStatement(MY_QUERY)){
            LOGGER.debug("preparedStatement" + preparedStatement +" created.");
            preparedStatement.setLong(1, id.longValue());
            LOGGER.debug("Query" + MY_QUERY + "started");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tasks.setTask(resultSet.getString("cCName"));
            }
            LOGGER.info("tasks was retrieved from db" + tasks);
            return tasks;
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        } finally {
            closeResourse(resultSet);
            returnConnection(connection);
        }
    }

    public void setTask(String task) {
        this.task = task;
    }
}
