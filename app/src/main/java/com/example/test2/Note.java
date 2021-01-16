package com.example.test2;
import com.google.firebase.firestore.Exclude;
import java.util.Map;

public class Note {
    private String documentId;
    private String HOD;
   private String Dean;
    private String title;
    private String description;
    private int priority;
    Map<String, String> tags;
    public Note() {
        //public no-arg constructor needed
    }
    public Note(String title, String description,String Dean,String HOD, int priority, Map<String, String> tags) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.HOD=HOD;
       this.Dean=Dean;
        this.tags = tags;
    }
    @Exclude
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getTitle() {
        return title;
    }
    public String getHOD() { return HOD; }
    public String getDean() {
        return Dean;
    }
    public String getDescription() {
        return description;
    }
    public int getPriority() {
        return priority;
    }
    public Map<String, String> getTags() {
        return tags;
    }
}
