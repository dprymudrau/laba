package com.solvd.laba.utils;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.jdbc.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessLogic {
    private static final Logger LOGGER = LogManager.getLogger(BusinessLogic.class);

    public static void businessLogic(){
        EmploeeDAOImpl employee = new EmploeeDAOImpl();
        Emploee employee1 = employee.getById(1L);          //get a customer
        employee1.setProjectID(3);                         //set Project to customer
        ProjectDAOImpl project = new ProjectDAOImpl();
        project.getById(3L);                               //get this proj by id
        project.setProject("New Project Name");            //set new name
        project.setDepartmentNameId("2");                  // set dep name
        ITCompanyContactDAOImpl itContact = new ITCompanyContactDAOImpl();
        itContact.setCustumerContactID(2);                // set emploee contact
        itContact.setEmailsID(1);                         // set contact email
        TasksDAOImpl task = new TasksDAOImpl();
        task.setTask("newTask");                            // set new Task
        СustomerСontactDAOImpl custСontact = new СustomerСontactDAOImpl();
        custСontact.setEmailsID(2);

    }

}
