/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.ImagesHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Piotr
 */

@ManagedBean(name = "ImagesController")
@SessionScoped
public class ImagesController implements Serializable{
    
      private List<StreamedContent> images; 
      private StreamedContent myImage;
      
      private ImagesHelper helper;

    public ImagesController() {
    }

    public StreamedContent getMyImage() {
        return myImage;
    }

    public void setMyImage(StreamedContent myImage) {
        this.myImage = myImage;
    }

    public List<StreamedContent> getImages() {
        return images;
    }

    public void setImages(List<StreamedContent> images) {
        this.images = images;
    }
    
    public void loadImages() {
       //List<Object[]> pllop = this.helper.getImages(null);
        
    }
    
    
    
    
    
}
