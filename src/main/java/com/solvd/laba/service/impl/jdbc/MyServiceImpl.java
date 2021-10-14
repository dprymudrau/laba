package com.solvd.laba.service.impl.jdbc;

import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.impl.jdbc.*;
import com.solvd.laba.service.MyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyServiceImpl implements MyService {
    private static final Logger LOGGER = LogManager.getLogger(MyServiceImpl.class);

    @Override
    public void doSmth() {
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
    }

    @Override
    public Object getById(Object id) {
        return null;
    }

    @Override
    public Object setById(Object id) {
        throw new UnsupportedOperationException("This method isn't implemented for Jdbc Service");
    }

    @Override
    public Object checkDb(Object id) {
        return null;
    }

}
