package com.solvd.airport.binary;

import java.util.Objects;

public class Pilot {

    private long idPilot;
    private long companyId;
    private String pilotName;
    private int workExperience;
    private long pilotCategoryId;

    public long getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(long idPilot) {
        this.idPilot = idPilot;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public long getPilotCategoryId() {
        return pilotCategoryId;
    }

    public void setPilotCategoryId(long pilotCategoryId) {
        this.pilotCategoryId = pilotCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilot pilot = (Pilot) o;
        return idPilot == pilot.idPilot && companyId == pilot.companyId && workExperience == pilot.workExperience && pilotCategoryId == pilot.pilotCategoryId && pilotName.equals(pilot.pilotName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPilot, companyId, pilotName, workExperience, pilotCategoryId);
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "idPilot=" + idPilot +
                ", companyId=" + companyId +
                ", pilotName='" + pilotName + '\'' +
                ", workExperience=" + workExperience +
                ", pilotCategoryId=" + pilotCategoryId +
                '}';
    }
}
