package com.solvd.laba.util.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.sql.Date;


@XmlRootElement (name = "RegistrationCard")
@XmlType(propOrder = {"RegistrationCardId"})
public class FullRegCardInfo {
    private int regCardId;
    private String hospitalName;
    private String hospitalAddress;
    private String visitorName;
    private String visitorSurname;
    private Date visitorBirthday;
    private String diagnosis;
    private Date visitDate;
    private Date dischargeDate;
    private String ageGroupCategory;
    private String healthConditionCategory;
    private String visitCategory;

    public int getRegCardId() {
        return regCardId;
    }

    public void setRegCardId(int regCardId) {
        this.regCardId = regCardId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorSurname() {
        return visitorSurname;
    }

    public void setVisitorSurname(String visitorSurname) {
        this.visitorSurname = visitorSurname;
    }

    public Date getVisitorBirthday() {
        return visitorBirthday;
    }

    public void setVisitorBirthday(Date visitorBirthday) {
        this.visitorBirthday = visitorBirthday;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getAgeGroupCategory() {
        return ageGroupCategory;
    }

    public void setAgeGroupCategory(String ageGroupCategory) {
        this.ageGroupCategory = ageGroupCategory;
    }

    public String getHealthConditionCategory() {
        return healthConditionCategory;
    }

    public void setHealthConditionCategory(String healthConditionCategory) {
        this.healthConditionCategory = healthConditionCategory;
    }

    public String getVisitCategory() {
        return visitCategory;
    }

    public void setVisitCategory(String visitCategory) {
        this.visitCategory = visitCategory;
    }
}
