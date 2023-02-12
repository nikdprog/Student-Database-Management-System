package Delete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
  
import dao.*;
import listener.*;
import models.Marks;

@WebServlet("/DeleteMrk")
public class DeleteMrk extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        try {
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
	        MarksDAO mrkDAO = (MarksDAO) this.getServletContext().getAttribute("marksDAO");
	        Marks mrk = mrkDAO.get(Integer.valueOf(request.getParameter("id")));
			if(mrk == null)
	        	 response.sendRedirect("Error.jsp");
	        mrkDAO.delete(Integer.valueOf(request.getParameter("id")));
	        response.sendRedirect("Success.jsp?msg=" + "Delete from marks table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}