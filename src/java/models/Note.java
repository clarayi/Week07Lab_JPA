package models;

import java.beans.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author 810783
 */
public class Note implements Serializable 
{
    private int noteID;
    private String title;
    private String contents;
    private Date dateCreated;
    
    public Note() 
    {
        ;
    }
    
    public Note(int noteID, String title, String contents, Date dateCreated)
    {
        this.noteID = noteID;
        this.title = title;
        this.contents = contents;
        this.dateCreated = dateCreated;
    }

    public int getNoteID() 
    {
        return noteID;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getContents() 
    {
        return contents;
    }
    
    public Date getDateCreated() 
    {
        return dateCreated;
    }

    public void setNoteID(int noteID) 
    {
        this.noteID = noteID;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }
    
    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }
}
