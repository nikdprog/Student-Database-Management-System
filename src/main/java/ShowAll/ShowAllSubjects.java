package ShowAll;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import dao.*;
import models.*;
import listener.*;
  
@WebServlet("/ShowAllSubjects")
public class ShowAllSubjects extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws  IOException {
    	 try {
             Class.forName(DbInitListener.DRIVER);
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
    	try {
    
    		SubjectsDAO subjDAO = (SubjectsDAO) this.getServletContext().getAttribute("subjectsDAO");
        	ArrayList<Subjects> lst3 = subjDAO.getAll(); 
        	for (Subjects sbj : lst3) {
        		 
                int subject_id = sbj.getSubject_id();
                request.setAttribute("subject_id",subject_id);
 
                String subject = sbj.getSubject();
                request.setAttribute("subject",subject);
 
                int hours = sbj.getHours();
                request.setAttribute("hours",hours);
            
            }
        	request.setAttribute("lst3", lst3); // Will be available as
        	//request.setAttribute("lst2", lst2);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Subjects.jsp");
             
             dispatcher.forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}