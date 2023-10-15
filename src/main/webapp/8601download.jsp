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
        <h1>Downloads</h1>
        <h2>86 (the band) True Life Songs and Pictures</h2>
        <table>
            <tr>
                <th>Song title</th> <th>Audio Format</th>
            </tr>
            <tr>
                <td>You Are a Star</td>
                <td>
                    <a href="/hello/musicStore/sound/star.mp3">MP3</a>
                </td>
            </tr>
            <tr>
                <td>Don't Make No Difference</td>
                <td>
                    <a href="/musicStore/sound/${productCode}/no_difference.mp3">
                        MP3</a>
                </td>
            </tr>
        </table>
        <a href="download?action=viewAlbums">View Albums</a><br>    
        <a href="download?action=view_cookies">View All Cookies</a><br>
        <a href="/hello/#homework">Về Trang Chủ</a>
    </body>
</html>