package Update;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.SubjectsDAO;
import models.Subjects;
import listener.*;

@WebServlet("/UpdateSubj")
public class UpdateSubj extends HttpServlet {
  
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
            Subjects subj = new Subjects();      
            subj.setSubject(request.getParameter("subject"));
            subj.setHours(Integer.valueOf(request.getParameter("hours")));
            subj.setSubject_id(Integer.valueOf(request.getParameter("id")));
            subjDAO.update(subj);
            response.sendRedirect("Success.jsp?msg=" + "update table of subjects");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
  