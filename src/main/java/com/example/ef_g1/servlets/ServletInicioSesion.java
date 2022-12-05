package com.example.ef_g1.servlets;

import com.example.ef_g1.model.beans.Credenciales;
import com.example.ef_g1.model.beans.Usuario;
import com.example.ef_g1.model.daos.DaoUsuario;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletInicioSesion", value = "/ServletInicioSesion")
public class ServletInicioSesion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null? "iniciarSesion":request.getParameter("action");
        DaoUsuario daoUsuario = new DaoUsuario();
        HttpSession session;
        switch (action){
            case "iniciarSesion":
                String correo = request.getParameter("correo");
                String password = request.getParameter("password");
                Credenciales credenciales = daoUsuario.validarIniciarSesion(correo, password);
                if (credenciales != null){
                    Usuario usuario = daoUsuario.buscarUsuario(credenciales.getIdUsuario());
                    session = request.getSession();
                    session.setAttribute("usuarioSession", usuario);
                    response.sendRedirect(request.getContextPath()+"/Inicio");
                }
                break;
            case "registrarse":
                String passw1 = request.getParameter("passw1");
                String passw2 = request.getParameter("passw2");
                String correo1 = request.getParameter("correo");
                if (daoUsuario.validarCorreo(correo1)){
                    if (passw1.equals(passw2)){

                        Usuario u = new Usuario();

                        u.setNombre(request.getParameter("nombre"));
                        u.setApellido(request.getParameter("apellido"));
                        u.setCorreo(correo1);

                        int idUsuario = daoUsuario.registrarUsuario(u);
                        u.setIdUsuario(idUsuario);
                        daoUsuario.registrarCredenciales(u, passw1);

                        response.sendRedirect(request.getContextPath()+"/");

                    }else {
                        session = request.getSession();
                        session.setAttribute("msgError", "Las contraseñas deben ser iguales");
                        response.sendRedirect(request.getContextPath()+"/?action=registrarse");
                    }
                }else {
                    session = request.getSession();
                    session.setAttribute("msgError", "El correo ingresado no está disponible");
                    response.sendRedirect(request.getContextPath()+"/?action=registrarse");
                }

                break;
        }


    }
}
