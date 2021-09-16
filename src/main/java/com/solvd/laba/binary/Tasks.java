package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Tasks {
    private static final Logger LOGGER = LogManager.getLogger(Tasks.class);
    private String task;
    private int projectID;
    private int emploeeID;
    private int emploeeProjectID;
    private int taskStatusID;
    private int taskLevelID;

    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public int getProjectID() {
        return projectID;
    }
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    public int getEmploeeID() {
        return emploeeID;
    }
    public void setEmploeeID(int emploeeID) {
        this.emploeeID = emploeeID;
    }
    public int getEmploeeProjectID() {
        return emploeeProjectID;
    }
    public void setEmploeeProjectID(int emploeeProjectID) {
        this.emploeeProjectID = emploeeProjectID;
    }
    public int getTaskStatusID() {
        return taskStatusID;
    }
    public void setTaskStatusID(int taskStatusID) {
        this.taskStatusID = taskStatusID;
    }
    public int getTaskLevelID() {
        return taskLevelID;
    }
    public void setTaskLevelID(int taskLevelID) {
        this.taskLevelID = taskLevelID;
    }

    @Override
    public String toString() {
        String id = super.toString();
        return "Tasks{" + id +
                ", task='" + task + '\'' +
                ", projectID=" + projectID +
                ", emploeeID=" + emploeeID +
                ", emploeeProjectID=" + emploeeProjectID +
                ", taskStatusID=" + taskStatusID +
                ", taskLevelID=" + taskLevelID +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Tasks guest = (Tasks) obj;
        boolean b = super.equals(obj) && (guest.task == this.task) && (guest.projectID == this.projectID) && (guest.emploeeID == this.emploeeID) && (guest.emploeeProjectID == this.emploeeProjectID) && (guest.taskStatusID == this.taskStatusID) && (guest.taskLevelID == this.taskLevelID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), task, projectID, emploeeID, emploeeProjectID, taskStatusID, taskLevelID);
    }

}
