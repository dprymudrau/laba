package com.solvd.laba.poJo;

import java.util.Objects;

public class TasksLevel {

    private int id;
    private String tasksLevel;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTasksLevel() {
        return tasksLevel;
    }
    public void setTasksLevel(String tasksLevel) {
        this.tasksLevel = tasksLevel;
    }


    @Override
    public String toString() {
        return "TasksLevel{" +
                "id=" + id +
                ", tasksLevel='" + tasksLevel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TasksLevel that = (TasksLevel) o;
        return id == that.id && tasksLevel.equals(that.tasksLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tasksLevel);
    }



}
