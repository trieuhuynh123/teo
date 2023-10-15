<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="main.css" type="text/css"/>
    </head>
    <body>
         <h1>Cookies</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <c:forEach items="${cookies}" var="c">
                <tr> <td>${c.getName()}</td>
                <td>${c.getValue()}</td></tr>
             </c:forEach>
        </table>
         <a href="download?action=delete_cookies">Delete Cookies </a><br>
       <a href="/hello/#homework">Về Trang Chủ</a>
    </body>
</html>