<%-- 
    Document   : manage
    Created on : 2019-4-19, 14:40:10
    Author     : fengt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div> 
            <h1>Add Dish</h1>
        <form action="dishManage.htm" method="post">
            <label> DishName :  </label><input type="text" name="dishName" />
            <label> DishNumber :  </label><input type="text" name="dishNumber" />
            <label> DishPrice :  </label><input type="text" name="dishPrice" />
            <input type="hidden" value="add" name="option" />
            <input type="submit" value="Add"/>
       </form>
        <br/><br/><br/><br/><br/><br/><br/>
        <h1>Update Dish</h1>
       <form action="dishManage.htm" method="post">
            <label> DishName you want to update:  </label><input type="text" name="dishName" />
            <label> New DishNumber :  </label><input type="text" name="dishNumber" />
            <label> New DishPrice :  </label><input type="text" name="dishPrice" />      
            <input type="hidden" value="update" name="option" />
            <input type="submit" value="Update"/>
         </form>
        </div>   
        <div> 
            <form action = "viewDish.htm" method = "POST">
            <input type="submit" value="View"/> 
            </form>
        </div>
    </body>
</html>
