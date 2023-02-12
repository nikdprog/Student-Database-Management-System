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
        <input type="hidden" name="mark_id"
            value="<%=request.getParameter("mark_id")%>">
        <table>
            <tr>
                <td>Mark ID:</td>
                <td><%=request.getParameter("mark_id")%></td>
            </tr>
             <tr>
                <td>Mark:</td>
                <td><%=request.getParameter("mark")%></td>
            </tr>
            <tr>
                <td>Student ID:</td>
                <td><%=request.getParameter("student_id")%></td>
            </tr>
            <tr>
                <td>Subject ID:</td>
                <td><%=request.getParameter("subject_id")%></td>
            </tr>
            <tr>
                <td>Lecture ID:</td>
                <td><%=request.getParameter("lecture_id")%></td>
            </tr>         
            <tr>
                <td>Modification time:</td>
                <td><%=request.getParameter("modification_time")%></td>
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
        var gid = document.forms[0].elements['mark_id'].value;
        window.location.href = "UpdateMrk.jsp?id=" + gid;
    }
</script>

</html>