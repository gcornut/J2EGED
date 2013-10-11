/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Folder;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
public class BrowserHelper implements Serializable {

    Session session = null;

    public BrowserHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List<Object[]> getDocuments(Integer id_folder) {
        session.beginTransaction();      

        try {
            Query query = session.createSQLQuery(this.getDemandString(id_folder))
                    .addEntity(Document.class)
                    .addEntity(Metadata.class);

            return query.list();

        } catch (Exception e) {
            throw e;
        }
            

    }
    
    public String getDemandString(Integer folder) {
  
        String query = "select document.*, metadata.* "
                    + "from document "
                    + "inner join version on version.doc=document.id_doc "
                    + "inner join metadata on version.meta = metadata.id_meta "
                    + "inner join folder on metadata.folder = folder.id_folder "
                    + "where doc_post is null and folder.parent_folder";
        
        return (folder == null) ? query.concat(" is null") : query.concat(" ='" + Integer.toString(folder) + "'");
    }
    
    
    public List<Folder> getFolders(Integer clef) {
        session.beginTransaction();

        try {
            String sql = "select * from folder where parent_folder";
            if(clef != null) 
                sql += "= " + clef + ";";
            else 
                sql += " is null;";
            Query query = session.createSQLQuery(sql)
                    .addEntity(Folder.class);

            return (List<Folder>) query.list();

        } catch (Exception e) {
            throw e;
        }

    }
}
