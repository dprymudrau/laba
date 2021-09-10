package com.solvd.laba.poJo;

import java.util.Objects;

public class ITCompanyContact {
    private int id;
    private String iTCCName;
    private String iTCCSurname;
    private String iTCCPatronymic;
    private int iTCompaniesID;
    private int emailsID;
    private int phoneNumbersID;
    private int custumerContactID;
    private int custumerContactphoneNumberID;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getiTCCName() {
        return iTCCName;
    }
    public void setiTCCName(String iTCCName) {
        this.iTCCName = iTCCName;
    }
    public String getiTCCSurname() {
        return iTCCSurname;
    }
    public void setiTCCSurname(String iTCCSurname) {
        this.iTCCSurname = iTCCSurname;
    }
    public String getiTCCPatronymic() {
        return iTCCPatronymic;
    }
    public void setiTCCPatronymic(String iTCCPatronymic) {
        this.iTCCPatronymic = iTCCPatronymic;
    }
    public int getiTCompaniesID() {
        return iTCompaniesID;
    }
    public void setiTCompaniesID(int iTCompaniesID) {
        this.iTCompaniesID = iTCompaniesID;
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
    public int getCustumerContactID() {
        return custumerContactID;
    }
    public void setCustumerContactID(int custumerContactID) {
        this.custumerContactID = custumerContactID;
    }
    public int getCustumerContactphoneNumberID() {
        return custumerContactphoneNumberID;
    }
    public void setCustumerContactphoneNumberID(int custumerContactphoneNumberID) {
        this.custumerContactphoneNumberID = custumerContactphoneNumberID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCompanyContact that = (ITCompanyContact) o;
        return id == that.id && iTCompaniesID == that.iTCompaniesID && emailsID == that.emailsID && phoneNumbersID == that.phoneNumbersID && custumerContactID == that.custumerContactID && custumerContactphoneNumberID == that.custumerContactphoneNumberID && iTCCName.equals(that.iTCCName) && iTCCSurname.equals(that.iTCCSurname) && iTCCPatronymic.equals(that.iTCCPatronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iTCCName, iTCCSurname, iTCCPatronymic, iTCompaniesID, emailsID, phoneNumbersID, custumerContactID, custumerContactphoneNumberID);
    }

    @Override
    public String toString() {
        return "ITCompanyContact{" +
                "id=" + id +
                ", iTCCName='" + iTCCName + '\'' +
                ", iTCCSurname='" + iTCCSurname + '\'' +
                ", iTCCPatronymic='" + iTCCPatronymic + '\'' +
                ", iTCompaniesID=" + iTCompaniesID +
                ", emailsID=" + emailsID +
                ", phoneNumbersID=" + phoneNumbersID +
                ", custumerContactID=" + custumerContactID +
                ", custumerContactphoneNumberID=" + custumerContactphoneNumberID +
                '}';
    }
}
