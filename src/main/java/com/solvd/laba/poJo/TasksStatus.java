package com.solvd.laba.poJo;

import java.util.Objects;

public class TasksStatus extends BaseEntityID{
    private String tasksStatus;

    public String getTasksStatus() {
        return tasksStatus;
    }
    public void setTasksStatus(String tasksStatus) {
        this.tasksStatus = tasksStatus;
    }

    @Override
    public String toString() {
        String id = super.toString();
        return "TasksStatus{" + id +
                ", tasksStatus='" + tasksStatus + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        TasksStatus guest = (TasksStatus) obj;
        boolean b = super.equals(obj) && (guest.tasksStatus == this.tasksStatus);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tasksStatus);
    }




}
