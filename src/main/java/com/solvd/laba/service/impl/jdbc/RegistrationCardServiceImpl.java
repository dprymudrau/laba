package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;
import com.solvd.laba.binary.VisitorAgeGroupCategory;
import com.solvd.laba.dao.impl.jdbc.HospitalDAOImpl;
import com.solvd.laba.dao.impl.jdbc.RegistrationCardDAOImpl;
import com.solvd.laba.dao.impl.jdbc.VisitorAgeGroupCategoryDAOImpl;
import com.solvd.laba.dao.impl.jdbc.VisitorCategoryDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationCardServiceImpl<T> extends RegistrationCardDAOImpl implements RegistrationCardService<Integer>{
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCardServiceImpl.class);

    public RegistrationCard findRegCardByVisitorId(Integer visitorId) {
        RegistrationCardDAOImpl regCard = new RegistrationCardDAOImpl();
        ArrayList<RegistrationCard> regCards = regCard.getAllWithFilter("idVisitor = " + visitorId);

        if (!regCards.isEmpty()) {
            return regCards.get(0);
        } else throw new NullPointerException();
    }

    public RegistrationCard createRegCardForNewVisitor(Visitor newVisitor) {
        Scanner scanner = new Scanner(System.in);
        RegistrationCard newRegistrationCard = new RegistrationCard();
        HospitalDAOImpl hospitalDAO = new HospitalDAOImpl();
        VisitorAgeGroupCategoryDAOImpl ageGroupCategoryDAO = new VisitorAgeGroupCategoryDAOImpl();
        VisitorCategoryDAOImpl categoryDAO = new VisitorCategoryDAOImpl();
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
            categoryDAO.getAll();
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

    private void survey(T dao) {

    }
}
