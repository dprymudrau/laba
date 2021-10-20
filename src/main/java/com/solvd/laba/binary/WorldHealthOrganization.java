package com.solvd.laba.binary;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

public class WorldHealthOrganization {
    @JsonProperty("allSickPeopleInHospitals")
    private int amountOfAllSickPeopleInHospitals;
    @JsonProperty("allInfectedByCovid")
    private int amountOfAllInfectedByCovid;
    @JsonProperty("infectedList")
    private ArrayList<Visitor> peopleWithCovid;
    @JsonProperty("regCardsForInfectedList")
    private ArrayList<RegistrationCard> documentsOfPeopleWithCovid;
    @JsonProperty("deadFromCovid")
    private int amountOfDeadFromCovid;
    @JsonProperty("percentOfInfectedYoungGen")
    private double percentOfInfectedYoungGeneration;
    @JsonProperty("percentOfInfectedOldGen")
    private double percentOfInfectedOldGeneration;

    public int getAmountOfAllSickPeopleInHospitals() {
        return amountOfAllSickPeopleInHospitals;
    }

    public void setAmountOfAllSickPeopleInHospitals(int amountOfAllSickPeopleInHospitals) {
        this.amountOfAllSickPeopleInHospitals = amountOfAllSickPeopleInHospitals;
    }

    public int getAmountOfAllInfectedByCovid() {
        return amountOfAllInfectedByCovid;
    }

    public void setAmountOfAllInfectedByCovid(int amountOfAllInfectedByCovid) {
        this.amountOfAllInfectedByCovid = amountOfAllInfectedByCovid;
    }

    public ArrayList<Visitor> getPeopleWithCovid() {
        return peopleWithCovid;
    }

    public void setPeopleWithCovid(ArrayList<Visitor> peopleWithCovid) {
        this.peopleWithCovid = peopleWithCovid;
    }

    public ArrayList<RegistrationCard> getDocumentsOfPeopleWithCovid() {
        return documentsOfPeopleWithCovid;
    }

    public void setDocumentsOfPeopleWithCovid(ArrayList<RegistrationCard> documentsOfPeopleWithCovid) {
        this.documentsOfPeopleWithCovid = documentsOfPeopleWithCovid;
    }

    public int getAmountOfDeadFromCovid() {
        return amountOfDeadFromCovid;
    }

    public void setAmountOfDeadFromCovid(int amountOfDeadFromCovid) {
        this.amountOfDeadFromCovid = amountOfDeadFromCovid;
    }

    public double getPercentOfInfectedYoungGeneration() {
        return percentOfInfectedYoungGeneration;
    }

    public void setPercentOfInfectedYoungGeneration(double percentOfInfectedYoungGeneration) {
        this.percentOfInfectedYoungGeneration = percentOfInfectedYoungGeneration;
    }

    public double getPercentOfInfectedOldGeneration() {
        return percentOfInfectedOldGeneration;
    }

    public void setPercentOfInfectedOldGeneration(double percentOfInfectedOldGeneration) {
        this.percentOfInfectedOldGeneration = percentOfInfectedOldGeneration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorldHealthOrganization)) return false;
        WorldHealthOrganization that = (WorldHealthOrganization) o;
        return amountOfAllSickPeopleInHospitals == that.amountOfAllSickPeopleInHospitals
                && amountOfAllInfectedByCovid == that.amountOfAllInfectedByCovid
                && amountOfDeadFromCovid == that.amountOfDeadFromCovid
                && Double.compare(that.percentOfInfectedYoungGeneration, percentOfInfectedYoungGeneration) == 0
                && Double.compare(that.percentOfInfectedOldGeneration, percentOfInfectedOldGeneration) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountOfAllSickPeopleInHospitals, amountOfAllInfectedByCovid, amountOfDeadFromCovid,
                percentOfInfectedYoungGeneration, percentOfInfectedOldGeneration);
    }

    @Override
    public String toString() {
        return "WorldHealthOrganization{" +
                "amountOfAllSickPeopleInHospitals=" + amountOfAllSickPeopleInHospitals +
                ", amountOfAllInfectedByCovid=" + amountOfAllInfectedByCovid +
                ", peopleWithCovid=" + peopleWithCovid +
                ", documentsOfPeopleWithCovid=" + documentsOfPeopleWithCovid +
                ", amountOfDeadFromCovid=" + amountOfDeadFromCovid +
                ", percentOfInfectedYoungGeneration=" + percentOfInfectedYoungGeneration +
                ", percentOfInfectedOldGeneration=" + percentOfInfectedOldGeneration +
                '}';
    }
}
