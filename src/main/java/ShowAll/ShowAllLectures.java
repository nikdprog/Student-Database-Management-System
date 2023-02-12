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
  
@WebServlet("/ShowAllLectures")
public class ShowAllLectures extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws  IOException {
    	 try {
             Class.forName(DbInitListener.DRIVER);
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
    	try {
    
        	LecturesDAO lectDAO = (LecturesDAO) this.getServletContext().getAttribute("lecturesDAO");
        	ArrayList<Lectures> lst2 = lectDAO.getAll(); 
        	for (Lectures st2 : lst2) {
        		 
                int lecture_id = st2.getLecture_id();
                request.setAttribute("lecture_id", lecture_id);
 
                String surname = st2.getSurname();
                request.setAttribute("surname", surname);
 
                String name_ = st2.getName_();
                request.setAttribute("name_",name_);
 
                String second_name = st2.getSecond_name();
                request.setAttribute("second_name",second_name);
 
                String phone_number = st2.getPhone_number();
                request.setAttribute("phone_number",phone_number);
 
                String work_experience = st2.getWork_experience();
                request.setAttribute("work_experience", work_experience);
  
            }
            
        	request.setAttribute("lst2", lst2); // Will be available as
        	//request.setAttribute("lst2", lst2);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Lectures.jsp");
             
             dispatcher.forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}