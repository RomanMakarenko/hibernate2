package org.example;

import org.example.config.SessionCreator;
import org.example.entity.Actor;
import org.example.entity.Language;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        try (Session session = SessionCreator.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Language actor = session.get(Language.class, 1);
            transaction.commit();
            System.out.println(actor);
        }
    }
}
