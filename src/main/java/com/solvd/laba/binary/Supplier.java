package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Supplier extends Base{
    private static final Logger LOGGER = LogManager.getLogger(Supplier.class);
    private String name;
    private String emailAddress;
    private String dateOfLastOrder;
    private int phone;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getDateOfLastOrder() {
        return dateOfLastOrder;
    }
    public void setDateOfLastOrder(String date) {
        this.dateOfLastOrder = dateOfLastOrder;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
}
