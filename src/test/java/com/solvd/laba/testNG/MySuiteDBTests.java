package com.solvd.laba.testNG;
import com.solvd.laba.binary.Emploee;
import com.solvd.laba.binary.Project;
import com.solvd.laba.dao.impl.jdbc.EmploeeDAOImpl;
import com.solvd.laba.dao.impl.jdbc.ProjectDAOImpl;

import org.testng.Assert;
import org.testng.annotations.Test;


public class MySuiteDBTests {
    @Test
    public void employeeGetcCPatronymicTest(){
        EmploeeDAOImpl employee = new EmploeeDAOImpl();
        Emploee employee1 = employee.getById(1L);
        Assert.assertEquals(employee1.getcCPatronymic(),null);
    }
    @Test
    public void employeeGetcProjectIDTest(){
        EmploeeDAOImpl employee = new EmploeeDAOImpl();
        Emploee employee1 = employee.getById(1L);
        Assert.assertEquals(employee1.getProjectID(),0);
    }
    @Test
    public void projectNameTest(){
        ProjectDAOImpl project = new ProjectDAOImpl();
        project.setProject("New Project Name");
        Project expextedProject = new Project();
        expextedProject.setProject("Pr1");
        expextedProject.setDepartmentNameId(1);
        expextedProject.setDepartmentNameIdItCompaniesID(3);
        Assert.assertEquals(project.getById(5L),expextedProject,"test message");
    }
    @Test
    public void projectGetByIdTest(){
        ProjectDAOImpl project = new ProjectDAOImpl();
        project.getById(3L);
        Assert.assertEquals(project.toString(), "Project{id=0, project='Project3-dolor', departmentNameId=0, departmentNameIdItCompaniesID=0}");
    }
    @Test
    public void emploeeTest(){
        EmploeeDAOImpl employee = new EmploeeDAOImpl();
        Emploee employee1 = employee.getById(1L);
        Assert.assertEquals(employee1.getcCName(),"Name1");
    }


}
