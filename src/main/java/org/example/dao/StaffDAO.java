package org.example.dao;

import org.example.entity.Staff;

public class StaffDAO extends AbstractHibernateDao {
    public StaffDAO () {
        super(Staff.class);
    }
}