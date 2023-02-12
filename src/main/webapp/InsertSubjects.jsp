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
    <form action="./InsertSubj" method="post">
        <table>
            <tr>
                <td>Subject:</td>
                <td><input type="text" name="subject" maxlength="40" size="35" /></td>
            </tr>
             <tr>
                <td>hours:</td>
                <td><input type="text" name="hours" maxlength="40" size="35" /></td>
            </tr>
            <tr />
        </table>
        <br /> <input type="submit" name="subj_id" value="Insert Data" />
  
    </form>
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
  
</body>
</html>