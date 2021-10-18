package com.solvd.laba.service.impl.myBatis;

import com.solvd.laba.binary.RegistrationCard;
import com.solvd.laba.binary.Visitor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.ArrayList;

public class DoctorServiceTest {

    @Test
    public void patientExaminationTest() {
        DoctorServiceImpl docService = new DoctorServiceImpl();
        VisitorService visitorService = new VisitorService();
        RegistrationCardService regCardService = new RegistrationCardService();
        Visitor visitorBeforeExamination = new Visitor(99, "nameTest", "surnameTest", new Date(0000-00-00), "addressTest", "Covid", new Date(0000-00-00), new Date(0000-00-00));
        RegistrationCard card = new RegistrationCard(99, 8, 99, 3, 5);
        visitorService.insertVisitor(visitorBeforeExamination);
        regCardService.addRegCardToTable(card);
        docService.patientExamination(visitorBeforeExamination);
        ArrayList<Visitor> visitors = visitorService.getAllVisitors();
        Visitor visitorAfterExamination = visitors.get(visitors.size() -1);
        Assert.assertNotEquals(visitorBeforeExamination, visitorAfterExamination);
    }
}
