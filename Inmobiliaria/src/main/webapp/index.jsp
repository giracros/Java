<%-- 
    Document   : index
    Created on : Dec 10, 2014, 7:31:51 PM
    Author     : danielfuentes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>   
    <div class="container">

      <form action="loginServlet" method="post" class="form-signin">
        <h2 class="form-signin-heading">Escribe tus datos</h2>
        <input name="username" type="text" class="input-block-level" placeholder="Nombre de usuario">
        <input name="password" type="password" class="input-block-level" placeholder="Contraseña">
        <button class="btn btn-large btn-primary" type="submit">Ingresar</button>
      </form>
    </div> <!-- /container -->
  </body>
</html>
