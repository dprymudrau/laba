package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.service.MyService;

public class MyServiceImpl implements MyService {
    @Override
    public void doSmth() {
        //some code;
    }

    @Override
    public Object getById(Object id) {
        return null;
    }

    @Override
    public Object setById(Object id) {
        return null;
    }

    @Override
    public Object checkDb(Object id) {
        return null;
    }
    //    public User getUserByID(int id){
//        SQLSessionFactory sqlSessionFactory = myBatisDaoFactory.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserDao userDao = sqlSession.getMapper(UserDAO.class);
//        User user = userDao.getByID(id);
//        sqlSession.close();
//
//
//        return user;
//    }


}
