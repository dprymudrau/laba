package com.solvd.hospital.hospitalization;

import com.solvd.hospital.assignment.Changes;
import com.solvd.hospital.head.Examination;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class Hospitalization implements Changes {

    private long id;
    private Date startDate;
    private Date endDate;
    private Examination dischargeExamination;
    private List<Examination> intermediateExaminations;

    public Hospitalization() {
    }

    public Hospitalization(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Examination getDischargeExamination() {
        return dischargeExamination;
    }

    public List<Examination> getIntermediateExaminations() {
        return intermediateExaminations;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDischargeExamination(Examination dischargeExamination) {
        this.dischargeExamination = dischargeExamination;
    }

    public void setIntermediateExaminations(List<Examination> intermediateExaminations) {
        this.intermediateExaminations = intermediateExaminations;
    }


    @Override
    public int hashCode() {

        return Objects.hash(id, startDate, endDate, dischargeExamination, intermediateExaminations);
    }


    @Override
    public void setHomePatient(String name) {

    }

    @Override
    public void setVisitingPatient(String name) {

    }

    @Override
    public void homePatientData(int points) {

    }

    @Override
    public void changeDoctor() {

    }
}
