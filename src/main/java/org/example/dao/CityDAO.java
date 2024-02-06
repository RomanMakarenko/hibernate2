package org.example.dao;

import org.example.entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CityDAO extends AbstractHibernateDao<City> {
    public CityDAO (SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getCityByName(String name) {
        Query<City> query = getCurrentSession().createQuery("select c from City c where c.city = :NAME", City.class);
        query.setMaxResults(1);
        query.setParameter("NAME", name);
        return query.getSingleResult();
    }
}
