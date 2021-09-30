package com.solvd.airport.dao.jdbc.impl;

import com.solvd.airport.binary.PlaneModel;
import com.solvd.airport.dao.AbstractDAO;
import com.solvd.airport.dao.interfaces.PlaneModelDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneModelDaoImpl extends AbstractDAO implements PlaneModelDAO {

    private static Logger LOGGER = LogManager.getLogger(FlightCategoryDaoImpl.class);

    private static String GET_PLANE_MODEL_BY_ID_Q = "SELECT idPlaneModel, " +
            "planeModelName, " +
            "capacity " +
            "FROM PlaneModel " +
            "WHERE idPlaneModel = ?";

    @Override
    public void save(PlaneModel planeModel) {

    }

    @Override
    public void delete(PlaneModel planeModel) {

    }

    @Override
    public PlaneModel getById(long id) {
        PlaneModel planeModel = new PlaneModel();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = connection.prepareStatement(GET_PLANE_MODEL_BY_ID_Q);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    planeModel.setIdPlaneModel(rs.getLong("idPlaneModel"));
                    planeModel.setPlaneModelName(rs.getString("planeModelName"));
                    planeModel.setCapacity(rs.getInt("capacity"));
                }
                else{
                    return null;
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            } finally {
                connectionPool.releaseConnection(connection);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return planeModel;    }
}
