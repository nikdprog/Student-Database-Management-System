<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href = "styletables.css">
<title>Update page</title>
<link rel="icon" href="favicon1.ico" type="image/x-icon">
</head>
<body>
<h2>Fill in your details</h2>
  
    <form action="./UpdateLect" method="post">
        <table>
            <tr>
                <td>Lecture ID:</td>
                <td><input type="text" name="id"
                    value="<%=request.getParameter("id")%>" readonly="readonly">
                </td>
            </tr>     
              <tr>
                <td>Surname:</td>
                <td><input type="text" name="surname" maxlength="30" size="25" /></td>
            </tr>
              <tr>
                <td>Name:</td>
                <td><input type="text" name="name" maxlength="30" size="25" /></td>
            </tr>
              <tr>
                <td>Second name:</td>
                <td><input type="text" name="second_name" maxlength="30" size="25" /></td>
            </tr>
              <tr>
                <td>Phone number:</td>
                <td><input type="text" name="phone_number" maxlength="30" size="25" /></td>
            </tr>
            <tr>
                <td>Work experience:</td>
                <td><input type="text" name="work_experience" maxlength="40" size="35" /></td>
            </tr>
            <tr />
        </table>
        <br /> <input type="submit" value="Update Data" />
    </form>
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
  
</body>
</html>