package Select;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.*;
import models.*;
import dao.*;

@WebServlet("/SelectLect")
public class SelectLect extends HttpServlet {
  
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
    		int lecture_id = 0;
         	String surname = "", name_ = "", second_name = "", phone_number = "", work_experience = "";
         	LecturesDAO lectDAO = (LecturesDAO) this.getServletContext().getAttribute("lecturesDAO");
         	Lectures lect = lectDAO.get(Integer.valueOf(request.getParameter("id")));
         	 if(lect == null)
	        	  response.sendRedirect("Error.jsp");
         	lecture_id = lect.getLecture_id();
         	surname = lect.getSurname();
         	name_ = lect.getName_();
         	second_name = lect.getSecond_name();
         	phone_number = lect.getPhone_number();
         	work_experience = lect.getWork_experience();
         	response.sendRedirect("ResultLect.jsp?lecture_id=" + lecture_id + "&surname=" + surname + "&name_=" + name_ + "&second_name=" + second_name + "&phone_number=" + phone_number + "&work_experience=" + work_experience);
         }
         catch (Exception e) {
    	     e.printStackTrace();
         }
    }
}