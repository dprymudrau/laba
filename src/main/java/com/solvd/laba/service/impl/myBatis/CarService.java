package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Car;
import com.solvd.laba.dao.interfaces.ICarDAO;
import com.solvd.laba.util.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CarService {
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();
    private final static Logger LOGGER = LogManager.getLogger(CarService.class);

    public Car getCarById(int id) {
        Car car;
        try(SqlSession sqlSession = factory.openSession()) {
            ICarDAO dao = sqlSession.getMapper(ICarDAO.class);
            car = dao.getById(id);
        }
        return car;
    }

    public ArrayList<Car> getAll() {
        ArrayList<Car> cars;
        try(SqlSession sqlSession = factory.openSession()) {
            ICarDAO dao = sqlSession.getMapper(ICarDAO.class);
            cars = dao.getAll();
        }
        return cars;
    }

    public void deleteCarById(int id) {
        try(SqlSession sqlSession = factory.openSession()) {
            ICarDAO dao = sqlSession.getMapper(ICarDAO.class);
            try {
                dao.deleteById(id);
                sqlSession.commit();
                LOGGER.debug("Car was deleted from DBTable Cars!");
            } catch (Exception e) {
                sqlSession.rollback();
                LOGGER.error(e);
            }
        }
    }
}
