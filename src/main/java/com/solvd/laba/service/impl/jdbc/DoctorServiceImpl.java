package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;
import com.solvd.laba.dao.impl.jdbc.DoctorDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class DoctorServiceImpl extends DoctorDAOImpl implements DoctorService {
    private static final Logger LOGGER = LogManager.getLogger(DoctorServiceImpl.class);

    public void patientExamination(Visitor visitor) {
        RegistrationCardServiceImpl service = new RegistrationCardServiceImpl();
        RegistrationCard identifiedRegCard = service.findRegCardByVisitorId(visitor.getId());
        int currentPatientHealthCondition = identifiedRegCard.getIdVisitorCategory();
        boolean covidCheck = "Covid".equals(visitor.getDiagnosis());

        if ((!covidCheck) && currentPatientHealthCondition < 3) {
            LOGGER.info("My congratulations! You are healthy!");
        } else if (currentPatientHealthCondition == 7) {
            LOGGER.info("Poor poor dude... Amen!");
        } else {
            int newHealthCondition;
            if (covidCheck) {
                newHealthCondition = new Random().nextInt(4);
            } else {
                newHealthCondition = new Random().nextInt(3);
            }
            switch (newHealthCondition) {
                case (0):
                    identifiedRegCard.setIdVisitorCategory(2);
                    LOGGER.info("My congratulations! You are healthy!");
                    break;
                case (1):
                    identifiedRegCard.setIdVisitorCategory(currentPatientHealthCondition - 1);
                    LOGGER.info("Looks better!");
                    break;
                case (2):
                    identifiedRegCard.setIdVisitorCategory(currentPatientHealthCondition + 1);
                    LOGGER.info("Oh my gosh! Nurse, nurse, injection!");
                    break;
                default:
                    identifiedRegCard.setIdVisitorCategory(7);
                    LOGGER.info("Poor poor dude... Amen!");
            }
            service.updateEntityRow(identifiedRegCard);
        }
    }

    public void patientExamination(ArrayList<Visitor> visitors) {

    }
}
