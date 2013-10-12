package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.TreeHelper;
import fr.gphy.piotrgui.j2eged.model.Folder;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;

@Named("TreeController")
@SessionScoped
public class TreeController implements Serializable {

    private TreeNode root;
    private TreeHelper helper;

    public TreeController() {
        this.helper = new TreeHelper();

        
        root = new DefaultTreeNode("Root", null);

        Folder rootFolder = new Folder();
        rootFolder.setName("root");
        
        TreeNode node = new DefaultTreeNode(rootFolder, root);
        node.setExpanded(true);
        node.setSelectable(true);
        
        this.initTree(node, this.helper.getFolders(null));
    }

    public TreeNode getRoot() {
        return root;
    }

    public void initTree(TreeNode root, List<Folder> list) {
        if (list == null) {
            return;
        }

        for (Folder f : list) {
            TreeNode node = new DefaultTreeNode(f, root);
            node.setExpanded(true);
            this.initTree(node, this.helper.getFolders(f.getIdFolder()));
        }
    }
    
    public void onNodeSelect(NodeSelectEvent event) {  
        System.err.println("plp");
    }  
    
    public void deselectAll() {
        this.deselectAll(root.getChildren().get(0));
    }
    
    public void deselectAll(TreeNode node) {
        for (TreeNode n : node.getChildren()) {
            n.setExpanded(false);
            this.deselectAll(n);
        }
    }
}
