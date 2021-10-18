package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;
import com.solvd.laba.dao.impl.jdbc.HospitalDAOImpl;
import com.solvd.laba.dao.impl.jdbc.VisitorAgeGroupCategoryDAOImpl;
import com.solvd.laba.dao.impl.jdbc.VisitorCategoryDAOImpl;
import com.solvd.laba.dao.interfaces.*;
import com.solvd.laba.service.IRegistrationCardService;
import com.solvd.laba.util.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationCardService implements IRegistrationCardService {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCardService.class);
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    public ArrayList<RegistrationCard> getAllRegCards() {
        ArrayList<RegistrationCard> cards;
        try(SqlSession sqlSession = factory.openSession()) {
            IRegistrationCardDAO dao = sqlSession.getMapper(IRegistrationCardDAO.class);
            cards = dao.getAll();
        }
        return cards;
    }

    public void addRegCardToTable(RegistrationCard newRegCard) {
        try(SqlSession sqlSession = factory.openSession()) {
            IRegistrationCardDAO dao = sqlSession.getMapper(IRegistrationCardDAO.class);
            try {
                dao.insertToTable(newRegCard);
                sqlSession.commit();
                LOGGER.debug("RegCard was added to BDTable");
            } catch (Exception e) {
                sqlSession.rollback();
                LOGGER.error(e);
            }
        }
    }

    public RegistrationCard findRegCardByVisitorId(int visitorId) {
        RegistrationCard regCard;

        try(SqlSession sqlSession = factory.openSession()) {
            IRegistrationCardDAO dao = sqlSession.getMapper(IRegistrationCardDAO.class);
            regCard = dao.getByVisitorId(visitorId);
        }
        return regCard;
    }

    public RegistrationCard createRegCardForNewVisitorByConsole(int newRegCardId, Visitor newVisitor) {
        Scanner scanner = new Scanner(System.in);
        RegistrationCard newRegistrationCard = new RegistrationCard();
        IHospitalDAO hospitalDAO = new HospitalDAOImpl();
        IVisitorAgeGroupCategoryDAO ageGroupCategoryDAO = new VisitorAgeGroupCategoryDAOImpl();
        IVisitorCategoryDAO categoryDAO = new VisitorCategoryDAOImpl();
        boolean correct;
        int id;
        do {
            hospitalDAO.printAll();
            LOGGER.info("Please, choose id from the Hospitals list: ");
            id = scanner.nextInt();
            if (id > hospitalDAO.getAll().size() || id <= 0) {
                LOGGER.info("Incorrect value. Please try again...");
                correct = false;
            } else correct = true;
        } while (!correct);
        correct = false;
        newRegistrationCard.setIdHospital(id);
        newRegistrationCard.setIdVisitor(newVisitor.getId());
        do {
            ageGroupCategoryDAO.printAll();
            LOGGER.info("Please, choose id from the AgeGroupCategory list: ");
            id = scanner.nextInt();
            if (id > ageGroupCategoryDAO.getAll().size() || id <= 0) {
                LOGGER.info("Incorrect value. Please try again...");
                correct = false;
            } else correct = true;
        } while (!correct);
        correct = false;
        newRegistrationCard.setIdVisitorAgeGroupCategory(id);
        do {
            categoryDAO.printAll();
            LOGGER.info("Please, choose id from the VisitorCategory list: ");
            id = scanner.nextInt();
            if (id > categoryDAO.getAll().size() || id <= 0) {
                LOGGER.info("Incorrect value. Please try again...");
                correct = false;
            } else correct = true;
        } while (!correct);
        newRegistrationCard.setIdVisitorCategory(id);
        return newRegistrationCard;
    }

}
