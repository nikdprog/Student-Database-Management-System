package Insert;
import listener.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.*;
import models.*;
import dao.*;

@WebServlet("/InsertGrp")
public class InsertGrp extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
        	Groupstudent gr = new Groupstudent();
    		Group_studentsDAO grDAO = (Group_studentsDAO) this.getServletContext().getAttribute("group_studentsDAO");
    		gr.setName_group(request.getParameter("name_group"));
    		gr.setSpecialty(request.getParameter("specialty"));
    		gr.setGroup_id(grDAO.insert(gr));
    		
    		response.sendRedirect("Success.jsp?msg=Insert into groups table");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}