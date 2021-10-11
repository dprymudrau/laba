package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.service.MyService;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import static com.solvd.laba.utils.MyBatis.getSessionFactory;

public class MyServiceImpl implements MyService {
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory= MyBatis.getSessionFactory();

    @Override
    public void doSmth() {
        //throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object getById(Object id) {
        Emploee emploee = null;
        try{
            SqlSession sqlSession = factory.openSession();
            EmploeeDAO emploeeDAO = sqlSession.getMapper(EmploeeDAO.class);
            emploee = EmploeeDAO.getById();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emploee;
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
