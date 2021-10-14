package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.Project;
import com.solvd.laba.dao.interfases.EmploeeDAO;
import com.solvd.laba.dao.interfases.ProjectDAO;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.ProjectServise;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectImpl implements MyService,ProjectServise {
    private static final Logger LOGGER = LogManager.getLogger(com.solvd.laba.service.impl.jdbc.MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory= MyBatis.getSessionFactory();
    @Override
    public void doSmth() {

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
        return null;
    }

    @Override
    public Object checkDb(Object id) {
        return null;
    }

    @Override
    public Object getProject(Object id) {
        return null;
    }

    @Override
    public Object setProject(Object id) {
        return null;
    }
}
