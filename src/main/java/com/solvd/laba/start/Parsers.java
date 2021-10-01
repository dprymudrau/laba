package com.solvd.laba.start;

import com.solvd.laba.pojo.Drivers;
import com.solvd.laba.pojo.Cars;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import static com.solvd.laba.start.XMLstaxParser.parseXmlByStax;

public class Parsers {
    private static final Logger LOGGER = LogManager.getLogger(Parsers.class);

    public Parsers() {
    }

    public static void staxParser() {
        String STAXFileName = "src/main/resources/Stax.xml";
        List<Drivers> cityList = XMLstaxParser.parseXmlByStax(STAXFileName);
        for (Drivers city : cityList) {
            LOGGER.info(city.toString());
        }
    }

    public static void jaxbParser() {
        String JAXBFileNameToSave = "src/main/resources/JaxbW.xml";
        String JAXBFileNameToRead = "src/main/resources/JaxbX.xml";
        Cars departmentName = new Cars();
        departmentName.setCarName("Toyota");
        departmentName.setTaxiCompaniesId(20);
        Jaxb.convertObjectToXml(departmentName, JAXBFileNameToSave);
        Cars unmarshalDepartmentName = Jaxb.fromXmlToObject(JAXBFileNameToRead);
        if (unmarshalDepartmentName != null) {
            LOGGER.info(unmarshalDepartmentName.toString());
        }
    }
}
