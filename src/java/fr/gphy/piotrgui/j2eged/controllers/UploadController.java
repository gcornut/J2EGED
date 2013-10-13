/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.UploadHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Folder;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import fr.gphy.piotrgui.j2eged.model.Type;
import fr.gphy.piotrgui.j2eged.model.User;
import fr.gphy.piotrgui.j2eged.model.Version;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Transaction;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Piotr
 */
@ManagedBean(name = "UploadController")
@SessionScoped
public class UploadController implements Serializable {

    private byte[] blob;
    private Metadata meta;
    private Version version;
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

        this.initMetadata(event);


        this.saveFile();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uploaded", this.meta.getName() + "." + this.meta.getType().getFileExtension()));

    }

    public void initMetadata(FileUploadEvent event) {

        UploadedFile file = event.getFile();

        String ext = file.getFileName().substring(file.getFileName().lastIndexOf('.') + 1, file.getFileName().length());
        String name = file.getFileName().substring(0, file.getFileName().length() - ext.length() - 1);
        Date date = new Date();
        User user = (User) event.getComponent().getAttributes().get("user");
        Folder folder = (Folder) event.getComponent().getAttributes().get("folder");
        Integer size = ((Long) file.getSize()).intValue();
        Integer version = 1;

        Type type = this.helper.getTypeFromExtension(ext);

        this.meta = new Metadata(type, this.helper.retrieveUserFromLog(user.getLogin(), user.getPassword()), size, date, name);
        this.meta.setFolder(folder);
        this.meta.setVersion(version);
    }

    public void initVersion() {
        Date change_date = this.meta.getDateCreation();
        String commit = "Create document";
        Document doc = this.helper.getLastDocument();
        User user = new User();

        this.version = new Version(doc, this.meta.getUser(), meta, change_date, commit);
    }

    public void saveFile() {
        System.err.println("new file");
        this.helper.createNewFile();
        System.err.println("file");
        this.helper.createNewPhysicalDoc(blob);
        System.err.println("phy");

        /////////////////////////////////////////////////////////////////////////////////
        this.helper.createNewMetadata(this.meta);
        System.err.println("meta");
        this.initVersion();

        Transaction tx = this.helper.createNewVersion(this.version);
        System.err.println("version");

        tx.commit();
        this.helper.reloadSession();
    }

    public String reloadPage() {
        return "browser";
    }
}
