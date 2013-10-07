/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Piotr
 */
public final class OurSession {
    private SessionFactory factory;
    private Session session;
    
    private static OurSession ourSession = null;
    
    public OurSession() {
        this.factory = new Configuration().configure().buildSessionFactory();
        this.session = factory.openSession();
    }
    
    public final static OurSession getInstance() {
        if (ourSession == null) {
            ourSession = new OurSession();
        }
        return ourSession;
    }
    
    public Session getSession() {
        return this.session;
    }
    
}
