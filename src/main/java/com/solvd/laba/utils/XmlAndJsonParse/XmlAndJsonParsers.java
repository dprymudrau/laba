package com.solvd.laba.utils.XmlAndJsonParse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.Main;
import com.solvd.laba.binary.City;
import com.solvd.laba.binary.DepartmentName;
import com.solvd.laba.binary.Emails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

public class XmlAndJsonParsers {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public XmlAndJsonParsers() {
    }

    public static void staxParser() {     //->>>>> STAX Parser <<<<<-
        String STAXFileName = "src/main/resources/xmlAndJsonParsers/Stax.xml";
        List<City> cityList = Stax.parseXmlByStax(STAXFileName);
        for (City city : cityList) {
            LOGGER.info(city.toString());
        }
    }

    public static void jaxbParser() {    //->>>>> JAXB Parser <<<<<-
        String JAXBFileNameToSave = "src/main/resources/xmlAndJsonParsers/JaxbW.xml";
        String JAXBFileNameToRead = "src/main/resources/xmlAndJsonParsers/JaxbR.xml";
        new DateAdapter();   //date adapter

        DepartmentName departmentName = new DepartmentName();
        departmentName.setDepartmentName("Department6");
        departmentName.setItCompaniesId(15);
        Jaxb.convertObjectToXml(departmentName, JAXBFileNameToSave);//save the object to XML file
        DepartmentName unmarshalDepartmentName = Jaxb.fromXmlToObject(JAXBFileNameToRead);    //restoring an object from an XML file
        if (unmarshalDepartmentName != null) {
            LOGGER.info(unmarshalDepartmentName.toString());
        }

    }

    public static void jacksonParser() {         //->>>>> JACKSON Parser <<<<<-
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

        String jsonString = "{ \"emails\":\"mail\"}";
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper1 = new ObjectMapper();
        try {
            Emails email = mapper1.readValue(reader, Emails.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @XmlElement(name = "published", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date published;
}
