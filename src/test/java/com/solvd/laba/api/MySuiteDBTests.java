package com.solvd.laba.api;
import com.solvd.laba.binary.Adress;
import com.solvd.laba.binary.Emploee;
import com.solvd.laba.dao.jdbc.impl.EmploeeDAOImpl;
import com.solvd.laba.dao.jdbc.impl.ProjectDAOImpl;
import org.junit.Assert;
import org.junit.Test;


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
        Assert.assertEquals(project.getById(5L), "Project{id=0, project='Project5-amet', departmentNameId=0, departmentNameIdItCompaniesID=0}");
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
