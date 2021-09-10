package com.solvd.laba.poJo;

import java.util.Objects;

public class Emails {
    private int id;
    private String emails ;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmails() {
        return emails;
    }
    public void setEmails(String emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "Emails{" +
                "id=" + id +
                ", emails='" + emails + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emails emails1 = (Emails) o;
        return id == emails1.id && emails.equals(emails1.emails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emails);
    }

}
