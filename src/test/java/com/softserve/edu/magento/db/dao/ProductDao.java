package com.softserve.edu.magento.db.dao;

import com.softserve.edu.magento.db.entity.AdminUserDB;
import com.softserve.edu.magento.db.entity.ProductDB;

/**
 * Created by Corwin on 10.09.2016.
 */

/*public class ProductDao extends ADaoCRUD<ProductDB> {
    private static volatile ProductDao instance = null;

    private ProductDao() {
        super();
        init();
    }

    public static ProductDao get() {
        if (instance == null) {
            synchronized (ProductDao.class) {
                if (instance == null) {
                    instance = new ProductDao();
                }
            }
        }
        return instance;
    }

    protected void init() {
        for (ProductDB.ProductDBQueries productDBQueries : ProductDB.ProductDBQueries.values()) {
            sqlQueries.put(productDBQueries.getQueryName(), productDBQueries);
        }
    }

    protected ProductDB createInstance(String[] args) {
        return new ProductDB(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1],
                args[2] == null ? new String() : args[2]);
    }

    protected String[] getFields(ProductDB entity) {
        String[] fields = new String[3];
        fields[0] = entity.getEntityId().toString();
        fields[1] = entity.getAttributeSetId();
        fields[2] = entity.getSku();
        return fields;
    }
} */
