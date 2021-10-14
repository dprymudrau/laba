package com.solvd.laba.service.jdbc.implementation;


import com.solvd.laba.binary.ProductType;
import com.solvd.laba.binary.Products;
import com.solvd.laba.dao.jdbc.impl.ProductTypeDaoImpl;
import com.solvd.laba.service.interfaces.ProductTypeService;

import java.util.HashMap;

public class ProductTypeServiceImpl implements ProductTypeService {

    @Override
    public HashMap<Integer, ProductType> getProductTypeHashMap() {
        HashMap<Integer, ProductType> result = new HashMap<>();
        ProductType productType;
        long id = 1;
        while (true){
            ProductTypeDaoImpl productTypeDao = new ProductTypeDaoImpl();
            productType = productTypeDao.getById(id);
            id++;
            if(productType!=null){
                result.put(productType.getId(), productType);
            }
            else break;
        }
        return result;
    }

}
