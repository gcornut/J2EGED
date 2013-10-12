package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.BrowserHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Folder;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Piotr
 */
@ManagedBean(name="BrowserController")
@SessionScoped
public class BrowserController implements Serializable {

    private List<Object[]> data;
    private List<Folder> folders;
    private List<DisplayDoc> toDisplay = new ArrayList<>();
    private BrowserHelper helper = new BrowserHelper();
    private Folder currenFolder = null;

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
        changeFolder(null);
    }

    public void loadToDisplay() {
        for (Object[] row : this.data) {
            this.toDisplay.add(new DisplayDoc((Document) row[0], (Metadata) row[1]));
        }
        
        for (Folder fold : this.folders) {
            this.toDisplay.add(new DisplayDoc(fold));
        }
    }
    
    public void changeFolder(Folder newFolder) {
        Integer idFolder = null;
        if(newFolder != null) {
            idFolder = newFolder.getIdFolder();
        }
        
        this.clear();
        
        this.currenFolder = newFolder;
        
        this.helper.reloadSession();
        
        this.data = this.helper.getDocuments(idFolder);
        this.folders = this.helper.getFolders(idFolder);
        
        this.loadToDisplay();
    }

    public void clickOnFolder(ActionEvent event) {
        int idDestFolder = Integer.valueOf(((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("idFolder"));
        this.clear();
        
        //Get the future folder
        for(Folder f: folders) {
            if(f.getIdFolder() == idDestFolder){
                this.currenFolder = f;
                break;
            }
        }
        System.err.println(this.currenFolder);
        changeFolder(this.currenFolder);
    }
    
    public void clickOnUpload() {
        System.err.println("Upload");
    }

    public Folder getCurrenFolder() {
        return currenFolder;
    }

    public void setCurrenFolder(Folder currenFolder) {
        this.currenFolder = currenFolder;
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
}
