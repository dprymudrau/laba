package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.CarFleet;
import com.solvd.laba.dao.interfaces.ICarDAO;
import com.solvd.laba.dao.interfaces.ICarFleetDAO;
import com.solvd.laba.service.ICarFleetService;
import com.solvd.laba.util.BelongingException;
import com.solvd.laba.util.MyBatisFactory;
import com.solvd.laba.util.UnacceptableCheckResultException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CarFleetServiceImpl implements ICarFleetService<Integer> {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();
    private final static Logger LOGGER = LogManager.getLogger(CarFleetServiceImpl.class);

    public CarFleet getCarFleetById(int id) {
        CarFleet fleet;
        try(SqlSession sqlSession = factory.openSession()) {
            ICarFleetDAO dao = sqlSession.getMapper(ICarFleetDAO.class);
            fleet = dao.getById(id);
        }
        return fleet;
    }

    @Override
    public int countCurrentCarsAmount(Integer carFleetId) {
        ArrayList<Car> filteredCars;
        try(SqlSession sqlSession = factory.openSession()) {
            ICarDAO dao = sqlSession.getMapper(ICarDAO.class);
            filteredCars = dao.getAllByCarFleetId(carFleetId);
        }

        return filteredCars.size();
    }

    @Override
    public boolean checkFreeParkingSlot(Integer carFleetId) {
        int freeSpace;

        try(SqlSession sqlSession = factory.openSession()) {
            ICarFleetDAO dao = sqlSession.getMapper(ICarFleetDAO.class);
            int carFleetCapacity = dao.getById(carFleetId).getCapacityByCars();
            int amountOfCurrentCars = countCurrentCarsAmount(carFleetId);
            freeSpace = carFleetCapacity - amountOfCurrentCars;
        }

        return freeSpace > 0;
    }

    @Override
    public boolean doesCarFleetContainCar(Integer carFleetId, Car car) {
        boolean contain = false;
        ArrayList<Car> filteredCars;

        try(SqlSession sqlSession = factory.openSession()) {
            ICarDAO dao = sqlSession.getMapper(ICarDAO.class);
            filteredCars = dao.getAllByCarFleetId(carFleetId);
            for (Car entity : filteredCars) {
                if (entity.getRegNumber().equals(car.getRegNumber())
                        && entity.getBrandName().equals(car.getBrandName())
                        && entity.getModel().equals(car.getModel())) {
                    contain = true;
                    break;
                }
            }
        }

        return contain;
    }

    @Override
    public void insertNewCarToFleet(Integer carFleetId, Car newCar) throws UnacceptableCheckResultException {
        try(SqlSession sqlSession = factory.openSession()) {
            if (checkFreeParkingSlot(carFleetId)) {
                if (!doesCarFleetContainCar(carFleetId, newCar)) {
                    if (newCar.getIdCarFleet() == carFleetId) {
                        ICarDAO dao = sqlSession.getMapper(ICarDAO.class);
                        try {
                            dao.insertToTable(newCar);
                            sqlSession.commit();
                        } catch (Exception e) {
                            sqlSession.rollback();
                            LOGGER.error(e);
                        }
                    } else throw new BelongingException("This car does not belong to this Car fleet!");
                } else throw new UnacceptableCheckResultException("Car cannot be added.");
            } else throw new UnacceptableCheckResultException("Car cannot be added.");
        }
    }

}
