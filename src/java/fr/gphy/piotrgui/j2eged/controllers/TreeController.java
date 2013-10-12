package fr.gphy.piotrgui.j2eged.controllers;

import fr.gphy.piotrgui.j2eged.helpers.TreeHelper;
import fr.gphy.piotrgui.j2eged.model.Folder;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
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
        
        this.initTree(root, this.helper.getFolders(null));
    }

    public TreeNode getRoot() {
        return root;
    }

    public void initTree(TreeNode root, List<Folder> list) {
        if (list == null) {
            return;
        }

        for (Folder f : list) {
            TreeNode node = new DefaultTreeNode(f.getName(), root);
            this.initTree(node, this.helper.getFolders(f.getIdFolder()));
        }
    }
}
