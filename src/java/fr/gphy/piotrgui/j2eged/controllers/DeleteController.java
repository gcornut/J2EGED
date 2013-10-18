/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.DeleteHelper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

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
        System.err.println("DeleteListenerDoc");
    }
    
    public void deleteListenerFolder(ActionEvent event) {
        System.err.println("DeleteListenerFolder");
    }
    
}
