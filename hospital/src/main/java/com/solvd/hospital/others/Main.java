package com.solvd.hospital.others;

import com.solvd.hospital.head.*;
import com.solvd.hospital.hospitalization.Hospitalization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("Welcome.");

        PatientDatum patient = new PatientDatum ();
        Diagnose diagnose = new Diagnose();
        Assignment assignment = new Assignment();
        Examination examination = new Examination();
        Photo photo = new Photo();
        Hospitalization hospitalization = new Hospitalization();



    }

}
