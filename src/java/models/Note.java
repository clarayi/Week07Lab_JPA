package models;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author 810783
 */
public class Note implements Serializable 
{
    private int noteID;
    private String title;
    private String contents;
    
    public Note() 
    {
        ;
    }
    
    public Note(int noteID, String title, String contents)
    {
        this.noteID = noteID;
        this.title = title;
        this.contents = contents;
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
}
