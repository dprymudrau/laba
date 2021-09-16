package com.solvd.laba.binary;

import java.util.Objects;

public class Emails extends BaseEntityID{
    private String emails ;


    public String getEmails() {
        return emails;
    }
    public void setEmails(String emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        String id = super.toString();

        return "Emails{" + id +
                ", emails='" + emails + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Emails guest = (Emails) obj;
        boolean b = super.equals(obj) && (guest.emails == this.emails);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), emails);
    }

}
