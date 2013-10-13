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
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
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
    private List<MyImage> listOfImages;
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

    public List<MyImage> getListOfImages() {
        this.ite = -1;
        return listOfImages;
    }

    public void setListOfImages(List<MyImage> listOfImages) {
        this.listOfImages = listOfImages;
    }
    
    
    

    public void loadImages(Folder currentFolder) throws IOException {

        if(this.helper.getImages(currentFolder) != null) this.initList();
        

        for (Object[] tab : this.helper.getImages(currentFolder)) {
            /*ByteArrayInputStream bis = new ByteArrayInputStream(((PhysicalDocument) tab[1]).getBinaryBlob());
            
            BufferedInputStream in = new BufferedInputStream(ImagesController.class.getClassLoader().getResourceAsStream(((Metadata) tab[0]).getType().getMimeType() + "/plop." + ((Metadata) tab[0]).getType().getFileExtension()));

            System.err.println("plop");
            StreamedContent currentImage = new DefaultStreamedContent(new ByteArrayInputStream(((PhysicalDocument) tab[1]).getBinaryBlob()), "image/png", "test.png");
            this.listOfImages.add(currentImage);

            this.images.put(currentImage, ((Metadata) tab[0]).getName());
            */
            
            
            /*
             BufferedImage bufferedImg = new BufferedImage(100, 25, BufferedImage.TYPE_INT_RGB);  
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImg, "png", os);  
          this.listOfImages.add(new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), ((Metadata) tab[0]).getType().getMimeType()));
          this.images.put(new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), ((Metadata) tab[0]).getType().getMimeType()) , ((Metadata) tab[0]).getName());
          this.myImage = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), ((Metadata) tab[0]).getType().getMimeType());
       */
            System.err.println("plop" + ((PhysicalDocument) tab[1]).getBinaryBlob().length);
            this.listOfImages.add(new MyImage(((PhysicalDocument) tab[1]).getBinaryBlob(), ((Metadata) tab[0]).getName(), ((Metadata) tab[0]).getType().getMimeType()));
            this.listOfID.add(((PhysicalDocument) tab[1]).getDocument().getIdDoc());
        }
            
       // this.listOfImages.add(new DefaultStreamedContent(new ByteArrayInputStream(((PhysicalDocument) tab[1]).getBinaryBlob()), ((Metadata) tab[0]).getType().getMimeType()));
        //this.myImage = new DefaultStreamedContent(new ByteArrayInputStream(((PhysicalDocument) tab[1]).getBinaryBlob()), ((Metadata) tab[0]).getType().getMimeType());}
       

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
    /*
    public StreamedContent getMyPicture(int indice) {
        //System.err.println(this.listOfImages.size() + " size");
        if (this.listOfImages == null) {
            System.err.println("plop fkjksjdfslkd");
            return null;
        }
        System.err.println(indice + "  " + this.listOfImages.get(indice).getName() + "   " + this.listOfImages.get(indice).getPicture().getContentType());
        return this.listOfImages.get(indice).getPicture();
    }
    */
    
    
     public StreamedContent retrieveMyPicture() {
        //System.err.println(this.listOfImages.size() + " size");
        if (this.listOfImages == null) {
            System.err.println("plop fkjksjdfslkd");
            return null;
        }
        this.ite++;
        System.err.println(ite + "  " + this.listOfImages.get(ite).getName() + "   " + this.listOfImages.get(ite).getPicture().getContentType());
        return this.listOfImages.get(ite).getPicture();
    }
     
      public String retrieveMyPictureName() {
        //System.err.println(this.listOfImages.size() + " size");
        if (this.listOfImages == null) {
            System.err.println("plop fkjksjdfslkd");
            return null;
        }
        //this.ite++;
        //System.err.println(ite + "  " + this.listOfImages.get(ite).getName() + "   " + this.listOfImages.get(ite).getPicture().getContentType());
          System.err.println("plop" + ite);
        return "plop" + ite;
    }
    
    public void initList() {
        this.listOfImages = new ArrayList<>();
        this.myImage = null;
        this.listOfID = new ArrayList<>();
    }
}
