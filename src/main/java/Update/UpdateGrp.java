package Update;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.Group_studentsDAO;
import models.Groupstudent;
import listener.*;

@WebServlet("/UpdateGrp")
public class UpdateGrp extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        try {
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
        	
        	Group_studentsDAO grpDAO = (Group_studentsDAO) this.getServletContext().getAttribute("group_studentsDAO");
            Groupstudent grp = new Groupstudent();
           
            grp.setName_group(request.getParameter("name_group"));
            grp.setSpecialty(request.getParameter("specialty"));
            grp.setGroup_id(Integer.valueOf(request.getParameter("id")));
            grpDAO.update(grp);
            response.sendRedirect("Success.jsp?msg=" + "update table of groups");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
  