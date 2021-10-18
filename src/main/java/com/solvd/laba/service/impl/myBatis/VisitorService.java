package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Visitor;
import com.solvd.laba.dao.interfaces.IVisitorDAO;
import com.solvd.laba.util.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class VisitorService {
    private final static Logger LOGGER = LogManager.getLogger(VisitorService.class);
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public ArrayList<Visitor> getAllVisitors() {
        ArrayList<Visitor> visitors;
        try(SqlSession sqlSession = factory.openSession()) {
            IVisitorDAO dao = sqlSession.getMapper(IVisitorDAO.class);
            visitors = dao.getAll();
        }
        return visitors;
    }

    public void insertVisitor(Visitor visitor) {
        try(SqlSession sqlSession = factory.openSession()) {
            IVisitorDAO dao = sqlSession.getMapper(IVisitorDAO.class);
            try {
                dao.insertToTable(visitor);
                sqlSession.commit();
            } catch (Exception e) {
                sqlSession.rollback();
                LOGGER.error(e);
            }
        }
    }

    public void deleteVisitorById(int id) {
        try(SqlSession sqlSession = factory.openSession()) {
            IVisitorDAO dao = sqlSession.getMapper(IVisitorDAO.class);
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
