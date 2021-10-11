package com.solvd.laba.utils.XmlParse;


import com.solvd.laba.binary.OrdersProducts;
import org.apache.logging.log4j.core.config.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class DomParser {
    private static ArrayList<OrdersProducts> employees = new ArrayList<>();

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    DocumentBuilder builder = factory.newDocumentBuilder();

    Document document = builder.parse(new File(""));

    NodeList productElements = document.getDocumentElement().getElementsByTagName("product");

        for (int i = 0; i < productElements.getLength(); i++) {
        Node employee = productElements.item(i);

        NamedNodeMap attributes = productElements.getAttributes();

            }
}
