package com.softserve.edu.magento.db.entity;

/**
 * Created by Corwin on 10.09.2016.
 */
public class ProductDB implements IEntity {
    public static enum ProductDBFields {
        ATTRIBUTE_SET_ID("attribute_set_id"),
        SKU("sku");

        private String field;

        private ProductDBFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    public static enum ProductDBQueries {
        INSERT(IEntity.QueryNames.INSERT, "INSERT INTO catalog_product_entity (sku, attribute_set_id) VALUES ('%s');"),
        GET_BY_SKU(IEntity.QueryNames.GET_BY_SKU, "SELECT sku FROM catalog_product_entity WHERE sku = %s;"),
        GET_ALL(IEntity.QueryNames.GET_ALL, "SELECT sku, attribute_set_id FROM catalog_product_entity;"),
        DELETE_BY_SKU(IEntity.QueryNames.DELETE_BY_SKU, "DELETE FROM catalog_product_entity WHERE sku = '%s';");

        private IEntity.QueryNames queryName;
        private String query;

        private ProductDBQueries(IEntity.QueryNames queryName, String query) {
            this.queryName = queryName;
            this.query = query;
        }

        public IEntity.QueryNames getQueryName() {
            return queryName;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    // class ProductUserDB
    private Long entity_id;
    private String attribute_set_id;
    private String sku;

    public ProductDB(String attribute_set_id, String sku) {
        this.attribute_set_id = attribute_set_id;
        this.sku = sku;
    }

    public Long getId() {
        return getEntityId();
    }

    // getters

    public Long getEntityId() {
        return entity_id;
    }

    public String getAttributeSetId() {
        return attribute_set_id;
    }

    public String getSku() {
        return sku;
    }

    // setters

    public void setEntityId(Long user_id) {
        this.entity_id = entity_id;
    }

    public void setAttributeSetId(String attribute_set_id) {
        this.attribute_set_id = attribute_set_id;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
