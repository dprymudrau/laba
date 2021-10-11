package com.solvd.laba.api;

import com.solvd.laba.binary.*;
import org.junit.Assert;
import org.junit.Test;

public class MySuiteSimpleTessts {
    @Test
    public void itCompaniesTest(){
        ITCompanies itCompanies = new ITCompanies();
        itCompanies.setCompaniName("Name2");
        Assert.assertEquals(itCompanies.getCompaniName(), "Name2");
    }
    @Test
    public void itCompanyContactTest(){
        ITCompanyContact itcc = new ITCompanyContact();
        itcc.setiTCCName("NameCompany");
        Assert.assertEquals(itcc.getiTCCName(), "NameCompany");
    }
    @Test
    public void phoneNumbersTest(){
        PhoneNumbers phNumb = new PhoneNumbers();
        phNumb.setPhoneNumbers("123");
        Assert.assertEquals(phNumb.getPhoneNumbers(), "123");
    }
    @Test
    public void positioneTest(){
        Positione positione = new Positione();
        positione.setPositione("posit1");
        Positione positione2 = new Positione();
        positione.setPositione("posit2");
        Assert.assertEquals(positione.hashCode(), positione2.hashCode());
    }
    @Test
    public void projectTest(){
        Project project = new Project();
        project.setProject("pro1");
        Project project1 = new Project("pro1");
        Assert.assertEquals(project.hashCode(), project1.hashCode());
    }
}
