package Delete;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
  
import dao.*;
import listener.*;
import models.Groupstudent;

@WebServlet("/DeleteGrp")
public class DeleteGrp extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        try {
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
	        Group_studentsDAO groupDAO = (Group_studentsDAO) this.getServletContext().getAttribute("group_studentsDAO");
	        Groupstudent gr = groupDAO.get(Integer.valueOf(request.getParameter("id")));    
	        if(gr == null)
	        	response.sendRedirect("Error.jsp");
	        groupDAO.delete(Integer.valueOf(request.getParameter("id")));
	        response.sendRedirect("Success.jsp?msg=" + "delete from groups table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}