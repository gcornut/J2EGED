/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Folder;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
public class DeleteHelper {
    Session session = null;

    public DeleteHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
   
    public void reloadSession() {
       
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    
    public Folder getFolder(String clef) {
        session.beginTransaction();
        
        if (clef == null) return null;

        try {
            String sql = "select * from folder where id_folder='" + clef + "';";
           
            Query query = session.createSQLQuery(sql)
                    .addEntity(Folder.class);

            return (Folder) query.uniqueResult();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void deleteFolder(Folder folder) {
        try {
        session.delete(folder);  
        session.beginTransaction().commit();
        this.reloadSession();
        
        } catch (Exception e) {
            throw e;
        }

    }
    
    public Document getDocument(String clef) {
        session.beginTransaction();
        
        if (clef == null) return null;

        try {
            String sql = "select * from document where id_doc='" + clef + "';";
           
            Query query = session.createSQLQuery(sql)
                    .addEntity(Document.class);

            return (Document) query.uniqueResult();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void deleteDoc(Document doc) {
        try {
        session.delete(doc);  
        session.beginTransaction().commit();
        this.reloadSession();
        
        
        } catch (Exception e) {
            throw e;
        }

    }
}
