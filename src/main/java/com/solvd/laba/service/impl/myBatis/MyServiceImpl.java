package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.dao.jdbc.impl.EmploeeDAOImpl;
import com.solvd.laba.service.MyService;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.laba.utils.MyBatis.getSessionFactory;

public class MyServiceImpl implements MyService {
    private static final Logger LOGGER = LogManager.getLogger(com.solvd.laba.service.impl.jdbc.MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory= MyBatis.getSessionFactory();

    @Override
    public void doSmth() {
        EmploeeDAOImpl employee = new EmploeeDAOImpl();

        getById(employee);
        //throw new UnsupportedOperationException("This method isn't implemented for JDBC Service");
    }

    @Override
    public Object getById(Object object) {
        //Emploee emploee = null;
        try{
            SqlSession sqlSession = factory.openSession();
            EmploeeDAO emploeeDAO = sqlSession.getMapper(EmploeeDAO.class);
            object = EmploeeDAO.getById();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public Object setById(Object id) {
        //session.commit();
        //session.rollback();
        return null;
    }

    @Override
    public Object checkDb(Object id) {
        return null;
    }
}
