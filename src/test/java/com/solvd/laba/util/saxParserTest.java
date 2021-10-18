package com.solvd.laba.util;

import com.solvd.laba.binary.Visitor;
import com.solvd.laba.util.sax.SAXRunner;
import com.solvd.laba.util.sax.XMLHandler;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;
import java.util.ArrayList;

public class saxParserTest {

    @Test
    public void saxParsingTest() throws ParseException {
        SAXRunner.readXML();
        ArrayList<Visitor> xmlListVisitors = new ArrayList<>() {
            {
                add(new Visitor(10, "Aleksandr", "Pushkin", DateConverter.getSqlDate("1990-02-14"), "Minsk", "Acute respiratory illness", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(11, "Alexey", "Dudko", DateConverter.getSqlDate("1984-05-10"), "Minsk", "Acute respiratory illness", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(12, "Dmitriy", "Topol", DateConverter.getSqlDate("1990-07-10"), "Minsk", "Covid", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(13, "Sergey", "Zavezin", DateConverter.getSqlDate("2001-01-07"), "Minsk", "Covid", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(14, "Kirill", "Motylev", DateConverter.getSqlDate("1999-03-19"), "Minsk", "Covid", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(15, "Vasiliy", "Shved", DateConverter.getSqlDate("2002-07-25"), "Minsk", "Bronchitis", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(16, "Andrey", "Danilchenko", DateConverter.getSqlDate("2012-11-28"), "Minsk", "Vomit", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(17, "Andrey", "Malishev", DateConverter.getSqlDate("1970-12-29"), "Minsk", "Covid", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(18, "Anton", "Klichko", DateConverter.getSqlDate("1981-12-12"), "Minsk", "Covid", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(19, "Anton", "Zavadskiy", DateConverter.getSqlDate("1983-06-01"), "Minsk", "Alcohol poisoning", DateConverter.getSqlDate("2021-10-11"), null));
                add(new Visitor(20, "Yaroslav", "Kazakov", DateConverter.getSqlDate("1951-04-03"), "Minsk", "Covid", DateConverter.getSqlDate("2021-10-11"), null));
            }
        };
        ArrayList<Visitor> parsingVisitors = XMLHandler.getVisitors();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(xmlListVisitors.size() == parsingVisitors.size());
        softAssert.assertEquals(parsingVisitors, xmlListVisitors);
        softAssert.assertAll();
    }
}
