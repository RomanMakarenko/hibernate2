package org.example.dao;

import org.example.entity.Actor;

public class ActorDAO extends AbstractHibernateDao {
    public ActorDAO () {
        super(Actor.class);
    }
}
