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
  
@WebServlet("/ShowAllGroupstudent")
public class ShowAllGroupstudent extends HttpServlet {
  
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws  IOException {
    	 try {
             Class.forName(DbInitListener.DRIVER);
         } catch (ClassNotFoundException e) {
             System.out.println("Class not found " + e);
         }
    	try {
    
    		Group_studentsDAO groupstudentDAO = (Group_studentsDAO) this.getServletContext().getAttribute("group_studentsDAO");
        	ArrayList<Groupstudent> lst = groupstudentDAO.getAll(); 
        	for (Groupstudent grp : lst) {
        		
        		int group_id = grp.getGroup_id();
        		request.setAttribute("group_id", group_id);
        		
                String name_group = grp.getName_group();
                request.setAttribute("name_group",name_group);
              
                String specialty = grp.getSpecialty();
                request.setAttribute("specialty",specialty);         
            
            }
        	request.setAttribute("lst", lst); // Will be available as
        	//request.setAttribute("lst2", lst2);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Groupstudent.jsp");
             
             dispatcher.forward(request, response);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}