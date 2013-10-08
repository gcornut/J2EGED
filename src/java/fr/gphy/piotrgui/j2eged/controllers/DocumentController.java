/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.DocumentHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Piotr
 */

@Named("DocumentController")
@SessionScoped
public class DocumentController implements Serializable {
    
    private Document doc;
    private DocumentHelper helper;
    
    public DocumentController() {
        this.doc = new Document();
        this.helper = new DocumentHelper();
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public DocumentHelper getHelper() {
        return helper;
    }

    public void setHelper(DocumentHelper helper) {
        this.helper = helper;
    }
    
    
    
    
    
    
    
    
}
