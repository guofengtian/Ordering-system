<%-- 
    Document   : searchResult
    Created on : 2019-3-11, 18:37:18
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
     
        <br>Here are the search results :

        <table>
            <tr>
             
            <th>Dish Name</th>
            <th>Dish Number</th>
            <th>Dish Price</th>
            </tr>
            <c:forEach var="dishes" items="${dishes}">
                    <tr>
                    <td><c:out value="${dishes.dishName}" /></td>
                    <td><c:out value="${dishes.dishNumber}" /></td>
                    <td><c:out value="${dishes.dishPrice}" /></td>
           
                    </tr>
            </c:forEach> 
        </table>
   
        <br>
        <br><a href="index.htm"> Back to Main Interface !</a>
    </body>
    
    
</html>
