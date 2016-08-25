package com.softserve.edu.magento.db.dao;

import java.util.List;

public interface IDaoRead<TEntity> {

	// Read
    TEntity getById(Integer id);

    List<TEntity> getByFieldName(String fieldName, String text);

    List<TEntity> getAll();

}
