<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
       
    </head>
    <body>
        <h1>Thanks for joining our email list</h1>
        <p>Here is the information that you entered:</p>
        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>First Name:</label>
        <span>${user.firstName}</span><br>
        <label>Last Name:</label>
        <span>${user.lastName}</span><br>
        <label>Current Date:</label>
        <span>${currentdate}</span><br>
        <label>First user:</label>
        <span>${users[0].email}</span><br>
        <label>Second user:</label>
        <span>${users[1].email}</span><br>
        <label>Customer Service Email:</label>
        <span>${custServEmail}</span><br>
        <form action="" method="get">
            <input type="hidden" name="action" value="join"> <input type="submit" value="Return">
        </form>
        <%@include file="/footer.jsp"%><br>
    </body>
   <a href="/hello/#homework">Về Trang Chủ</a>
</html>