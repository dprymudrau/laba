package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class TasksLevel extends BaseEntityID{
    private static final Logger LOGGER = LogManager.getLogger(TasksLevel.class);
    private String tasksLevel;

    public String getTasksLevel() {
        return tasksLevel;
    }
    public void setTasksLevel(String tasksLevel) {
        this.tasksLevel = tasksLevel;
    }


    @Override
    public String toString() {
        String id = super.toString();
        return "TasksLevel{" + id +
                ", tasksLevel='" + tasksLevel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        TasksLevel guest = (TasksLevel) obj;
        boolean b = super.equals(obj) && (guest.tasksLevel == this.tasksLevel);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tasksLevel);
    }



}
