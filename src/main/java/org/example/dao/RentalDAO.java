package org.example.dao;

import org.example.entity.Rental;

public class RentalDAO extends AbstractHibernateDao {
    public RentalDAO () {
        super(Rental.class);
    }
}
