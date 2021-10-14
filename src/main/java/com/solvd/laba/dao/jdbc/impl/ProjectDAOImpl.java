package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.Project;
import com.solvd.laba.dao.AbstractDAO;
import com.solvd.laba.dao.interfases.ProjectDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAOImpl extends AbstractDAO implements ProjectDAO {
    private static final Logger LOGGER = LogManager.getLogger(ProjectDAOImpl.class);
    private final static String MY_QUERY = "SELECT * FROM Project WHERE id = ?";
    private String project;
    private String departmentNameId;

    @Override
    public void save(Project project) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public void delete(Project project) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Project getById(Long id) {
        Connection connection = getConnection();
        ResultSet resultSet = null;
        Project project = new Project();
        try (PreparedStatement preparedStatement = connection.prepareStatement(MY_QUERY)) {
            LOGGER.debug("preparedStatement" + preparedStatement + " created.");
            preparedStatement.setLong(1, id.longValue());
            LOGGER.debug("Query" + MY_QUERY + "started");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                project.setProject(resultSet.getString("Project"));
            }
            LOGGER.info("project was retrieved from db" + project);
            return project;
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        } finally {
            closeResourse(resultSet);
            returnConnection(connection);
        }
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setDepartmentNameId(String departmentNameId) {
        this.departmentNameId = departmentNameId;
    }
}
