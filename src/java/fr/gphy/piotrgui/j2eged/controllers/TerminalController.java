/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author guillaume
 */  
@Named("TerminalController")
@SessionScoped
public class TerminalController implements Serializable {  
  
    public String handleCommand(String command, String[] params) {  
        return "toto";
    }  
}  