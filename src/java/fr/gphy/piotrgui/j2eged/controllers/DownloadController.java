/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.DownloadHelper;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Piotr
 */
@ManagedBean(name = "DownloadController")
@SessionScoped
public class DownloadController implements Serializable {

    private BrowserController.DisplayDoc selectedDoc;
    private StreamedContent file;
    private DownloadHelper helper;

    public DownloadController() {
        this.helper = new DownloadHelper();
    }

    public void save(BrowserController.DisplayDoc doc) {
        this.selectedDoc = doc;
        System.err.println("save");
        if (selectedDoc != null) {
            ByteArrayInputStream stream = new ByteArrayInputStream(this.helper.getByteFromID(this.selectedDoc.getDoc().getIdDoc()).getBinaryBlob());
            file = new DefaultStreamedContent(stream, this.selectedDoc.getMeta().getType().getMimeType(), this.selectedDoc.getMeta().getName());

        }

    }

    public BrowserController.DisplayDoc getSelectedDoc() {
        return selectedDoc;
    }

    public void setSelectedDoc(BrowserController.DisplayDoc selectedDoc) {
        System.err.println("plop");
        this.selectedDoc = selectedDoc;
    }

    public StreamedContent getFile() {
        System.err.println(file.getName());
        if (file == null) {
            System.err.println("error getFile");
        }
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
}
