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
            	    <th>Group id</th>
        	        <th>Name group</th>         	    
                	<th>Specialty</th>                	        	  
               </tr>
               <c:forEach items="${lst}" var="lst">
            	<tr>
            	 	<td> ${lst.group_id} </td>
                	<td> ${lst.name_group} </td>                  
                	<td> ${lst.specialty} </td>            	          	
               </tr>
              </c:forEach>
	</table>
    <input type="button"  value="Insert data"
    onclick="window.location.href='InsertGroupstudent.jsp'" />
    
    <form action="./SelectGrp" method="get">      
    Enter ID:
    <input type="text" name="id" maxlength="6" size="7" />            
    <br /> <input type="submit" value="View Data" />
    </form>
        
	<form action="./DeleteGrp" method="post">
               Enter ID:
               <input type="text" name="id" maxlength="6" size="7" />
        <br /> <input type="submit" value="Delete Data" />
    </form>   
   
   
     <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
</body>
</html>