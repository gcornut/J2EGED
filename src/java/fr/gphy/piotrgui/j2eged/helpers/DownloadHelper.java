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
public class DownloadHelper {
    
    Session session = null;

    public DownloadHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void reloadSession() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public PhysicalDocument getByteFromID(Integer id) {
        session.beginTransaction();
        
        try {
            Query q = session.createSQLQuery("select physical_document.* from physical_document where id_doc='" + id.toString() + "'")
                    .addEntity(PhysicalDocument.class);
            return (PhysicalDocument) q.uniqueResult();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
