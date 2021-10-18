package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;
import com.solvd.laba.dao.interfaces.IRegistrationCardDAO;
import com.solvd.laba.service.IDoctorService;
import com.solvd.laba.util.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class DoctorServiceImpl implements IDoctorService {
    private static final Logger LOGGER = LogManager.getLogger(DoctorServiceImpl.class);
    private final static SqlSessionFactory factory = MyBatisFactory.getSessionFactory();

    @Override
    public void patientExamination(Visitor visitor) {
        try(SqlSession sqlSession = factory.openSession()) {
            RegistrationCardService service = new RegistrationCardService();
            RegistrationCard identifiedRegCard = service.findRegCardByVisitorId(visitor.getId());
            IRegistrationCardDAO regCardDAO = sqlSession.getMapper(IRegistrationCardDAO.class);
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
                try {
                    regCardDAO.updateEntityRow(identifiedRegCard);
                    sqlSession.commit();
                } catch (Exception e) {
                    sqlSession.rollback();
                    LOGGER.error(e);
                }
            }
        }
    }

}
