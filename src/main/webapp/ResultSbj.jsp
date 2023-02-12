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
        <input type="hidden" name="subject_id"
            value="<%=request.getParameter("subject_id")%>">
        <table>
            <tr>
                <td>Group ID:</td>
                <td><%=request.getParameter("subject_id")%></td>
            </tr>
            <tr>
                <td>Subject:</td>
                <td><%=request.getParameter("subject")%></td>
            </tr>
            <tr>
                <td>Hours:</td>
                <td><%=request.getParameter("hours")%></td>
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
        var gid = document.forms[0].elements['subject_id'].value;
        window.location.href = "UpdateSubj.jsp?id=" + gid;
    }
</script>

</html>