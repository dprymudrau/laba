package com.solvd.laba.utils;


import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.jdbc.impl.*;
import com.solvd.laba.service.MyService;
import com.solvd.laba.service.ProjectServise;
import com.solvd.laba.service.SetContactData;
import com.solvd.laba.service.SetNameServise;
import com.solvd.laba.service.impl.jdbc.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessLogic {
    private static final Logger LOGGER = LogManager.getLogger();

    public static void businessLogic(){

        LOGGER.info("Start \"JDBC/MyBATIS\".");
        MyService myService = new MyServiceImpl();
        ProjectServise projectServise = new ProjectImpl();
        SetContactData sCData = new CustContactDataImpl();
        SetContactData sItData = new ItContactDataImpl();
        SetNameServise sCName = null;
        sCName = new SetCustNameImpl(sCName);
        SetNameServise sItName = null;
        sItName = new SetItNameImpl(sItName);
        myService.doSmth();

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
