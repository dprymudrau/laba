package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class ITCompanyContact  extends BaseEntityID{
    private static final Logger LOGGER = LogManager.getLogger(ITCompanyContact.class);
    private String iTCCName;
    private String iTCCSurname;
    private String iTCCPatronymic;
    private int iTCompaniesID;
    private int emailsID;
    private int phoneNumbersID;
    private int custumerContactID;
    private int custumerContactphoneNumberID;

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
    public String toString() {
        String id = super.toString();

        return "ITCompanyContact{" + id +
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ITCompanyContact guest = (ITCompanyContact) obj;
        boolean b = super.equals(obj) && (guest.iTCCName == this.iTCCName)&& (guest.iTCCSurname == this.iTCCSurname)&& (guest.iTCCPatronymic == this.iTCCPatronymic)&& (guest.iTCompaniesID == this.iTCompaniesID)&& (guest.emailsID == this.emailsID)&& (guest.phoneNumbersID == this.phoneNumbersID)&& (guest.custumerContactID == this.custumerContactID)&& (guest.custumerContactphoneNumberID == this.custumerContactphoneNumberID);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), iTCCName, iTCCSurname, iTCCPatronymic, iTCompaniesID, emailsID, phoneNumbersID, custumerContactID, custumerContactphoneNumberID);
    }


}
