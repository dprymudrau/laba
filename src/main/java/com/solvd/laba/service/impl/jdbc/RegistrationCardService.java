package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;
import com.solvd.laba.dao.impl.jdbc.*;
import com.solvd.laba.dao.interfaces.*;
import com.solvd.laba.service.IRegistrationCardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class RegistrationCardService extends RegistrationCardDAOImpl implements IRegistrationCardService {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCardService.class);

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
