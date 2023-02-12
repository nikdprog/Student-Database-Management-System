<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href = "result.css">
<title>Insert into database</title>
<link rel="icon" href="favicon1.ico" type="image/x-icon">
</head>
<body>
    <h2>Fill in the details</h2>
    <form action="./InsertMrk" method="post">
        <table>
            <tr>
                <td>Mark:</td>
                <td><input type="text" name="mark" maxlength="30" size="25" /></td>
            </tr>
            <tr>
                <td>Student ID:</td>
                <td><input type="text" name="student_id" maxlength="40" size="35" /></td>
            </tr>
            <tr>
                <td>Subject ID:</td>
                <td><input type="text" name="subject_id" maxlength="10" size="11" /></td>
            </tr>
            <tr>
                <td>Lecture ID:</td>
                <td><input type="text" name="lecture_id" maxlength="40" size="35" /></td>
            </tr>
            <tr />
        </table>
        <br /> <input type="submit" name="mrk_id" value="Insert Data" />
  
    </form>
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
  
</body>
</html>