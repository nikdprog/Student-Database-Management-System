package Update;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.LecturesDAO;
import models.Lectures;
import listener.*;

@WebServlet("/UpdateLect")
public class UpdateLect extends HttpServlet {
  
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
            Lectures lect = new Lectures();
            lect.setSurname(request.getParameter("surname"));
            lect.setName_(request.getParameter("name"));
            lect.setSecond_name(request.getParameter("second_name"));
            lect.setPhone_number(request.getParameter("phone_number"));
            lect.setWork_experience(request.getParameter("work_experience"));
            lect.setLecture_id(Integer.valueOf(request.getParameter("id")));
            lectDAO.update(lect);
            response.sendRedirect("Success.jsp?msg=" + "update table of lectures");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
  