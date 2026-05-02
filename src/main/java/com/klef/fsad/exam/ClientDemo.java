package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Library lib = new Library();
        lib.setName("Java Book");
        lib.setDescription("FullStack EndSem Lab Exam");
        lib.setDate(new Date());
        lib.setStatus("Available");

        session.save(lib);
        System.out.println("Inserted ID: " + lib.getId());

        /*Library l = session.get(Library.class, lib.getId());
        if (l != null) {
            session.delete(l);
            System.out.println("Deleted Successfully");
        }*/

        tx.commit();
        session.close();
        sf.close();
    }
}