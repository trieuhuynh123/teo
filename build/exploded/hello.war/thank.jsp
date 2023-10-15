<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <label>Date of Birth:</label>
        <span>${user.date}</span><br>
        <label>Hear:</label>
        <span>${user.hear}</span><br>
        <c:if test = "${(user.noti[1]==null && user.noti[0]==null) }">
            <label>Like That: No</label><br>
            <label>Update: No</label>
        </c:if>
        <c:if test = "${(user.noti[1]!=null && user.noti[0]!=null) }">
            <label>Like That: Yes</label><br>
            <label>Update: Yes</label>
            <br><label>Contact:</label>
            <span>${user.con}</span><br>
        </c:if>
        <c:if test = "${(user.noti[1]==null && user.noti[0]!=null) }">
            <c:if test = "${user.noti[0]=='YES, please send me email announcements'}">
                <label>Like That: No</label><br>
                <label>Update: Yes</label>
                <br><label>Contact:</label>
                <span>${user.con}</span><br>
            </c:if>
            <c:if test = "${user.noti[0]=='YES, i\\\'d like that'}">
                <label>Like That: Yes</label><br>
                <label>Update: No</label>
            </c:if>
        </c:if>
        
        
        <p>To enter another email address, click on the Back button in your browser or the Return button shown
            below.</p>
        <form action="" method="get">
            <input type="hidden" name="action" value="join"> <input type="submit" value="Return">
        </form>
        <a href="/hello/#homework">Về Trang Chủ</a>
    </body>
</html>