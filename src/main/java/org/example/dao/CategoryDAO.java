package org.example.dao;

import org.example.entity.Category;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Set;

public class CategoryDAO extends AbstractHibernateDao<Category> {
    public CategoryDAO (SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }

    public Category getById(final byte id) {
        return getCurrentSession().get(Category.class, id);
    }

    public Set<Category> getByIds(final byte id1, final byte id2) {
        Set<Category> categories = new HashSet<>();
        categories.add(this.getById(id1));
        categories.add(this.getById(id2));
        return categories;
    }
}
