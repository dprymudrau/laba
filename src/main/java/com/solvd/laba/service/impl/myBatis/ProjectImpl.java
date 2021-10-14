package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.Project;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.ProjectServise;
import com.solvd.laba.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProjectImpl implements MyService, ProjectServise {
    private static final Logger LOGGER = LogManager.getLogger(com.solvd.laba.service.impl.jdbc.MyServiceImpl.class);
    private static MyBatis MyBatisFactory;
    private final static SqlSessionFactory factory = MyBatis.getSessionFactory();

    @Override
    public void doSmth() {

    }

    @Override
    public Object getById(Object id) {
        Project project = null;
        try {
            SqlSession sqlSession = factory.openSession();
            ProjectImpl project1 = sqlSession.getMapper(ProjectImpl.class);
            project = (Project) project1.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public Object setById(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object checkDb(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }

    @Override
    public Object getProject(Object id) {
        Project project = null;
        try {
            SqlSession sqlSession = factory.openSession();
            ProjectImpl projec = sqlSession.getMapper(ProjectImpl.class);
            project = (Project) projec.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public Object setProject(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for MyBatis Service");
    }
}
