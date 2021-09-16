package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class TasksStatus extends BaseEntityID{
    private static final Logger LOGGER = LogManager.getLogger(TasksStatus.class);
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
