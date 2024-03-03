package org.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class config {
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    Session session;

    public config(){

        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.openSession(); //hibernate which has no module descriptor but it requires java.naming



    }
}
