package org.example.dao;

import org.example.entity.Film;

public class FilmDAO extends AbstractHibernateDao {
    public FilmDAO () {
        super(Film.class);
    }
}
