<%-- 
    Document   : formulario-usuario
    Created on : 26/09/2018, 09:27:37 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formulario de Usuario</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <h1>Formulario para crear usuarios</h1>
        <form method="post" action="FormularioUsuarios">
            <div class="form-group">
                <label for="inputNombre">Nombre</label>
                <input name="nombre" type="text" class="form-control" id="inputNombre" aria-describedby="emailHelp" placeholder="Ingrese su nombre">
            </div>
            <div class="form-group">
                <label for="inputCorreo">Fecha de nacimiento</label>
                <input name="nacimiento" type="password" class="form-control" id="inputNacimiento" aria-describedby="emailHelp" placeholder="Ingrese su fecha de nacimiento">
            </div>
            <div class="form-group">
                <label for="inputContrasena">Cédula</label>
                <input name="cedula" type="password" class="form-control" id="inputCedula" aria-describedby="emailHelp" placeholder="Ingrese su cédula">
            </div>
            <div class="form-group">
                <label for="inputContrasena">Teléfono</label>
                <input name="telefono" type="password" class="form-control" id="inputTelefono" aria-describedby="emailHelp" placeholder="Ingrese su teléfono">
            </div>
            <div class="form-group">
                <label for="inputContrasena">Edad</label>
                <input name="edad" type="password" class="form-control" id="inputEdad" aria-describedby="emailHelp" placeholder="Ingrese su edad">
            </div>
            <button type="submit" class="btn btn-primary">Guardar Usuario</button>
        </form>
        <div class="container">
            <table>
                <tr>
                    <th>nombre</th>
                    <th>nacimineto</th>
                    <th>cedula</th>
                    <th>telefono</th>
                    <th>edad</th>
                </tr>
            <%@page import="modelo.Usuario" %>
            <%@page import="java.util.List" %>
            <% List<Usuario> listaUsuarios = (List<Usuario>)request.getAttribute("lista"); %>
            <%
            Usuario n;
            for(int i = 0; i < listaUsuarios.size(); i++){
                n = listaUsuarios.get(i);
            %>
            <!--codigo html-->
                <tr>
                    <td><%= n.nombre %></td>
                    <td><%= n.nacimiento %></td>
                    <td><%= n.cedula %></td>
                    <td><%= n.telefono %></td>
                    <td><%= n.edad %></td>
                </tr>
            <%
            }%>
            </table>
        </div>
    </div>
</body>

</html>