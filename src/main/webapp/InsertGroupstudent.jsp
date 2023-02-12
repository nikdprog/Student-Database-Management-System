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
    <form action="./InsertGrp" method="post">
        <table>
            <tr>
                <td>name_group:</td>
                <td><input type="text" name="name_group" maxlength="30" size="25" /></td>
            </tr>
            <tr>
                <td>Specialty:</td>
                <td><input type="text" name="specialty" maxlength="40" size="35" /></td>
            </tr>
        </table>
        <br /> <input type="submit" name="gr_id" value="Insert Data" />
  
    </form>
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
  
</body>
</html>