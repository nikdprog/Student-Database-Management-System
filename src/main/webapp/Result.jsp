<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel = "stylesheet" href = "result.css">
<title>Result is</title>
<link rel="icon" href="favicon1.ico" type="image/x-icon">
</head>
<body>

    <h2>Details</h2>
  
    <form>
        <input type="hidden" name="student_id"
            value="<%=request.getParameter("stud_id")%>">
        <table>
            <tr>
                <td>Student ID:</td>
                <td><%=request.getParameter("stud_id")%></td>
            </tr>
            <tr>
                <td>Group ID:</td>
                <td><%=request.getParameter("group_id")%></td>
            </tr>
             <tr>
                <td>Surname:</td>
                <td><%=request.getParameter("surname")%></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><%=request.getParameter("name")%></td>
            </tr>
            <tr>
                <td>second_name:</td>
                <td><%=request.getParameter("second_name")%></td>
            </tr>
             <tr>
                <td>phone number:</td>
                <td><%=request.getParameter("phone_number")%></td>
            </tr>
             <tr>
                <td>Grant:</td>
                <td><%=request.getParameter("grant_")%></td>
            </tr>
            <tr />
        </table>
        <br />
    </form>
    <br />
    <input type="button" value="Update data" onclick="update()" />
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
    

</body>

<script language="javascript" type="text/javascript">
    function update() {
        var sid = document.forms[0].elements['student_id'].value;
        window.location.href = "Update.jsp?id=" + sid;
    }
</script>

</html>