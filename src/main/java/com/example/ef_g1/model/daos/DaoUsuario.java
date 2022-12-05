package com.example.ef_g1.model.daos;

import com.example.ef_g1.model.beans.Credenciales;
import com.example.ef_g1.model.beans.Usuario;

import java.sql.*;

public class DaoUsuario extends DaoBase{

    public Usuario buscarUsuario (int idUsuario){
        String sql = "select * from usuarios where idUsuario = ?";
        Usuario usuario = null;
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setApellido(rs.getString(3));
                    usuario.setCorreo(rs.getString(4));
                }
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return usuario;
    }

    public int registrarUsuario(Usuario usuario){
        int idUsuario = 0;
        String sql = "insert into usuarios values (?, ?, ?)";
        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getApellido());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.executeUpdate();
            ResultSet rsKeys = pstmt.getGeneratedKeys();
            if (rsKeys.next()){
                idUsuario = rsKeys.getInt(1);
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return idUsuario;
    }

    public boolean validarCorreo(String correo){
        String sql = "select * from usuarios where correo = ?";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()){
            if (rs.next()){
                return false;
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return true;
    }

    public Credenciales validarIniciarSesion(String correo, String password){
        Credenciales credenciales = null;
        String sql = "select * from credenciales where correo = and hashedPassword = sha2(?, 512)";
        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, correo);
            pstmt.setString(2, password);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    credenciales = new Credenciales();
                    credenciales.setIdUsuario(rs.getInt(1));
                    credenciales.setCorreo(rs.getString(2));
                    credenciales.setHashedPassword(rs.getString(3));
                }
            }
        }catch (SQLException e){
            e.getStackTrace();
        }
        return credenciales;
    }

    public void registrarCredenciales(Usuario usuario, String password){
        String sql = "insert into credenciales values (?, ?, sha2(?, 512))";
        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, usuario.getIdUsuario());
            pstmt.setString(2, usuario.getCorreo());
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.getStackTrace();
        }
    }


}
