package com.solvd.laba.poJo;

import java.util.Objects;

public class СustomerСontact extends BaseEntityID{
    private String cCName;
    private String cCSurname;
    private String cCPatronymic;
    private int custumerID;
    private int emailsID ;
    private int phoneNumbersID ;

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
        String id = super.toString();
        return "СustomerСontact{" + id +
                ", cCName='" + cCName + '\'' +
                ", cCSurname='" + cCSurname + '\'' +
                ", cCPatronymic='" + cCPatronymic + '\'' +
                ", custumerID=" + custumerID +
                ", emailsID=" + emailsID +
                ", phoneNumbersID=" + phoneNumbersID +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        СustomerСontact guest = (СustomerСontact) obj;
        boolean b = super.equals(obj) && (guest.cCName == this.cCName)&& (guest.cCSurname == this.cCSurname)&& (guest.cCPatronymic == this.cCPatronymic)&& (guest.custumerID == this.custumerID)&& (guest.emailsID == this.emailsID)&& (guest.phoneNumbersID == this.phoneNumbersID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cCName, cCSurname, cCPatronymic, custumerID, emailsID, phoneNumbersID);
    }







}
