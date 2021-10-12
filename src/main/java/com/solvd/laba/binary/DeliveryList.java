package com.solvd.laba.binary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeliveryList extends Base{
    private static final Logger LOGGER = LogManager.getLogger(DeliveryList.class);
    private String orderId;
    private String courierId;
    private String date;
    private String paymentMethod;

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getCourierId() {
        return courierId;
    }
    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
