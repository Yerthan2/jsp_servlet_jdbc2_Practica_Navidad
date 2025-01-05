<%--
  Created by IntelliJ IDEA.
  User: 34691
  Date: 05/01/2025
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Editar socios</h2>

<form method="post" action="EditarSociosServlet">

    Id del usuario <input type="text" name="idUsuario"><br>
    Nombre <input type="text" name="nombre"/></br>
    Estatura <input type="text" name="estatura"/></br>
    Edad <input type="text" name="edad"/></br>
    Localidad <input type="text" name="localidad"/></br>
    <input type="submit" value="Aceptar">
</form>

<a href="../../index.jsp">Volver a la pagina principal</a>
</body>
</html>
