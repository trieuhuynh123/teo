<%-- 
    Document   : cart
    Created on : Oct 10, 2023, 8:35:38 AM
    Author     : huynh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Murach's Java Servlets and JSP</title>
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <script src="cart.js"></script>
    </head>
    <body>
        <h1>Your cart</h1>
        <table>
            <tr>
                <th>Quantity</th>
                <th>Description</th>
                <th>Price</th>
                <th>Amount</th>
                <th></th>
            </tr>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
            <c:forEach var="item" items="${cart.items}">
                <tr>
                    <td>
                        <form action="" method="post">
                            <input type="hidden" name="productCode" value="<c:out value='${item.product.code}'/>"> 
                            <input type=text name="quantity" value="<c:out value='${item.quantity}'/>" id="quantity">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td><c:out value='${item.product.description} '/></td> <td>${item.product.priceCurrencyFormat}</td>
                    <td>${item.totalCurrencyFormat}</td>
                    <td> <form action="" method="post">
                            <input type="hidden" name="productCode" value="<c:out value='${item.product.code}'/>">
                            <input type="hidden" name="quantity" value="0">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p>To change the quantity, enter the new quantity and click on the Update button.</p>
        <form action="" method="post">
            <input type="hidden" name="action" value="shop">
            <input type="submit" value="Continue Shopping"> </form>
        <form action="" method="post">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" value="Checkout">
        </form>
        <a href="/hello/#homework">Về Trang Chủ</a>
    </body>
</html>
