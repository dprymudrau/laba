package com.solvd.laba.binary;

import java.util.Objects;

public class ListOfOrders {
    private int listOfOrdersId;
    private int numbersOfOrder;
    private int price;
    private int passengerId;
    private int orderTypeId;
    private int driverId;
    private int cityId;
    private int streetId;
    private int carId;

    public ListOfOrders(int listOfOrdersId, int numbersOfOrder, int price, int passengerId,
                        int orderTypeId, int driverId, int cityId, int streetId, int carId) {
        this.listOfOrdersId = listOfOrdersId;
        this.numbersOfOrder = numbersOfOrder;
        this.price = price;
        this.passengerId = passengerId;
        this.orderTypeId = orderTypeId;
        this.driverId = driverId;
        this.cityId = cityId;
        this.streetId = streetId;
        this.carId = carId;
    }

    public ListOfOrders() {

    }

    public int getListOfOrdersId() {
        return listOfOrdersId;
    }

    public void setListOfOrdersId(int listOfOrdersId) {
        this.listOfOrdersId = listOfOrdersId;
    }

    public int getNumbersOfOrder() {
        return numbersOfOrder;
    }

    public void setNumbersOfOrder(int numbersOfOrder) {
        this.numbersOfOrder = numbersOfOrder;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListOfOrders that = (ListOfOrders) o;
        return listOfOrdersId == that.listOfOrdersId && numbersOfOrder == that.numbersOfOrder && price == that.price && passengerId == that.passengerId && orderTypeId == that.orderTypeId && driverId == that.driverId && cityId == that.cityId && streetId == that.streetId && carId == that.carId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfOrdersId, numbersOfOrder, price, passengerId, orderTypeId, driverId, cityId, streetId, carId);
    }

    @Override
    public String toString() {
        return "ListOfOrders{" +
                "listOfOrdersId=" + listOfOrdersId +
                ", numbersOfOrder=" + numbersOfOrder +
                ", price=" + price +
                ", passengerId=" + passengerId +
                ", orderTypeId=" + orderTypeId +
                ", driverId=" + driverId +
                ", cityId=" + cityId +
                ", streetId=" + streetId +
                ", carId=" + carId +
                '}';
    }
}
