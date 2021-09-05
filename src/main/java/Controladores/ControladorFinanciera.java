/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.CargarDatos;
import Modelos.Reportes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelos.Usuarios;
import Modelos.UsuariosBD;
import Modelos.Venta;
import java.util.List;

/**
 *
 * @author karlamatias
 */
@WebServlet(name = "ControladorFinanciera", urlPatterns = {"/ControladorFinanciera"})
public class ControladorFinanciera extends HttpServlet {

    Usuarios us = new Usuarios();
    UsuariosBD usBD = new UsuariosBD();

    CargarDatos cargar = new CargarDatos();
    String uss;
    Reportes rep = new Reportes();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Financiera")) {
            switch (accion) {
                case "ReporteVentas":
                    
                    rep.reporteVentas();
                    break;

            }
          
        }
        if (menu.equals("Administracion")) {

            switch (accion) {
                case "Listar":
                    List Lista = usBD.Listar();
                    request.setAttribute("usuario", Lista);
                    break;
                case "Agregar":
                    String usuario = request.getParameter("txtus");
                    String area = request.getParameter("txtarea");
                    String password = request.getParameter("txtpass");
                    us.setUsuario(usuario);
                    us.setArea(area);
                    us.setPassword(password);
                    usBD.Agregar(us);
                    request.getRequestDispatcher("ControladorFinanciera?menu=Administracion&accion=Listar").forward(request, response);

                    break;
                case "Editar":

                    uss = request.getParameter("id");
                    Usuarios u = usBD.listarporID(uss);
                    request.setAttribute("usuario", u);
                    request.getRequestDispatcher("ControladorFinanciera?menu=Administracion&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String usuario1 = request.getParameter("txtus");
                    String area1 = request.getParameter("txtarea");
                    String password1 = request.getParameter("txtpass");
                    us.setUsuario(usuario1);
                    us.setArea(area1);
                    us.setPassword(password1);
                    usBD.Actualizar(us);
                    request.getRequestDispatcher("ControladorFinanciera?menu=Administracion&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":

                    uss = request.getParameter("id");
                    usBD.Eliminar(uss);
                    request.getRequestDispatcher("ControladorFinanciera?menu=Administracion&accion=Listar").forward(request, response);
                    break;

                default:
            }
            request.getRequestDispatcher("Usuarios.jsp").forward(request, response);
        }
        if (menu.equals("CargarDatos")) {
            cargar.leer();
            cargar.cargar();
            request.getRequestDispatcher("Cargar.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
