package com.solvd.laba.utils.parsers.jaxb;

import com.solvd.laba.binary.Car;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class JaxbContext {
    public void marshall() throws JAXBException, IOException {
        Car car = new Car();
        car.setCarId(1);
        car.setCarName("BMW");
        car.setDateOfConstruct(new Date());

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(car, new File("src/main/resources/JaxbW.xml"));
    }

    public Car unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Car.class);
        return (Car) context.createUnmarshaller()
                .unmarshal(new FileReader("src/main/resources/JaxbW.xml"));
    }
}
