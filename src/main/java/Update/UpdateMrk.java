package Update;

import java.io.IOException;
import java.sql.Timestamp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.MarksDAO;
import models.Marks;
import listener.*;

@WebServlet("/UpdateMrk")
public class UpdateMrk extends HttpServlet {
  
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
            Marks mrk = new Marks();
            mrk.setMark(Integer.valueOf(request.getParameter("mark")));
            mrk.setStudent_id(Integer.valueOf(request.getParameter("student_id")));
            mrk.setSubject_id(Integer.valueOf(request.getParameter("subject_id")));
            mrk.setLecture_id(Integer.valueOf(request.getParameter("lecture_id")));
            mrk.setModification_time(new Timestamp(System.currentTimeMillis()));
            mrk.setMark_id(Integer.valueOf(request.getParameter("id")));
            mrkDAO.update(mrk);
            response.sendRedirect("Success.jsp?msg=" + "update table of marks");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
  