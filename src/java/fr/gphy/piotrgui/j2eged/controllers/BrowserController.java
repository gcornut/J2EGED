/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.BrowserHelper;
import fr.gphy.piotrgui.j2eged.model.Document;
import fr.gphy.piotrgui.j2eged.model.Metadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Piotr
 */
@Named("BrowserController")
@SessionScoped
public class BrowserController implements Serializable {

    private List<Object[]> data;
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

    public void loadDocument() {
        this.data = this.helper.getRootDocuments();
        this.loadToDisplay();
    }

    public void loadToDisplay() {
        for (Object[] row : this.data) {
            this.toDisplay.add(new DisplayDoc((Document) row[0], (Metadata) row[1]));
        }
    }

    
    
    
    public class DisplayDoc {

        private Document doc;
        private Metadata meta;

        public DisplayDoc(Document doc, Metadata meta) {
            this.doc = doc;
            this.meta = meta;
        }

        public Document getDoc() {
            return doc;
        }

        public Metadata getMeta() {
            return meta;
        }
    }
}
