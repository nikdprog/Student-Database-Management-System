package Select;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listener.*;
import models.*;
import dao.*;

@WebServlet("/SelectStud")
public class SelectStud extends HttpServlet {
  
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
    		 int stud_id = 0, group_id = 0;
	         double grant = 0;
	         String surname = "", name = "", second_name = "", phone_number = "";
	         StudentsDAO studDAO = (StudentsDAO) this.getServletContext().getAttribute("studentsDAO");
	         Students st = studDAO.get(Integer.valueOf(request.getParameter("id")));
	         if(st == null)
	        	  response.sendRedirect("Error.jsp");
	         stud_id = st.getStudent_id();
	         group_id = st.getGroup_id();
	         surname = st.getSurname();
	         name = st.getName_();
	         second_name = st.getSecond_name();
	         phone_number = st.getPhone_number();
	         grant = st.getGrant_();   
	         response.sendRedirect("Result.jsp?stud_id=" + stud_id + "&group_id=" + group_id + "&surname=" + surname + "&name=" + name  + "&second_name=" + second_name  + "&phone_number=" + phone_number  + "&grant_=" + grant);
    	 }
         catch (Exception e) {
    	     e.printStackTrace();
         }
    }
}