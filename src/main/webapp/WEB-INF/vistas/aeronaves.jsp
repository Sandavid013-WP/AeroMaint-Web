<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aeromaint.model.Aeronave" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>AeroMaint - Aeronaves</title>
</head>
<body>

    <h1>AeroMaint</h1>
    <h2>Aeronaves registradas</h2>

    <%
        String mensaje = request.getParameter("mensaje");

        if ("registrada".equals(mensaje)) {
    %>
        <p>Aeronave registrada correctamente.</p>
    <%
        }
    %>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Matrícula</th>
                <th>Modelo</th>
                <th>Fabricante</th>
                <th>Número de serie</th>
                <th>Ciclos</th>
                <th>Estado</th>
            </tr>
        </thead>

        <tbody>

        <%
            List<Aeronave> aeronaves =
                    (List<Aeronave>) request.getAttribute("aeronaves");

            if (aeronaves != null && !aeronaves.isEmpty()) {

                for (Aeronave aeronave : aeronaves) {
        %>

            <tr>
                <td><%= aeronave.getIdAeronave() %></td>
                <td><%= aeronave.getMatricula() %></td>
                <td><%= aeronave.getModelo() %></td>
                <td><%= aeronave.getFabricante() %></td>
                <td><%= aeronave.getNumeroSerie() %></td>
                <td><%= aeronave.getCiclos() %></td>
                <td><%= aeronave.getEstado() %></td>
            </tr>

        <%
                }

            } else {
        %>

            <tr>
                <td colspan="7">No hay aeronaves registradas.</td>
            </tr>

        <%
            }
        %>

        </tbody>
    </table>

    <br>

    <a href="/aeromaint-web/">Registrar nueva aeronave</a>

</body>
</html>
