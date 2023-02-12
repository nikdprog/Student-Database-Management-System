<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href = "styletables.css">
<title>SDMS</title>
<link rel="icon" href="favicon1.ico" type="image/x-icon">
</head>

<body>
<h2 align="left">Welcome to Student database management system</h2>
    <br />
    <form action="./ShowAllStudents" method="get">
            <div>
            <input type="Submit" value="Students"  />
            </div>
    </form>  
      
   <form action="./ShowAllLectures" method="get">
            <div>
            <input type="Submit" value="Lectures"/> 
            </div>
   </form> 
      
   <form action="./ShowAllSubjects" method="get">
            <div>
            <input type="Submit"  value="Subjects" /> 
            </div>
   </form>    
   
   <form action="./ShowAllMarks" method="get" >
            <div>
            <input type="Submit" value="Marks"/>
            </div>
   </form>    
           
   <form action="./ShowAllGroupstudent" method="get">
            <div>
            <input type="Submit" value="Groups of students" /> 
            </div>
    </form>     
    
</body>
</html>