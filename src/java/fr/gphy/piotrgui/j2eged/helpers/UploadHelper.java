/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.PhysicalDocument;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Piotr
 */
public class UploadHelper {
     Session session = null;

    public UploadHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void createNewFile() {
        session.beginTransaction();
        
        try {
            Query query = session.createSQLQuery("insert into document (doc_post, doc_ant) values (null, null)");
            query.executeUpdate();
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public Document getLastDocument() {
        session.beginTransaction();
        
        try {
            Query query = session.createSQLQuery("SELECT * FROM document WHERE id_doc='" + this.getLastIDFromDocument().toString() + "'").addEntity(Document.class);
            //System.err.println(((Document) query.uniqueResult()).getIdDoc());
            return (Document) query.uniqueResult();
        }
        catch (Exception e) {
            throw e;
        }
    }
    
    public Integer getLastIDFromDocument() {
        session.beginTransaction();
        
        try {
            Query query = session.createSQLQuery("SELECT max(id_doc) FROM document");;
            return (Integer) query.uniqueResult();     
        }
        catch (Exception e) {
            throw e;
        }
    }
    
        
    public void createNewPhysicalDoc(byte[] blob) {
        PhysicalDocument doc = new PhysicalDocument(this.getLastDocument(), blob);
        System.err.println(this.getLastDocument().getIdDoc().toString());

        try {
            Transaction transaction = session.beginTransaction();
            session.save(doc);
            transaction.commit();
        }
        catch (Exception e) {
            throw e;
        }
    }

}
