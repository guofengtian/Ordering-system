<%-- 
    Document   : order
    Created on : 2019-4-17, 18:48:15
    Author     : fengt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
        <div> 
            <form action = "orderTake.htm" method = "POST">
         <table>
            <tr>
             
            <th>Dish Name</th>
            <th>Dish Number</th>
            <th>Dish Price</th>
            <th>Order Number</th>
            </tr>
            <c:forEach var="dishes" items="${dishes}">
                    <tr>
                    <td><c:out value="${dishes.dishName}" /></td>
                    <td><c:out value="${dishes.dishNumber}" /></td>
                    <td><c:out value="${dishes.dishPrice}" /></td>
                    <td><input type="text" name="${dishes.id}" value="0"/></td>
           
                    </tr>
            </c:forEach> 
        </table>
            <input type="hidden" value="add" name="option" />
            <input type="submit" value="Submit"/> 
            </form>
             <c:out value="${keyword}" />
        </div>
        
        <div> 
            <form action = "orderTake.htm" method = "POST">
            <input type="hidden" value="view" name="option" />
            <input type="submit" value="Order Details"/> 
            </form>
        </div>
     
    </body>
</html>
