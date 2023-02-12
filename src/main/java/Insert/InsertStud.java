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

@WebServlet("/InsertStud")
public class InsertStud extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
        	Students stud = new Students();
        	StudentsDAO studDAO = (StudentsDAO) this.getServletContext().getAttribute("studentsDAO");           
            stud.setGroup_id(Integer.valueOf(request.getParameter("group_id")));
            stud.setSurname(request.getParameter("surname"));
            stud.setName_(request.getParameter("name_"));
            stud.setSecond_name(request.getParameter("second_name"));
            stud.setPhone_number(request.getParameter("phone_number"));
            stud.setGrant_(Double.valueOf(request.getParameter("grant_")));  
            stud.setStudent_id(studDAO.insert(stud));
            
            response.sendRedirect("Success.jsp?msg=Insert into students table");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}