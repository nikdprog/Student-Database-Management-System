package Select;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.*;
import models.*;
import dao.*;

@WebServlet("/SelectGrp")
public class SelectGrp extends HttpServlet {
  
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
    		 int group_id = 0;
	         String name_group = "", specialty = "";
	         Group_studentsDAO groupDAO = (Group_studentsDAO) this.getServletContext().getAttribute("group_studentsDAO");
	         Groupstudent gr = groupDAO.get(Integer.valueOf(request.getParameter("id")));    
	         if(gr == null)
	        	 response.sendRedirect("Error.jsp");
	         group_id = gr.getGroup_id();
	         name_group = gr.getName_group();
	         specialty = gr.getSpecialty();           
	         response.sendRedirect("ResultGr.jsp?group_id=" + group_id + "&name_group=" + name_group + "&specialty=" + specialty);
 		 }
         catch (Exception e) {
    	     e.printStackTrace();
         }
    }
}