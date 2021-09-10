package com.solvd.laba.poJo;

import java.util.Objects;

public class Tasks {
    private int id;
    private String task;
    private int projectID;
    private int emploeeID;
    private int emploeeProjectID;
    private int taskStatusID;
    private int taskLevelID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return id == tasks.id && projectID == tasks.projectID && emploeeID == tasks.emploeeID && emploeeProjectID == tasks.emploeeProjectID && taskStatusID == tasks.taskStatusID && taskLevelID == tasks.taskLevelID && task.equals(tasks.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, projectID, emploeeID, emploeeProjectID, taskStatusID, taskLevelID);
    }
    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", projectID=" + projectID +
                ", emploeeID=" + emploeeID +
                ", emploeeProjectID=" + emploeeProjectID +
                ", taskStatusID=" + taskStatusID +
                ", taskLevelID=" + taskLevelID +
                '}';
    }
}
