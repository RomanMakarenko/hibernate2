package org.example.dao;

import org.example.entity.Country;

public class CountryDAO extends AbstractHibernateDao {
    public CountryDAO () {
        super(Country.class);
    }
}