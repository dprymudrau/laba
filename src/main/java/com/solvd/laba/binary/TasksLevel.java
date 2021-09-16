package com.solvd.laba.binary;

import java.util.Objects;

public class TasksLevel extends BaseEntityID{

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
