/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(n);
        
        Usuario n2 = new Usuario();
        n2.nombre = "marimaca";
        n2.nacimiento = "15/08/2000";
        n2.cedula = "123'456'76";
        n2.telefono = "543-21-55";
        n2.edad = "18-anios";
        
        listaUsuarios.add(n2);
        
        Usuario n3 = new Usuario();
        n3.nombre = "rogelio";
        n3.nacimiento = "11/11/1999";
        n3.cedula = "987'654'77";
        n3.telefono = "582-29-21";
        n3.edad = "18-anios";
        
        listaUsuarios.add(n3);
        
        request.setAttribute("lista", listaUsuarios);
        
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
