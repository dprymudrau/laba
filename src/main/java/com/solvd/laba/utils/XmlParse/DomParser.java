package com.solvd.laba.utils.XmlParse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DomParser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);

    private static void addElement(Document doc) {
        NodeList users = doc.getElementsByTagName("User");
        Element lang = null;

        //see each element Language
        for(int i=0; i<users.getLength(); i++){
            lang = (Element) users.item(i);
            Element paradigmElement = doc.createElement("paradigm");
            paradigmElement.appendChild(doc.createTextNode("street"));
            lang.appendChild(paradigmElement);
        }
    }

    // change meaning existing element name
    private static void updateElementValue(Document doc) {
        NodeList users = doc.getElementsByTagName("User");
        Element lang = null;
        // see each element Language
        for(int i=0; i<users.getLength();i++){
            lang = (Element) users.item(i);
            Node name = lang.getElementsByTagName("name").item(0).getFirstChild();
            name.setNodeValue(name.getNodeValue().toUpperCase());
        }
    }

    public static void domParser() {
        String filePath = "user.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // update meanings
            updateElementValue(doc);

            // add new element
            addElement(doc);

            // write ready element in file
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("userUpdated.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            System.out.println("XML was changed successfully!");

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
