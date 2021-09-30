package com.solvd.airport.dao.jdbc.impl;

import com.solvd.airport.binary.Plane;
import com.solvd.airport.dao.AbstractDAO;
import com.solvd.airport.dao.interfaces.PlaneDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneDaoImpl extends AbstractDAO implements PlaneDAO {

    private static Logger LOGGER = LogManager.getLogger(FlightCategoryDaoImpl.class);

    private static String GET_PLANE_BY_ID_Q = "SELECT idPlane, " +
            "companyId, " +
            "modelId, " +
            "serialNumber "+
            "FROM Plane " +
            "WHERE idPlane = ?";

    @Override
    public void save(Plane plane) {

    }

    @Override
    public void delete(Plane plane) {

    }

    @Override
    public Plane getById(long id) {
        Plane plane = new Plane();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = connection.prepareStatement(GET_PLANE_BY_ID_Q);
                ps.setLong(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    plane.setIdPlane(rs.getLong("idPlane"));
                    plane.setCompanyId(rs.getLong("companyId"));
                    plane.setModelId(rs.getLong("modelId"));
                    plane.setSerialNumber(rs.getString("serialNumber"));
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
        return plane;
    }


}
