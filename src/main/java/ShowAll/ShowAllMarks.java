package ShowAll;

import java.io.IOException;
import java.sql.Timestamp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import dao.*;
import models.*;
import listener.*;
  
@WebServlet("/ShowAllMarks")
public class ShowAllMarks extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws  IOException {
    	 try {
             Class.forName(DbInitListener.DRIVER);
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
    	try {
    
    		MarksDAO marksDAO = (MarksDAO) this.getServletContext().getAttribute("marksDAO");
        	ArrayList<Marks> lst = marksDAO.getAll(); 
        	for (Marks mrk : lst) {
        		
        		int mark = mrk.getMark();
        		request.setAttribute("mark", mark);
        		
                int student_id = mrk.getStudent_id();
                request.setAttribute("student_id",student_id);
 
                int subject_id = mrk.getSubject_id();
                request.setAttribute("subject_id",subject_id);                                      
 
                Timestamp modification_time = mrk.getModification_time();
                request.setAttribute("modification_time",modification_time);
                
                int mark_id = mrk.getMark_id();
                request.setAttribute("mark_id",mark_id);
                
                int lecture_id = mrk.getLecture_id();
                request.setAttribute("lecture_id",lecture_id);
            
            }
        	request.setAttribute("lst", lst);
        
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Marks.jsp");
             
             dispatcher.forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}