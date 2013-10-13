/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Piotr
 */
@ManagedBean(name = "DownloadController")
@SessionScoped
public class DownloadController implements Serializable{
    
    public void save(ActionEvent event) {
        System.err.println("plop");
    }
}
