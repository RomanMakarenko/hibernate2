package org.example.dao;

import org.example.entity.Category;

public class CategoryDAO extends AbstractHibernateDao {
    public CategoryDAO () {
        super(Category.class);
    }
}
