package com.solvd.laba.runner;

import com.solvd.laba.service.impl.jdbc.DoctorServiceImpl;
import com.solvd.laba.util.jaxb.FullRegCardInfo;
import com.solvd.laba.util.jaxb.JAXBImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws JAXBException {
//        MyConnectionPool connections = MyConnectionPool.getInstance();
//
//        new MyThread("01", connections);
//        new MyThread("02", connections);
//        new MyThread("03", connections);
//        new MyThread("04", connections);
//        new MyThread("05", connections);
//        new MyThread("06", connections);

//        CarDAOImpl dao = new CarDAOImpl();
//        dao.printByFilter("idCarFleet = 1");
//        dao.printAll();
//        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
//        Car car = new Car(3, "BMW", "X6", "1378HM-7", 1);
//        carFleetService.insertNewCarToFleet(1, car);

//        System.out.println();
//        SAXRunner.readXML();
//        ArrayList<Visitor> visitors = XMLHandler.getVisitors();
//        visitors.forEach(System.out::println);
//        VisitorDAOImpl visitorDAO = new VisitorDAOImpl();
//        for (Visitor visitor : visitors) {
//            visitorDAO.insertToTable(visitor.getName(), visitor.getSurname(), visitor.getBirthday(),
//                    visitor.getAddress(), visitor.getDiagnosis(), visitor.getVisitDate(), visitor.getDischargeDate());
//        }

        FullRegCardInfo frci = new FullRegCardInfo();
        frci.setVisitorName("Robert");
        frci.setDiagnosis("Covid");
        JAXBImpl jaxb = new JAXBImpl();
        System.out.println(jaxb.marshaller(frci));

        String xmldata = ""


        DoctorServiceImpl docService = new DoctorServiceImpl();

    }
}
