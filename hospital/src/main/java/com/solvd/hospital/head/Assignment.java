package com.solvd.hospital.head;


public class Assignment  {
    private long id;
    private String description;
    private PatientDatum doctor;
    private PatientDatum executor;
    private Examination examination;

    public Assignment() {
    }

    public Assignment(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


    public PatientDatum getDoctor() {
        return doctor;
    }

    public PatientDatum getExecutor() {
        return executor;
    }

    public Examination getExamination() {
        return examination;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setDoctor(PatientDatum doctor) {
        this.doctor = doctor;
    }

    public void setExecutor(PatientDatum executor) {
        this.executor = executor;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }



    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", doctor=" + doctor +
                ", executor=" + executor +
                ", examination=" + examination +
                '}';
    }


}

