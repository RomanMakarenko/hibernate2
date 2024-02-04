package org.example.dao;

import org.example.entity.Language;

public class LanguageDAO extends AbstractHibernateDao {
    public LanguageDAO () {
        super(Language.class);
    }
}
