package com.solvd.laba.util;

import com.solvd.laba.binary.Visitor;
import com.solvd.laba.util.jaxb.JAXBImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jaxbParserTest {

    @Test
    public void jaxbParsingTest() {
        String filePath = "src/main/resources/Visitor.xml";
        Visitor visitorToXml = new Visitor(99, "TestName", "Test", DateConverter.getUtilDate("1986-04-09"), "Minsk", "Covid", DateConverter.getUtilDate("2021-10-07"), DateConverter.getUtilDate("2021-12-09"));
        JAXBImpl jaxb = new JAXBImpl();
        jaxb.marshal(visitorToXml, filePath);
        Visitor visitorFromXml = jaxb.unmarshal(filePath);
        Assert.assertEquals(visitorFromXml, visitorToXml);
    }
}
