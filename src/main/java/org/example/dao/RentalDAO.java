package org.example.dao;

import org.example.entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDAO extends AbstractHibernateDao<Rental> {
    public RentalDAO (SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getSomeRentedItem() {
        Query<Rental> query = getCurrentSession().createQuery("select r from Rental r where r.returnDate is null ", Rental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
