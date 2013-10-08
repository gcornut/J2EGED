/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import fr.gphy.piotrgui.j2eged.model.User;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
public class UserHelper {

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