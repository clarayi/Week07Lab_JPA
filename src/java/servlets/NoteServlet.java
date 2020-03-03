/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Notes;
import models.Users;
import services.NoteService;

/**
 *
 * @author 810783
 */
public class NoteServlet extends HttpServlet 
{
    private HttpSession session = null;
    private NoteService ns = new NoteService();
    private ArrayList<Notes> editList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        System.out.println("<<NoteServlet / In doGet method>>");
        
        session = request.getSession();
        editList.clear();
        
        List<Notes> noteList = null;       
        
        try 
        {
            noteList = ns.getAll();
           
            for(int i = 0; i < noteList.size(); i++)
            {
                System.out.println(noteList.get(i));
            }
            
            session.setAttribute("noteList", noteList);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(NoteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("whatToDo", "Add");
        
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        
        if(action.contains("edit"))
        {
            request.setAttribute("whatToDo", "Edit");
            editList.clear();
            
            String[] split = action.split("=");
            String noteidString = split[1];
            int noteid = Integer.parseInt(noteidString);
            
            try 
            {
                Notes editNote = ns.get(noteid);
                
                request.setAttribute("titleBox", editNote.getTitle());
                request.setAttribute("textareaBox", editNote.getContents());
                
                editList.add(editNote);
                session.setAttribute("editList", editList);
                session.setAttribute("editNoteID", editNote.getNoteid());
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(action.contains("add"))
        {
            //
        }
        else if(action.contains("delete"))
        {
            String[] split = action.split("=");
            String noteidString = split[1];
            int noteid = Integer.parseInt(noteidString);
            
            try 
            {
                int numOfRow = ns.delete(noteid);
                
                if(numOfRow == 1)
                {
                    request.setAttribute("titleBox", "Note Deleted");
                    request.setAttribute("textareaBox", "Note Deleted");
                }
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        response.sendRedirect(request.getContextPath() + "/notes");         
    }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }

}
