/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import java.io.Serializable;
import java.util.Date;  
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author guillaume
 */  
@Named("TerminalController")
@SessionScoped
public class TerminalController implements Serializable {  
  
    public String handleCommand(String command, String[] params) {  
        /*if(command.equals("greet")) {  
            if(params.length > 0)  
                return "Hello " + params[0];  
            else  
                return "Hello Stranger";  
            }  
            else if(command.equals("date"))  
                return new Date().toString();  
            else  
                return command + " not found";  
        }*/
        return command;
    }  
}  