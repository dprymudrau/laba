package com.solvd.laba.utils;

import com.solvd.laba.service.impl.myBatis.*; //jdbc or myBatis
import com.solvd.laba.binary.*;
import com.solvd.laba.binary.Emploee;
import com.solvd.laba.service.*;
import com.solvd.laba.dao.impl.jdbc.*; //only Dao
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessLogic {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void businessLogic(){

        LOGGER.info("Start \"JDBC/MyBATIS\".");
        MyService myService = null;
        myService= new MyServiceImpl(myService);
        ProjectServise projectServise = new ProjectImpl();
        SetContactData sCData= new CustContactImpl();
        SetContactData sItData= new ItContactImpl();
        SetNameServise sCName = new CustNameImpl();
        SetNameServise sItName = new ItNameImpl();

        myService.doSmth();
        projectServise.getProject("Proj d");
        sCData.emailsID("Mail@mail.com");
        sItData.phoneNumbersID("2-3-4");
        sCName.setCCName("Set New Name");
        sItName.setCCName("SetNeWItName");

        EmploeeDAOImpl employee = new EmploeeDAOImpl();
        Emploee employee1 = employee.getById(1L);          //get a customer   cCName='Name1'
        employee1.setProjectID(3);                         //set Project to customer
        ProjectDAOImpl project = new ProjectDAOImpl();
        project.getById(3L);                               //get this proj by id Project{id=0, project='Project3-dolor', departmentNameId=0, departmentNameIdItCompaniesID=0}
        project.setProject("New Project Name");            //set new name
        project.setDepartmentNameId("2");                  // set dep name
        ITCompanyContactDAOImpl itContact = new ITCompanyContactDAOImpl();
        itContact.setCustumerContactID(2);                // set emploee contact
        itContact.setEmailsID(1);                         // set contact email
        TasksDAOImpl task = new TasksDAOImpl();
        task.setTask("newTask");                            // set new Task
        СustomerСontactDAOImpl custСontact = new СustomerСontactDAOImpl();
        custСontact.setEmailsID(2);

        ParserServiseImpl.staxParser("src/main/resources/xmlAndJsonParsers/Stax.xml");
        ParserServiseImpl.jaxbParser("src/main/resources/xmlAndJsonParsers/JaxbR.xml", "src/main/resources/xmlAndJsonParsers/JaxbW.xml");
        ParserServiseImpl.jacksonParser("{ \"emails\":\"mail\"}");
        LOGGER.info("End \"JDBC/MyBATIS\".");
    }

}
