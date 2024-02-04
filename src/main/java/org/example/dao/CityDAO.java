package org.example.dao;

import org.example.entity.City;

public class CityDAO extends AbstractHibernateDao {
    public CityDAO () {
        super(City.class);
    }
}