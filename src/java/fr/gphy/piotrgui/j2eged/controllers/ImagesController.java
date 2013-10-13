/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.ImagesHelper;
import fr.gphy.piotrgui.j2eged.model.Folder;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import fr.gphy.piotrgui.j2eged.model.PhysicalDocument;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Piotr
 */
@ManagedBean(name = "ImagesController")
@SessionScoped
public class ImagesController implements Serializable {

    private StreamedContent myImage;
    private Map<Integer, String> listOfImages;
    private ImagesHelper helper;
    
    private List<Integer> listOfID;
    
    private int ite = -1;

    public ImagesController() {
        this.helper = new ImagesHelper();
        
    }

    public StreamedContent getMyImage() {
        return myImage;
    }

    public void setMyImage(StreamedContent myImage) {
        this.myImage = myImage;
    }

    public Map<Integer, String> getListOfImages() {
        return listOfImages;
    }

    public void setListOfImages(Map<Integer, String> listOfImages) {
        this.listOfImages = listOfImages;
    }

    public void loadImages(Folder currentFolder) throws IOException {

        if(this.helper.getImages(currentFolder) != null) this.initList();
        

        for (Object[] tab : this.helper.getImages(currentFolder)) {
            
            this.listOfImages.put(((PhysicalDocument) tab[1]).getDocument().getIdDoc(), ((Metadata) tab[0]).getName());
            this.listOfID.add(((PhysicalDocument) tab[1]).getDocument().getIdDoc());
        }
            
       
    }

    public List<Integer> getListOfID() {
        return listOfID;
    }

    public void setListOfID(List<Integer> listOfID) {
        this.listOfID = listOfID;
    }
    
    public String getIntegerID() {
        this.ite++;
        return this.listOfID.get(ite).toString();
    }

    public int sizeOfList() {
        if (this.listOfImages == null) {
            return 0;
        }
        return this.listOfImages.size()-1;
    }

    
    public String getNameFromID(Integer id) {
        return this.listOfImages.get(id);
    }
    
    public void initList() {
        this.listOfImages = new HashMap<>();
        this.myImage = null;
        this.listOfID = new ArrayList<>();
    }
    
    public boolean listIsNull() {
        return (this.listOfID.isEmpty());
    }
            
}
