package com.solvd.laba.utils.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.laba.binary.City;
import com.solvd.laba.utils.parsers.jaxb.DateAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

public class JacksonParser {
    private static final Logger LOGGER = LogManager.getLogger();
    public static void jacksonParser() {
        City city = new City();
        city.setId(1);
        city.setName("Lviv");
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(writer, city);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = writer.toString();
        LOGGER.info(result);


    }
    @XmlElement(name = "published", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
}
