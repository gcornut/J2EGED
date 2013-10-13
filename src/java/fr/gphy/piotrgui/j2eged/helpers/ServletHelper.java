/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.PhysicalDocument;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
public class ServletHelper {
    Session session = null;

    public ServletHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
   
    public void reloadSession() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public byte[] retriveByteFromID(String id){
        session.beginTransaction();
        try {
            Query q = session.createSQLQuery("select physical_document.* from physical_document "
                    + "where id_doc = '" + id + "'").addEntity(PhysicalDocument.class);
            return ((PhysicalDocument) q.uniqueResult()).getBinaryBlob();
        }
        catch (Exception e) {
            throw e;
        }
    }
 }
