package Update;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.StudentsDAO;
import models.Students;
import listener.*;

@WebServlet("/UpdateStud")
public class UpdateStud extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        try {
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
        	String msg = "Update";
        	StudentsDAO studDAO = (StudentsDAO) this.getServletContext().getAttribute("studentsDAO");
            Students stud = new Students();
            stud.setGroup_id(Integer.valueOf(request.getParameter("group_id")));
            stud.setSurname(request.getParameter("surname"));
            stud.setName_(request.getParameter("name"));
            stud.setSecond_name(request.getParameter("second_name"));
            stud.setPhone_number(request.getParameter("phone_number"));
            stud.setGrant_(Double.valueOf(request.getParameter("grant_")));
            stud.setStudent_id(Integer.valueOf(request.getParameter("id")));
            studDAO.update(stud);
            response.sendRedirect("Success.jsp?msg=" + msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
  