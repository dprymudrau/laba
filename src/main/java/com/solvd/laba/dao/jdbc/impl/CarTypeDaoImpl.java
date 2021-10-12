package com.solvd.laba.dao.jdbc.impl;


        import com.solvd.laba.binary.CarType;
        import com.solvd.laba.dao.AbstractDAO;
        import com.solvd.laba.dao.interfaces.ICarTypeDAO;
        import com.solvd.laba.utils.pool.ConnectionPool;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;

        import java.sql.*;

public class CarTypeDaoImpl extends AbstractDAO implements ICarTypeDAO {

    private static Logger LOGGER = LogManager.getLogger(CarTypeDaoImpl.class);

    private static String GET_CAR_TYPE_BY_ID_Q = "SELECT idCarType, " +
            "carType " +
            "FROM CarType " +
            "WHERE idCarType = ?";


    @Override
    public void save(CarType carType) {

    }

    @Override
    public void delete(CarType carType) {

    }

    @Override
    public void update(CarType carType) {

    }

    @Override
    public CarType getById(long id) {
        CarType carType = new CarType();
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedSt = null;
        ResultSet resultSet = null;
        try {
            preparedSt = connection.prepareStatement(GET_CAR_TYPE_BY_ID_Q);
            preparedSt.setLong(1, id);
            resultSet = preparedSt.executeQuery();
            if (resultSet.next()) {
                carType.setCarTypeId((int) resultSet.getLong("CarTypeId"));
                carType.setCarTypeName("CarTypeName");
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            LOGGER.error("Error with response", e);
            throw new RuntimeException("");
        } finally {
            ConnectionPool.releaseCon(connection);
        }
        return carType;
    }
}