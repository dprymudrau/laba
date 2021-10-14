package com.solvd.laba.service.impl.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.Main;
import com.solvd.laba.binary.City;
import com.solvd.laba.binary.DepartmentName;
import com.solvd.laba.binary.Emails;
import com.solvd.laba.utils.XmlAndJsonParse.Jaxb;
import com.solvd.laba.utils.XmlAndJsonParse.Stax;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

public class ParserServiseImpl {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void staxParser(String path) {
        String STAXFileName = path;
        List<City> cityList = Stax.parseXmlByStax(STAXFileName);
        for (City city : cityList) {
            LOGGER.info(city.toString());
        }
    }

    public static void jaxbParser(String readString, String writeString) {
        String JAXBFileNameToSave = writeString;
        String JAXBFileNameToRead = readString;

        DepartmentName departmentName = new DepartmentName();
        departmentName.setDate(new Date());
        departmentName.setDepartmentName("Department6");
        departmentName.setItCompaniesId(15);
        Jaxb.convertObjectToXml(departmentName, JAXBFileNameToSave);//save the object to XML file
        DepartmentName unmarshalDepartmentName = Jaxb.fromXmlToObject(JAXBFileNameToRead);    //restoring an object from an XML file
        if (unmarshalDepartmentName != null) {
            LOGGER.info(unmarshalDepartmentName.toString());
        }
        departmentName.setDate(new Date());

    }

    public static void jacksonParser(String string) {
        Emails emails = new Emails();
        emails.setEmails("Mail6");
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, emails);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        LOGGER.info(result);

        String jsonString = string;
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper1 = new ObjectMapper();
        try {
            Emails email = mapper1.readValue(reader, Emails.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
