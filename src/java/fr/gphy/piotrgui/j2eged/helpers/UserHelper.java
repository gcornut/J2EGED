/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
public class UserHelper implements Serializable {

    Session session = null;

    public UserHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public boolean getConnection(String login, String passwd) {
        session.beginTransaction();
        try {
            Query query = session.createSQLQuery("select * from user where login='" + login + "' and password='" + passwd + "'");
            return (query.list().size() == 1) ? true : false;

        } catch (Exception e) {
            throw e;
        }
    }

}