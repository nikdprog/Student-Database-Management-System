package ShowAll;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import dao.*;
import models.*;
import listener.*;
  
@WebServlet("/ShowAllStudents")
public class ShowAllStudents extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws  IOException {
    	 try {
             Class.forName(DbInitListener.DRIVER);
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
    	try {
    
    		StudentsDAO studDAO = (StudentsDAO) this.getServletContext().getAttribute("studentsDAO");
        	ArrayList<Students> lst = studDAO.getAll(); 
        	for (Students st : lst) {
        		 
                int student_id = st.getStudent_id();
                request.setAttribute("student_id",student_id);
 
                int group_id = st.getGroup_id();
                request.setAttribute("group_id",group_id);
 
                String surname = st.getSurname();
                request.setAttribute("surname",surname);
 
                String name_ = st.getName_();
                request.setAttribute("name_",name_);
 
                String second_name = st.getSecond_name();
                request.setAttribute("second_name",second_name);
 
                String phone_number = st.getPhone_number();
                request.setAttribute("phone_number",phone_number);
 
                double grant_ = st.getGrant_();
                request.setAttribute("grant_",grant_);
 
            }
        	request.setAttribute("lst", lst); // Will be available as
        	//request.setAttribute("lst2", lst2);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Students.jsp");
             
             dispatcher.forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}