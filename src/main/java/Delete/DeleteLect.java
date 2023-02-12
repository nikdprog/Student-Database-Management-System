package Delete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
  
import dao.*;
import listener.*;
import models.Lectures;

@WebServlet("/DeleteLect")
public class DeleteLect extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        try {
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
	        LecturesDAO lectDAO = (LecturesDAO) this.getServletContext().getAttribute("lecturesDAO");
	        Lectures lect = lectDAO.get(Integer.valueOf(request.getParameter("id")));
        	if(lect == null)
	        	 response.sendRedirect("Error.jsp");
	        lectDAO.delete(Integer.valueOf(request.getParameter("id")));
	        response.sendRedirect("Success.jsp?msg=" + "Delete from lectures table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}