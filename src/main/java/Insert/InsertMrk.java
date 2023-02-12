package Insert;
import listener.*;
import java.io.IOException;
import java.sql.Timestamp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.*;
import dao.*;

@WebServlet("/InsertMrk")
public class InsertMrk extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            Class.forName(DbInitListener.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        try {
        	Marks mrk = new Marks();     	
    		MarksDAO mrkDAO = (MarksDAO) this.getServletContext().getAttribute("marksDAO");
    		mrk.setMark(Integer.valueOf(request.getParameter("mark")));
    		mrk.setStudent_id(Integer.valueOf(request.getParameter("student_id")));
    		mrk.setSubject_id(Integer.valueOf(request.getParameter("subject_id")));
    		mrk.setLecture_id(Integer.valueOf(request.getParameter("lecture_id")));    	
    		mrk.setModification_time(new Timestamp(System.currentTimeMillis()));
    		mrk.setMark_id(mrkDAO.insert(mrk));
    		//сделать для полей даты корректный ввод
    		response.sendRedirect("Success.jsp?msg=Insert into marks table");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}