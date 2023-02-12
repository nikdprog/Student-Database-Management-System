package listener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener; 

@WebListener()
public class DbInitListener implements ServletContextListener
{
	final String URL = "jdbc:postgresql://localhost/lab1bd"; 
    final String USER = "postgres"; 
    final String PASSWORD = "nikita228"; 
    public final static String DRIVER = "org.postgresql.Driver";
    
public void contextInitialized(ServletContextEvent sce) {
	try {
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		StudentsDAO studentsDAO = new StudentsDAO(conn); 
		Group_studentsDAO group_studentsDAO = new Group_studentsDAO(conn);
		LecturesDAO lecturesDAO = new LecturesDAO(conn);
		MarksDAO marksDAO = new MarksDAO(conn);
		SubjectsDAO subjectsDAO = new SubjectsDAO(conn);
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("studentsDAO", studentsDAO);
		sc.setAttribute("group_studentsDAO", group_studentsDAO);
		sc.setAttribute("lecturesDAO", lecturesDAO);
		sc.setAttribute("marksDAO", marksDAO);
		sc.setAttribute("subjectsDAO", subjectsDAO);
		sc.setAttribute("conn", conn);
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
}