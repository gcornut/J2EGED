/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.utils;

import fr.gphy.piotrgui.j2eged.model.Metadata;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Piotr
 */
public class MyImage implements Serializable{
    private StreamedContent picture;
    private String name;
    
    
    public MyImage(byte[] data, String name, String mimeType) {
        this.name = name;
        this.picture = new DefaultStreamedContent(new ByteArrayInputStream(data), mimeType);
    }

    public StreamedContent getPicture() {
        //System.err.println("toto");
        if (picture == null) System.err.println("toto null");
        return picture;
    }

    public void setPicture(StreamedContent picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
    
}
