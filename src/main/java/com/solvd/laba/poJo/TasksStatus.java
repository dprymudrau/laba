package com.solvd.laba.poJo;

import java.util.Objects;

public class TasksStatus {
    private int id;
    private String tasksStatus;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTasksStatus() {
        return tasksStatus;
    }
    public void setTasksStatus(String tasksStatus) {
        this.tasksStatus = tasksStatus;
    }

    @Override
    public String toString() {
        return "TasksStatus{" +
                "id=" + id +
                ", tasksStatus='" + tasksStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TasksStatus that = (TasksStatus) o;
        return id == that.id && tasksStatus.equals(that.tasksStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tasksStatus);
    }




}
