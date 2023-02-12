package Select;

import java.io.IOException;
import java.sql.Timestamp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.*;
import models.*;
import dao.*;

@WebServlet("/SelectMrk")
public class SelectMrk extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    static int idd;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
    	 try {
             Class.forName(DbInitListener.DRIVER);
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
    	 try {
    		 int mark = 0, student_id = 0 ,subject_id = 0, lecture_id = 0; 		
 			Timestamp modification_time;
 			int mark_id = 0;
 			MarksDAO mrkDAO = (MarksDAO) this.getServletContext().getAttribute("marksDAO");
 			Marks mrk = mrkDAO.get(Integer.valueOf(request.getParameter("id")));
 			 if(mrk == null)
	        	  response.sendRedirect("Error.jsp");
 			mark = mrk.getMark();
 			student_id = mrk.getStudent_id();
 			subject_id = mrk.getSubject_id();
 			lecture_id = mrk.getLecture_id();	
 			modification_time = mrk.getModification_time();
 			mark_id = mrk.getMark_id();
 			response.sendRedirect("ResultMrk.jsp?mark=" + mark + "&student_id=" + student_id + "&subject_id=" + subject_id + "&lecture_id=" + lecture_id + "&modification_time=" + modification_time + "&mark_id=" + mark_id);
 		}
         catch (Exception e) {
    	     e.printStackTrace();
         }
    }
}