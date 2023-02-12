<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href = "styletables.css">
<title>Insert title here</title>
<link rel="icon" href="favicon1.ico" type="image/x-icon">
</head>
<body>

	<table border="5"  bgcolor="white">
    	        <tr>
        	        <th>Lecture_id</th>
                	<th>Surname</th>
                	<th>Name</th>
               	    <th>Second_name</th>
                	<th>Phone_number</th>
                	<th>Work_experience</th>
               </tr>
               <c:forEach items="${lst2}" var="lst2">
            	<tr>
                    <td> ${lst2.lecture_id} </td>
                	<td> ${lst2.surname} </td>
                	<td> ${lst2.name_} </td>
                	<td> ${lst2.second_name} </td>
                	<td> ${lst2.phone_number} </td>
                	<td> ${lst2.work_experience} </td>
               </tr>
              </c:forEach>
	</table>
    <input type="button"  value="Insert data"
    onclick="window.location.href='InsertLect.jsp'" />
                
    <form action="./SelectLect" method="get">       
    Enter ID:
    <input type="text" name="id" maxlength="6" size="7" />                 
    <br /> <input type="submit" value="View Data" />
    </form>
    
    
	   
	<form action="./DeleteLect" method="post">
               Enter ID:
               <input type="text" name="id" maxlength="6" size="7" />
        <br /> <input type="submit" value="Delete Data" />
    </form>   
   
    	
     <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
</body>
</html>