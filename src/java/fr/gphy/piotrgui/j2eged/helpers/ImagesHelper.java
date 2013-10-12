/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.helpers;

import fr.gphy.piotrgui.j2eged.hibernate.HibernateUtil;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import fr.gphy.piotrgui.j2eged.model.PhysicalDocument;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Piotr
 */
public class ImagesHelper {
     Session session = null;

    public ImagesHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void reloadSession() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List<Object[]> getImages(Integer id_folder) {
          session.beginTransaction();      

        try {
            Query query = session.createSQLQuery(this.getDemandString(id_folder))
                    .addEntity(Metadata.class)
                    .addEntity(PhysicalDocument.class);

            if (query.list() == null) {
                System.err.println("toto");
            }
            return query.list();

        } catch (Exception e) {
            throw e;
        }
            

    }
    
    public String getDemandString(Integer folder) {
  
        String query = "select metadata.*, physical_document.* from metadata "
                + "inner join type on metadata.type = type.id_type "
                + "inner join version on version.meta = metadata.id_meta "
                + "inner join document on document.id_doc = version.doc "
                + "inner join physical_document on physical_document.id_doc = document.id_doc "
                + "and type.mime_type like '%image%' "
                + "where metadata.folder";
        
        return (folder == null) ? query.concat(" is null") : query.concat(" ='" + Integer.toString(folder) + "'");
    }
}
