package com.solvd.hospital.head;

import java.util.Objects;

public class Photo  {

    private long id;
    private String name;

    public Photo() {
    }

    public Photo(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }


}
