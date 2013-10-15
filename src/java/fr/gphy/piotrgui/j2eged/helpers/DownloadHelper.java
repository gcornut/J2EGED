/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.Metadata;
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
    
    public PhysicalDocument getByteFromID(String id) {
        session.beginTransaction();
        
        try {
            Query q = session.createSQLQuery("select physical_document.* from physical_document where id_doc='" + id + "'")
                    .addEntity(PhysicalDocument.class);
            return (PhysicalDocument) q.uniqueResult();
        }
        catch (Exception e) {
            throw e;
        }
    }

    public Metadata getMetaFromID(String paramId) {
        session.beginTransaction();
        
        try {
            Query q = session.createSQLQuery("select metadata.* from metadata "
                    + "inner join version on version.meta = metadata.id_meta "
                    + "where version.doc='" + paramId + "'")
                    .addEntity(Metadata.class);
            return (Metadata) q.uniqueResult();
        }
        catch (Exception e) {
            throw e;
        }
    }
}
