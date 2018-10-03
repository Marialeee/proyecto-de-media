/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class FormularioUsuarios extends HttpServlet {
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/formulario-usuario.jsp");
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        
        request.setAttribute("lista", listaUsuarios);
        
        rd.forward(request, response);
    
    }
    

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/formulario-usuario.jsp");
        
        String nombre = request.getParameter("nombre");
        String nacimiento = request.getParameter("nacimiento");
        String cedula = request.getParameter("cedula");
        String telefono = request.getParameter("telefono");
        String edad = request.getParameter("edad");
        
        Usuario n = new Usuario();
        n.nombre = nombre;
        n.nacimiento = nacimiento;
        n.cedula = cedula;
        n.telefono = telefono;
        n.edad = edad;
        
        guardarUsuario (n);
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(n);
        
        
        request.setAttribute("lista", listaUsuarios);
        
        rd.forward(request, response);
    }
    
    public void guardarUsuario(Usuario n){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/animal", "root", "");
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO usuarios (nombre, nacimiento, cedula, telefono, edad) VALUES (?,?,?,?,?)");
            ps.setString(1, n.nombre);
            ps.setString(2, n.nacimiento);
            ps.setString(3, n.cedula);
            ps.setString(4, n.telefono);
            ps.setString(5, n.edad);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}