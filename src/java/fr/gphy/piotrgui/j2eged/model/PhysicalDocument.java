package fr.gphy.piotrgui.j2eged.model;
// Generated 7 oct. 2013 11:33:07 by Hibernate Tools 3.2.1.GA



/**
 * PhysicalDocument generated by hbm2java
 */
public class PhysicalDocument  implements java.io.Serializable {


     private Integer idPhysicalDocument;
     private Document document;
     private byte[] binaryBlob;

    public PhysicalDocument() {
    }

    public PhysicalDocument(Document document, byte[] binaryBlob) {
       this.document = document;
       this.binaryBlob = binaryBlob;
    }
   
    public Integer getIdPhysicalDocument() {
        return this.idPhysicalDocument;
    }
    
    public void setIdPhysicalDocument(Integer idPhysicalDocument) {
        this.idPhysicalDocument = idPhysicalDocument;
    }
    public Document getDocument() {
        return this.document;
    }
    
    public void setDocument(Document document) {
        this.document = document;
    }
    public byte[] getBinaryBlob() {
        return this.binaryBlob;
    }
    
    public void setBinaryBlob(byte[] binaryBlob) {
        this.binaryBlob = binaryBlob;
    }




}


