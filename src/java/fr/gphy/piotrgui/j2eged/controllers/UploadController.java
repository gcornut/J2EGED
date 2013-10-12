/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.UploadHelper;
import fr.gphy.piotrgui.j2eged.model.PhysicalDocument;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Piotr
 */
@ManagedBean(name="UploadController")
@SessionScoped
public class UploadController implements Serializable {
    private byte[] blob;
    
    private UploadHelper helper;
    
    public UploadController() {
        this.helper = new UploadHelper();
    }
    
    
    public void handleUploadFile(FileUploadEvent event) throws IOException {
        UploadedFile file = event.getFile();
        
        Long l = file.getSize();
       
        blob = new byte[l.intValue()];
        file.getInputstream().read(blob);
        file.getInputstream().close();
        
        //System.err.println(blob.length);
        this.saveFile();
        
    }
    
    public void saveFile() {
        System.err.println("new file");
        this.helper.createNewFile();
        this.helper.createNewPhysicalDoc(blob);
        
    }
}
