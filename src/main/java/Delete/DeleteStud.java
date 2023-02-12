package Delete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
  
import dao.*;
import listener.*;
import models.Students;

@WebServlet("/DeleteStud")
public class DeleteStud extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        try {
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
	        	StudentsDAO studDAO = (StudentsDAO) this.getServletContext().getAttribute("studentsDAO");
	        	Students st = studDAO.get(Integer.valueOf(request.getParameter("id")));
		        if(st == null)
		        	 response.sendRedirect("Error.jsp");
	            studDAO.delete(Integer.valueOf(request.getParameter("id")));
	            response.sendRedirect("Success.jsp?msg=" + "Delete");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}