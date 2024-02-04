package org.example.dao;

import org.example.entity.Customer;

public class CustomerDAO extends AbstractHibernateDao {
    public CustomerDAO () {
        super(Customer.class);
    }
}