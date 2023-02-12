package Select;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.*;
import models.*;
import dao.*;

@WebServlet("/SelectSubj")
public class SelectSubj extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    static int idd;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
    	 try {
             Class.forName(DbInitListener.DRIVER);
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
    	 try {
    		int subject_id = 0, lecture_id = 0, hours = 0;
 			String subject = "";
 			SubjectsDAO subjDAO = (SubjectsDAO) this.getServletContext().getAttribute("subjectsDAO");
 			Subjects subj = subjDAO.get(Integer.valueOf(request.getParameter("id")));
 			if(subj == null)
 				response.sendRedirect("Error.jsp");
 			subject_id = subj.getSubject_id();
 			lecture_id = subj.getLecture_id();
 			subject = subj.getSubject();
 			hours = subj.getHours();
 			response.sendRedirect("ResultSbj.jsp?subject_id=" + subject_id + "&lecture_id=" + lecture_id + "&subject=" + subject + "&hours=" + hours);
 		}
         catch (Exception e) {
    	     e.printStackTrace();
         }
    }
}