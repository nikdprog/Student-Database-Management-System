package Insert;
import listener.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.*;
import dao.*;

@WebServlet("/InsertSubj")
public class InsertSubj extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
        	Subjects subj = new Subjects();
    		SubjectsDAO subjDAO = (SubjectsDAO) this.getServletContext().getAttribute("subjectsDAO");
    		subj.setSubject(request.getParameter("subject"));
    		subj.setHours(Integer.valueOf(request.getParameter("hours")));
    		subj.setSubject_id(subjDAO.insert(subj));
    		
    		response.sendRedirect("Success.jsp?msg=Insert into subjects table");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}