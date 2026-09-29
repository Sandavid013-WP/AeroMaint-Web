package com.aeromaint.servlet;

import com.aeromaint.dao.AeronaveDAO;
import com.aeromaint.model.Aeronave;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/aeronaves")
public class AeronaveServlet extends HttpServlet {

    private final AeronaveDAO aeronaveDAO = new AeronaveDAO();

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String matricula = request.getParameter("matricula");
        String modelo = request.getParameter("modelo");
        String fabricante = request.getParameter("fabricante");
        String numeroSerie = request.getParameter("numeroSerie");
        int ciclos = Integer.parseInt(request.getParameter("ciclos"));
        String estado = request.getParameter("estado");

        Aeronave aeronave = new Aeronave(
                matricula,
                modelo,
                fabricante,
                numeroSerie,
                ciclos,
                estado
        );

        try {

            aeronaveDAO.insertarAeronave(aeronave);

            response.sendRedirect("aeronaves?mensaje=registrada");

        } catch (Exception exception) {

            throw new ServletException(
                    "Error al registrar la aeronave",
                    exception
            );
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {

            request.setAttribute(
                    "aeronaves",
                    aeronaveDAO.listarAeronaves()
            );

            request.getRequestDispatcher(
                    "/WEB-INF/vistas/aeronaves.jsp"
            ).forward(request, response);

        } catch (Exception exception) {

            throw new ServletException(
                    "Error al consultar las aeronaves",
                    exception
            );
        }
    }
}
