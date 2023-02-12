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

@WebServlet("/InsertLect")
public class InsertLect extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
        	Lectures lect = new Lectures();
    		LecturesDAO lectDAO = (LecturesDAO) this.getServletContext().getAttribute("lecturesDAO");
    		lect.setSurname(request.getParameter("surname"));
    		lect.setName_(request.getParameter("name_"));
    		lect.setSecond_name(request.getParameter("second_name"));
    		lect.setPhone_number(request.getParameter("phone_number"));
    		lect.setWork_experience(request.getParameter("work_experience"));
    		lect.setLecture_id(lectDAO.insert(lect));
    	
    		response.sendRedirect("Success.jsp?msg=Insert into lectures table");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}