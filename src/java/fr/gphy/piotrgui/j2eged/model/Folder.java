package fr.gphy.piotrgui.j2eged.model;
// Generated 12 oct. 2013 14:58:54 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Folder generated by hbm2java
 */
public class Folder  implements java.io.Serializable {


     private Integer idFolder;
     private Folder folder;
     private String name;
     private Set<Metadata> metadatas = new HashSet<Metadata>(0);
     private Set<Folder> folders = new HashSet<Folder>(0);

    public Folder() {
    }

    public Folder(Folder folder, String name, Set<Metadata> metadatas, Set<Folder> folders) {
       this.folder = folder;
       this.name = name;
       this.metadatas = metadatas;
       this.folders = folders;
    }
   
    public Integer getIdFolder() {
        return this.idFolder;
    }
    
    public void setIdFolder(Integer idFolder) {
        this.idFolder = idFolder;
    }
    public Folder getFolder() {
        return this.folder;
    }
    
    public void setFolder(Folder folder) {
        this.folder = folder;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Metadata> getMetadatas() {
        return this.metadatas;
    }
    
    public void setMetadatas(Set<Metadata> metadatas) {
        this.metadatas = metadatas;
    }
    public Set<Folder> getFolders() {
        return this.folders;
    }
    
    public void setFolders(Set<Folder> folders) {
        this.folders = folders;
    }
    
     @Override
    public String toString() {
        return (idFolder == null) ? "null" : this.idFolder.toString();
    }

}


