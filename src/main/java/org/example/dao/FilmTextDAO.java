package org.example.dao;

import org.example.entity.FilmText;

public class FilmTextDAO extends AbstractHibernateDao {
    public FilmTextDAO () {
        super(FilmText.class);
    }
}
