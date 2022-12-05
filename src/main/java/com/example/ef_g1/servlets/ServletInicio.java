package com.example.ef_g1.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletInicio", value = "/ServletInicio")
public class ServletInicio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (action == null) ? "registrarServicio" : action;
        RequestDispatcher requestDispatcher;
        HttpSession session = request.getSession();
        switch (action) {
            case "registrarImpresion3D":
                requestDispatcher = request.getRequestDispatcher("RegistrarImpresion.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "ListaServicios":
                requestDispatcher = request.getRequestDispatcher("ListaServicios.jsp");
                requestDispatcher.forward(request, response);
                break;

            case "registrarCorteLaser":
                requestDispatcher = request.getRequestDispatcher("RegistrarCorte.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "registrarEscaneo3D":
                HttpSession sessionUsuario = request.getSession();
                requestDispatcher = request.getRequestDispatcher("RegistrarEscaneo.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "registrarServicio":

                break;

            case "cerrarSesion":
                session.invalidate();
                response.sendRedirect(request.getContextPath());
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
