/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.BrowserHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Folder;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Piotr
 */
@Named("BrowserController")
@SessionScoped
public class BrowserController implements Serializable {

    private List<Object[]> data;
    private List<Folder> folders;
    private List<DisplayDoc> toDisplay = new ArrayList<>();
    private BrowserHelper helper = new BrowserHelper();

    public List<Object[]> getData() {
        return data;
    }

    public void setData(List<Object[]> data) {
        this.data = data;
    }

    public List<DisplayDoc> getToDisplay() {
        return toDisplay;
    }

    public void setToDisplay(List<DisplayDoc> toDisplay) {
        this.toDisplay = toDisplay;
    }

    public void clear() {
        this.toDisplay = new ArrayList<>();
    }

    public void loadDocument() {
        this.clear();


        this.data = this.helper.getDocuments(null);
        this.folders = this.helper.getFolders(1);
        this.loadToDisplay();
    }

    public void loadToDisplay() {
        for (Object[] row : this.data) {
            this.toDisplay.add(new DisplayDoc((Document) row[0], (Metadata) row[1]));
        }

        for (Folder fold : this.folders) {
            this.toDisplay.add(new DisplayDoc(fold));
        }
    }

    public class DisplayDoc {

        private Document doc = null;
        private Metadata meta = null;
        private Folder folder = null;

        public DisplayDoc(Document doc, Metadata meta) {
            this.doc = doc;
            this.meta = meta;
        }

        public DisplayDoc(Folder folder) {
            this.folder = folder;
        }

        public Folder getFolder() {
            return folder;
        }

        public void setFolder(Folder folder) {
            this.folder = folder;
        }

        public Document getDoc() {
            return doc;
        }

        public Metadata getMeta() {
            return meta;
        }

        public Boolean isFolder() {
            return (this.folder != null);
        }
    }

    public void fileUpload(FileUploadEvent event) throws IOException {
        String path = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("/");
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        String name = fmt.format(new Date())
                + event.getFile().getFileName().substring(
                event.getFile().getFileName().lastIndexOf('.'));
       /* File file = new File(path + "catalogo_imagens/temporario/" + name);

        InputStream is = event.getFile().getInputstream();
        OutputStream out = new FileOutputStream(file);
        byte buf[] = new byte[1024];
        int len;
        while ((len = is.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        is.close();
        out.close();*/
        
        System.err.println(name);
        
    }
    
    public String myButtonListener(ActionEvent actionEvent) {
        System.err.println("");;
         FacesContext context = FacesContext.getCurrentInstance();
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gneuf", "Hodor"));
          return "browser";
    }
    
}
