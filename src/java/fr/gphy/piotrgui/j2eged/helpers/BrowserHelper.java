/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Folder;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
public class BrowserHelper {

    Session session = null;

    public BrowserHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Object[]> getRootDocuments() {
        session.beginTransaction();

        try {
            Query query = session.createSQLQuery("select document.*, metadata.* "
                    + "from document "
                    + "inner join version on version.doc=document.id_doc "
                    + "inner join metadata on version.meta = metadata.id_meta "
                    + "inner join folder on metadata.folder = folder.id_folder "
                    + "where doc_post is null and folder.parent_folder is null")
                    .addEntity(Document.class)
                    .addEntity(Metadata.class);

            return query.list();

        } catch (Exception e) {
            throw e;
        }

    }
    
    public List<Folder> getFolder(int clef) {
        session.beginTransaction();

        try {
            Query query = session.createSQLQuery("select * from folder where parent_folder = '" + Integer.toString(clef) + "'")
                    .addEntity(Folder.class);

            return (List<Folder>) query.list();

        } catch (Exception e) {
            throw e;
        }

    }
}
