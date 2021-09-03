package com.solvd.hospital.head;


import com.solvd.hospital.general.Operation;
import com.solvd.hospital.general.Pills;
import com.solvd.hospital.general.Procedure;

import java.util.Collections;
import java.util.List;


public class PatientDatum {

    // FIELDS
    private int idstatus;
    private String status;
    private String personname;
    private String password;
    private String name;
    private String surname;
    private String diagnosis;
    private List<Pills> personDrugsList;
    private List<Operation> personOperationList;
    private List<Procedure> personProceduresList;

    // CONSTRUCTORS
    public void Person() {
        idstatus = 1;
        diagnosis = "Здоров";
    }
    public void Person(int idstatus, String status, String personname, String password, String name, String surname, String diagnosis, List<Pills> userDrugsList, List<Operation> userOperationList, List<Procedure> userProceduresList) {
        this.idstatus = idstatus;
        this.status = status;
        this.personname = personname;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.diagnosis = diagnosis;
        Collections.copy(this.personDrugsList, userDrugsList);
        Collections.copy(this.personOperationList, userOperationList);
        Collections.copy(this.personProceduresList, userProceduresList);
    }


    public int getIdstatus() {
        return idstatus;
    }
    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersonname() {
        return personname;
    }
    public void setPersonname(String username) {
        this.personname = personname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<Pills> getPersonDrugsList() {
        return personDrugsList;
    }
    public void setPersonDrugsList(List<Pills> userDrugsList) {
        this.personDrugsList = personDrugsList;
    }

    public List<Operation> getPersonOperationList() {
        return personOperationList;
    }
    public void setPersonOperationList(List<Operation> userOperationList) {
        this.personOperationList = personOperationList;
    }

    public List<Procedure> getPersonProceduresList() {
        return personProceduresList;
    }
    public void setPersonProceduresList(List<Procedure> personProceduresList) {
        this.personProceduresList = personProceduresList;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idstatus=" + idstatus + '\'' +
                ", status='" + status + '\'' +
                ", personname='" + personname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", personDrugsList=" + personDrugsList +
                ", personOperationList=" + personOperationList +
                ", personProceduresList=" + personProceduresList +
                '}';
    }

}


