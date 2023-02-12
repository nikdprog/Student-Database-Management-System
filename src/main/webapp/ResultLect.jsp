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
        <input type="hidden" name="lecture_id"
            value="<%=request.getParameter("lecture_id")%>">
        <table>
            <tr>
                <td>Lecture ID:</td>
                <td><%=request.getParameter("lecture_id")%></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td><%=request.getParameter("surname")%></td>
            </tr>
             <tr>
                <td>Name:</td>
                <td><%=request.getParameter("name_")%></td>
            </tr>
            <tr>
                <td>Second name:</td>
                <td><%=request.getParameter("second_name")%></td>
            </tr>
            <tr>
                <td>Phone number:</td>
                <td><%=request.getParameter("phone_number")%></td>
            </tr>
             <tr>
                <td>Work experience:</td>
                <td><%=request.getParameter("work_experience")%></td>
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
        var sid = document.forms[0].elements['lecture_id'].value;
        window.location.href = "UpdateLect.jsp?id=" + sid;
    }
</script>

</html>