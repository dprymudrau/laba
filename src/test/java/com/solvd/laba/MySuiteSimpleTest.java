package com.solvd.laba;

import com.solvd.laba.binary.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MySuiteSimpleTest {
    @Test
    public void ordersTest(){
        Orders orders = new Orders();
        orders.setCustomerId("Number");
        Assert.assertEquals(orders.getCustomerId(), "Number");
    }
    @Test
    public void orderProductTest(){
        OrdersProducts itcc = new OrdersProducts();
        itcc.setQuantity("Amount");
        Assert.assertEquals(itcc.getQuantity(), "Amount");
    }
    @Test
    public void productsTest(){
        Products products = new Products();
        products.setPrice("Money");
        Assert.assertEquals(products.getPrice(), "Money");
    }
    @Test
    public void productTypeTest(){
        ProductType productType = new ProductType();
        productType.setName("Name");
        Assert.assertEquals(productType.getName(),"Name");
    }
    @Test
    public void shopTest(){
        Shop shop = new Shop();
        shop.setAdress("Name");
        Assert.assertEquals(shop.getAdress(), "Name");
    }
}
