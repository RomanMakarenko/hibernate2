package org.example.dao;

import org.example.entity.Store;

public class StoreDAO extends AbstractHibernateDao {
    public StoreDAO () {
        super(Store.class);
    }
}
