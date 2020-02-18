<%-- 
    Document   : orderDetail
    Created on : 2019-3-11, 13:59:08
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello! User</h1><c:out value="${userId}" />
        <h1>Here is your order:</h1><c:out value="${keyword}" />

        
        
        
        <table>
            <tr>
             
            <th>Dish Name</th>
            <th>Dish Price</th>
            <th>Order Number</th>
            </tr>
            <c:forEach var="orders" items="${orders}">
                    <tr>
                    <td><c:out value="${orders.dishName}" /></td>
                    <td><c:out value="${orders.dishPrice}" /></td>
                    <td><c:out value="${orders.orderNumber}" /></td>  
                    </tr>
            </c:forEach>


        </table>
        <br>The Total Price:
        <c:out value="${total}" />
        
        <br>
        <br><a href="index.htm"> Back to Main Interface !</a>
        
           
    </body>
</html>
