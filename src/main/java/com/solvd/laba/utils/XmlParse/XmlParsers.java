package com.solvd.laba.utils.XmlParse;

import com.solvd.laba.Main;
import com.solvd.laba.poJo.City;
import com.solvd.laba.poJo.DepartmentName;
import com.solvd.laba.utils.XmlParse.Stax;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class XmlParsers {
private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public XmlParsers() {

        //->>>>> STAX Parser <<<<<-
        String STAXFileName = "src/main/resources/Stax.xml";
        List<City> cityList = Stax.parseXmlByStax(STAXFileName);
        for (City city : cityList) {
            LOGGER.info(city.toString());
        }

        //->>>>> JAXB Parser <<<<<-
        String JAXBFileNameToSave = "src/main/resources/JaxbW.xml";
        String JAXBFileNameToRead = "src/main/resources/JaxbR.xml";
        DepartmentName departmentName = new DepartmentName();
        departmentName.setDepartmentName("Department6");
        departmentName.setItCompaniesId(15);
        Jaxb.convertObjectToXml(departmentName, JAXBFileNameToSave);//save the object to XML file
        DepartmentName unmarshalDepartmentName = Jaxb.fromXmlToObject(JAXBFileNameToRead);    //restoring an object from an XML file
        if (unmarshalDepartmentName != null) {
            LOGGER.info(unmarshalDepartmentName.toString());
        }

        //->>>>> JACKSON Parser <<<<<-

        //->>>>> MyBATIS Parser <<<<<-


    }
}
