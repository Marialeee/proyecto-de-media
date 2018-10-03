/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import modelo.Administrador;

/**
 *
 * @author User
 */
public class FormularioAdministradores {

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
        
        Administrador n = new Administrador();
        n.nombre = nombre;
        n.nacimiento = nacimiento;
        n.cedula = cedula;
        n.telefono = telefono;
        n.edad = edad;
        
        List<Administrador> listaAdministradores = new ArrayList<>();
        listaAdministradores.add(n);
        
        Administrador n2 = new Administrador();
        n2.nombre = "camila";
        n2.nacimiento = "31/01/2001";
        n2.cedula = "45'712'468";
        n2.telefono = "588-29-08";
        n2.edad = "17-anios";
        
        listaAdministradores.add(n2);
        
        Administrador n3 = new Administrador();
        n3.nombre = "mariale";
        n3.nacimiento = "26/05/2003";
        n3.cedula = "08´469´370";
        n3.telefono = "581-54-34";
        n3.edad = "15-anios";
        
        listaAdministradores.add(n3);
        
        Administrador n4 = new Administrador();
        n4.nombre = "cristian";
        n4.nacimiento = "01/06/2002";
        n4.cedula = "9´712´468";
        n4.telefono = "556-33-63";
        n4.edad = "16-anios";
        
        listaAdministradores.add(n3);
        
        request.setAttribute("lista", listaAdministradores);
        
        rd.forward(request, (ServletResponse) response);
    }


    
}
