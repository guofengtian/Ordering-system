<%-- 
    Document   : customer
    Created on : 2019-4-17, 17:44:24
    Author     : fengt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Admin Login Section</h1>
        <form action="administrator.htm" method="post">
            <label> Adminname :  </label><input type="text" name="adminName" />
            <label> Password :  </label><input type="password" name="password" />
            <input type="hidden" value="login" name="option" />
            <input type="submit" value="Login"/>
       </form>
        <br/><br/><br/><br/><br/><br/><br/>
        <h1>Admin Registration Section</h1>
       <form action="administrator.htm" method="post">
            <label> Adminname :  </label><input type="text" name="adminName" />
            <label> Password :  </label><input type="password" name="password" />            
            <input type="hidden" value="register" name="option" />
            <input type="submit" value="Sign Up"/>
         </form>
    </body>
</html>


