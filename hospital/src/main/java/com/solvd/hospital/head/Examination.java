package com.solvd.hospital.head;

import com.solvd.hospital.hospitalization.Hospitalization;

import java.sql.Date;
import java.util.List;
import java.util.Objects;


public class Examination  {
    private long id;
    private String comment;
    private Date date;
    private Hospitalization hospitalization;
    private List<Assignment> assignments;
    private List<Diagnose> diagnoses;

    public Examination() {
    }

    public Examination(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public List<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public void setDiagnoses(List<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }


    @Override
    public int hashCode() {

        return Objects.hash(id, date, diagnoses, assignments);
    }

    @Override
    public String toString() {
        return "Examination{" +
                "id=" + id +                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", hospitalization=" + hospitalization +
                ", assignments=" + assignments +
                ", diagnoses=" + diagnoses +
                '}';
    }

}
