/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.DeleteHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Piotr
 */
@ManagedBean(name = "DeleteController")
@SessionScoped
public class DeleteController implements Serializable{
    
    private DeleteHelper helper;
    private BrowserController.DisplayDoc toDelete;

    public DeleteController() {
        this.helper = new DeleteHelper();
        toDelete = null;
    }

    public BrowserController.DisplayDoc getToDelete() {
        return toDelete;
    }

    public void setToDelete(BrowserController.DisplayDoc toDelete) {
        this.toDelete = toDelete;
    }
    
    public void deleteListenerDoc(ActionEvent event) {
        
         String paramId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("toDeleteDocID");
        
        this.helper.deleteDoc(this.helper.getDocument(paramId));
        
        
        System.err.println("DeleteListenerDoc");
    }
    
    public void deleteListenerFolder(ActionEvent event) {
        
        String paramId = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("toDeleteFolderID");
        
        this.helper.deleteFolder(this.helper.getFolder(paramId));
        //System.err.println("DeleteListenerFolder");
    }
    
}
