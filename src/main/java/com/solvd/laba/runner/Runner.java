package com.solvd.laba.runner;

import com.solvd.laba.binary.Car;
import com.solvd.laba.binary.Visitor;
import com.solvd.laba.dao.impl.jdbc.CarDAOImpl;
import com.solvd.laba.dao.impl.jdbc.CarFleetDAOImpl;
import com.solvd.laba.dao.impl.jdbc.VisitorDAOImpl;
import com.solvd.laba.service.impl.jdbc.CarFleetServiceImpl;
import com.solvd.laba.service.impl.jdbc.DoctorServiceImpl;
import com.solvd.laba.util.sax.SAXRunner;
import com.solvd.laba.util.sax.XMLHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
//        MyConnectionPool connections = MyConnectionPool.getInstance();
//
//        new MyThread("01", connections);
//        new MyThread("02", connections);
//        new MyThread("03", connections);
//        new MyThread("04", connections);
//        new MyThread("05", connections);
//        new MyThread("06", connections);

        CarDAOImpl dao = new CarDAOImpl();
        dao.printByFilter("idCarFleet = 1");
        dao.printAll();
//        CarFleetServiceImpl carFleetService = new CarFleetServiceImpl();
//        Car car = new Car(3, "BMW", "X6", "1378HM-7", 1);
//        carFleetService.insertNewCarToFleet(1, car);

        System.out.println();
        SAXRunner.readXML();
        ArrayList<Visitor> visitors = XMLHandler.getVisitors();
        visitors.forEach(System.out::println);
        VisitorDAOImpl visitorDAO = new VisitorDAOImpl();
//        for (Visitor visitor : visitors) {
//            visitorDAO.insertToTable(visitor.getName(), visitor.getSurname(), visitor.getBirthday(),
//                    visitor.getAddress(), visitor.getDiagnosis(), visitor.getVisitDate(), visitor.getDischargeDate());
//        }


        DoctorServiceImpl docService = new DoctorServiceImpl();

    }
}
