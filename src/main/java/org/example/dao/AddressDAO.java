package org.example.dao;

import org.example.entity.Address;

public class AddressDAO extends AbstractHibernateDao {
    public AddressDAO () {
        super(Address.class);
    }
}