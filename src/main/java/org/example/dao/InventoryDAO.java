package org.example.dao;

import org.example.entity.Inventory;

public class InventoryDAO extends AbstractHibernateDao {
    public InventoryDAO () {
        super(Inventory.class);
    }
}