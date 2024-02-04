package org.example.dao;

import org.example.entity.Payment;

public class PaymentDAO extends AbstractHibernateDao {
    public PaymentDAO () {
        super(Payment.class);
    }
}