package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Shop extends Base{
    private static final Logger LOGGER = LogManager.getLogger(Shop.class);
    private String adress;
    private String tel;
    private String site;
    private int email;

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getSite() {
        return tel;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public int getEmail() {
        return email;
    }
    public void setEmail(int email) {
        this.email = email;
    }
}
