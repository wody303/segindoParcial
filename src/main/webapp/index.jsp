<%@page import="com.emergentes.modelo.Registro"%>
<%@page import="java.util.ArrayList" %>

<%
    ArrayList<Registro> lista = (ArrayList< Registro>) session.getAttribute("listareg");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border = " 1 " align="center" >
            <tr>
                <th>

                    <h2> SEGUNDO PARCIAL TEM - 742 </h2>
                    <h3> Nombre : Nilton Amaru Mollisaca </h3>
                    <h3> Carnet : 13309803 </h3> 
                </th>
            </tr>
        </table>
    <center><h1> Productos </h1></center>
    <a href="MainController?op=nuevo"> Nuevo Producto</a>
    <table border="1" align="center">
        <tr>

            <th>Id</th>

            <th>Descripcion</th>

            <th>Cantidad</th>

            <th>Precio</th> 

            <th>Categoria</th>

            <th>Editar</th> 
            <th>Eliminar</th>

        </tr>
        <%
            if (lista != null) {

                for (Registro item : lista) {
        %>
        <tr>
            <td><%= item.getId()%></td>

            <td><%= item.getDescripcion()%></td>

            <td><%= item.getCantidad()%></td>

            <td><%= item.getPrecio()%></td>

            <td><%= item.getCategoria()%></td>

            <td><a href="MainController?op=editar&id=<%= item.getId()%>">Editar</a></td> 
            <td><a href="MainController?op=eliminar&id=<%= item.getId()%>" onclick='return confirm("Esta aeguro de eliminar ?");'>Eliminar</a></td>
        </tr>

        <%
                }
            }
        %>

    </table>

</body>
</html>
