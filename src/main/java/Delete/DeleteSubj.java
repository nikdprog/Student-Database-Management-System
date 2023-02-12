package Delete;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
  
import dao.*;
import listener.*;
import models.Subjects;

@WebServlet("/DeleteSubj")
public class DeleteSubj extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        try {
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
	        SubjectsDAO subjDAO = (SubjectsDAO) this.getServletContext().getAttribute("subjectsDAO");
	        Subjects subj = subjDAO.get(Integer.valueOf(request.getParameter("id")));
 			if(subj == null)
 				response.sendRedirect("Error.jsp");
	        subjDAO.delete(Integer.valueOf(request.getParameter("id")));
	        response.sendRedirect("Success.jsp?msg=" + "delete from subjects table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}