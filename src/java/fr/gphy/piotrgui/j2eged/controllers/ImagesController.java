/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import com.mysql.jdbc.Blob;
import fr.gphy.piotrgui.j2eged.helpers.ImagesHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Folder;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import fr.gphy.piotrgui.j2eged.model.PhysicalDocument;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


/**
 *
 * @author Piotr
 */
@ManagedBean(name = "ImagesController")
@SessionScoped
public class ImagesController implements Serializable {

    private StreamedContent myImage;
    private List<StreamedContent> listOfImages;
    private HashMap<StreamedContent, String> images;
    
    private ImagesHelper helper;

    public ImagesController() {
        this.helper = new ImagesHelper();

    }

    public StreamedContent getMyImage() {
        return myImage;
    }

    public void setMyImage(StreamedContent myImage) {
        this.myImage = myImage;
    }

    public List<StreamedContent> getListOfImages() {
        return listOfImages;
    }

    public void setListOfImages(List<StreamedContent> listOfImages) {
        this.listOfImages = listOfImages;
    }

    public HashMap<StreamedContent, String> getImages() {
        return images;
    }

    public void setImages(HashMap<StreamedContent, String> images) {
        this.images = images;
    }


    
    public void loadImages(Folder currentFolder) {

        this.initList();

        for (Object[] tab : this.helper.getImages(currentFolder)) {
            ByteArrayInputStream bis = new ByteArrayInputStream(((PhysicalDocument) tab[1]).getBinaryBlob());
            
            StreamedContent currentImage = new DefaultStreamedContent(bis, "image/jpg");
            this.listOfImages.add(currentImage);
            
            this.images.put(currentImage, ((Metadata) tab[0]).getName());
        }

    }
    
    public String retrieveNameInHash(StreamedContent image) {
        return this.images.get(image);
    }

    private void initList() {
        this.listOfImages = new ArrayList<>();
        this.images = new HashMap<>();
    }
}
