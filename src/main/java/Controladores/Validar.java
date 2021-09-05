/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Usuarios;
import Modelos.UsuariosBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karlamatias
 */
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    Usuarios usuario = new Usuarios();
    UsuariosBD usuarioBD = new UsuariosBD();

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

        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("Ingresar")) {
            String documento = request.getParameter("txtusuario");
            String pass = request.getParameter("txtpassword");
            usuario = usuarioBD.Validar(documento, pass);

            //si existe el usuario en la base de datos, debera ingresar
            if (usuario.getUsuario() != null) {

                request.setAttribute("usuario", usuario);

                //ahora vamos a loggear con el area, esto significa, que si alguien no es de esta area no podra ingresar
                if (usuario.getArea().equals("Financiera")) {
                    request.getRequestDispatcher("Controlador?menu=Financiera").forward(request, response);
                }
                if (usuario.getArea().equals("Fabrica")) {
                    request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
                }
                if (usuario.getArea().equals("Ventas")) {
                    request.getRequestDispatcher("Controlador?menu=Ventas").forward(request, response);
                }
            }

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
