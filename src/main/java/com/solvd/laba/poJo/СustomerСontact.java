package com.solvd.laba.poJo;

import java.util.Objects;

public class СustomerСontact {
    private int id;
    private String cCName;
    private String cCSurname;
    private String cCPatronymic;
    private int custumerID;
    private int emailsID ;
    private int phoneNumbersID ;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getcCName() {
        return cCName;
    }
    public void setcCName(String cCName) {
        this.cCName = cCName;
    }
    public String getcCSurname() {
        return cCSurname;
    }
    public void setcCSurname(String cCSurname) {
        this.cCSurname = cCSurname;
    }
    public String getcCPatronymic() {
        return cCPatronymic;
    }
    public void setcCPatronymic(String cCPatronymic) {
        this.cCPatronymic = cCPatronymic;
    }
    public int getCustumerID() {
        return custumerID;
    }
    public void setCustumerID(int custumerID) {
        this.custumerID = custumerID;
    }
    public int getEmailsID() {
        return emailsID;
    }
    public void setEmailsID(int emailsID) {
        this.emailsID = emailsID;
    }
    public int getPhoneNumbersID() {
        return phoneNumbersID;
    }
    public void setPhoneNumbersID(int phoneNumbersID) {
        this.phoneNumbersID = phoneNumbersID;
    }

    @Override
    public String toString() {
        return "СustomerСontact{" +
                "id=" + id +
                ", cCName='" + cCName + '\'' +
                ", cCSurname='" + cCSurname + '\'' +
                ", cCPatronymic='" + cCPatronymic + '\'' +
                ", custumerID=" + custumerID +
                ", emailsID=" + emailsID +
                ", phoneNumbersID=" + phoneNumbersID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        СustomerСontact that = (СustomerСontact) o;
        return id == that.id && custumerID == that.custumerID && emailsID == that.emailsID && phoneNumbersID == that.phoneNumbersID && cCName.equals(that.cCName) && cCSurname.equals(that.cCSurname) && cCPatronymic.equals(that.cCPatronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cCName, cCSurname, cCPatronymic, custumerID, emailsID, phoneNumbersID);
    }







}
