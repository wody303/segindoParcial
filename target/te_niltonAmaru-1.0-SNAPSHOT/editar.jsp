<%@page import="com.emergentes.modelo.Registro"%>
<%
    Registro item = (Registro) request.getAttribute("miRegistro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segundo Parcial</title>
    </head>
    <body>
        <h1><%=(item.getId() == 0) ? "Nuevo Registro" : "Editar Registro"%></h1>
        <form action="MainController" method="POST">

            <input type="hidden" name="id" value="<%=item.getId()%>"/>

            <table>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion" value="<%=item.getDescripcion()%>"/></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="text" name="cantidad" value="<%=item.getCantidad()%>"/></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" name="precio" value="<%=item.getPrecio()%>"/></td>
                </tr>
                <tr>
                    <td>Categoria</td>
                    <td><select name="categoria" value="<%=item.getCategoria()%>">
                            <option>Refresco</option>
                            <option>Galleta</option>
                            <option>Verdura</option>
                        </select></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>



    </body>
</html>
