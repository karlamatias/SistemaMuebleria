/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.CargarDatos;
import Modelos.Ensamblador;
import Modelos.EnsambleMueble;
import Modelos.EnsambleMueblesBD;
import Modelos.Muebles;
import Modelos.MueblesBD;
import Modelos.Piezas;
import Modelos.PiezasBD;
import Modelos.Venta;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karlamatias
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    Piezas pieza = new Piezas();
    PiezasBD piezaBD = new PiezasBD();
    Muebles mueble = new Muebles();
    MueblesBD muebleBD = new MueblesBD();
    Ensamblador ensamblador = new Ensamblador();
    EnsambleMueble en = new EnsambleMueble();
    EnsambleMueblesBD e = new EnsambleMueblesBD();
    List<EnsambleMueble> lista = new ArrayList<>();
    String descripcion;
    int item;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    NumberFormat formatoNumero1;
    String total1;
    int codigoE;
    int ide;
    int ideM;

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
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Fabrica")) {
            request.getRequestDispatcher("Fabrica.jsp").forward(request, response);
        }
        if (menu.equals("Financiera")) {
            request.getRequestDispatcher("Financiera.jsp").forward(request, response);
        }
        if (menu.equals("Ventas")) {
            request.getRequestDispatcher("Ventas.jsp").forward(request, response);
        }

        //para mostrar el menu de piezas
        if (menu.equals("Piezas")) {
            switch (accion) {
                case "Listar":
                    List lista = piezaBD.Listar();
                    request.setAttribute("piezas", lista);
                    break;
                case "Agregar":
                    String tipo = request.getParameter("txtPieza");
                    String cant = request.getParameter("txtCantidad");
                    String prec = request.getParameter("txtPrecio");
                    pieza.setTipoPieza(tipo);
                    pieza.setCantidadExistenteP(cant);
                    pieza.setPrecio(prec);
                    piezaBD.Agregar(pieza);
                    request.getRequestDispatcher("Controlador?menu=Piezas&accion=Listar").forward(request, response);

                    break;

                case "Editar":
                    try {
                    ide = Integer.parseInt(request.getParameter("id"));
                    Piezas p = piezaBD.listarporID(ide);
                    request.setAttribute("pieza", p);
                    request.getRequestDispatcher("Controlador?menu=Piezas&accion=Listar").forward(request, response);
                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }

                break;

                case "Actualizar":
                    String tipo1 = request.getParameter("txtPieza");
                    String cant1 = request.getParameter("txtCantidad");
                    String prec1 = request.getParameter("txtPrecio");
                    pieza.setTipoPieza(tipo1);
                    pieza.setCantidadExistenteP(cant1);
                    pieza.setPrecio(prec1);
                    pieza.setIDPieza(ide);
                    piezaBD.Actualizar(pieza);
                    request.getRequestDispatcher("Controlador?menu=Piezas&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":
                    try {
                    ide = Integer.parseInt(request.getParameter("id"));
                    piezaBD.Eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Piezas&accion=Listar").forward(request, response);

                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }

                break;

                case "Ordenar ASC":
                    List listaASC = piezaBD.ListarASC();
                    request.setAttribute("piezas", listaASC);
                    break;

                case "Ordenar DESC":
                    List listaDESC = piezaBD.ListarDESC();
                    request.setAttribute("piezas", listaDESC);
                    break;

                default:

            }
            request.getRequestDispatcher("Piezas.jsp").forward(request, response);
        }

        //para mostrar el menu Ensamble de muebles
        if (menu.equals("EnsambleMuebles")) {
            switch (accion) {
                case "BuscarPieza":
                    try {
                    int cod = Integer.parseInt(request.getParameter("CodigoPieza"));
                    pieza.setIDPieza(cod);
                    pieza = piezaBD.listarporID(cod);
                    request.setAttribute("pieza", cod);
                    request.setAttribute("pieza", pieza);
                    request.setAttribute("lista", lista);
                    request.setAttribute("total", total1);

                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
                break;

                case "Agregar":
                    request.setAttribute("pieza", pieza);
                    totalPagar = 0.0;
                    try {
                        item++;
                        codigoE = pieza.getIDPieza();
                        descripcion = request.getParameter("nombrePieza");
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cantidad"));
                        subtotal = precio * cant;
                        en = new EnsambleMueble();
                        en.setIdPiza(codigoE);
                        en.setDescripcionPieza(descripcion);
                        en.setPrecio(precio);
                        en.setCantNecesaria(cant);
                        en.setSubtotal(subtotal);
                        lista.add(en);
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar += lista.get(i).getSubtotal();
                        }
                        formatoNumero1 = NumberFormat.getNumberInstance();
                        total1 = formatoNumero1.format(totalPagar);
                        request.setAttribute("total", total1);
                        request.setAttribute("lista", lista);

                    } catch (NumberFormatException e) {
                        // Send back error message to the client, for example:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }
                    break;

                case "Generar":
                    //metodo para actualizar el Stock despues de realizado un ensamble
                    /*for (int i = 0; i < lista.size(); i++) {
                        Piezas pi = new Piezas();
                        int cantidad = lista.get(i).getCantNecesaria();
                        int idpieza = lista.get(i).getIdPiza();
                        PiezasBD pbd = new PiezasBD();
                        pi = pbd.listarporID(idpieza);
                        // int act = pi.getCantidadExistenteP() - cantidad;
                        //  pbd.ActualizarStock(idpieza);
                    }*/

                    //Guardar el mueble
                    String nom = request.getParameter("txtMueble");
                    en.setTipomueble(nom);
                    en.setIdPiza(pieza.getIDPieza());
                    en.setUsuarioEnsamblador(ensamblador.getIDEnsamblador());
                    en.setFechaEnsamble("2020-02-03");
                    en.setMonto(totalPagar);
                    e.EnsamblarMueble(en);
                    break;
                default:
            }

            request.getRequestDispatcher("EnsambleMuebles.jsp").forward(request, response);
        }

        //para mostar el menu de muebles
        if (menu.equals("Muebles")) {
            switch (accion) {
                case "Listar":
                    List Lista = muebleBD.Listar();
                    request.setAttribute("muebles", Lista);

                    break;
                case "Editar":
                try {
                    ideM = Integer.parseInt(request.getParameter("id"));
                    Muebles m = muebleBD.listarporID(ideM);
                    request.setAttribute("mueble", m);
                    request.getRequestDispatcher("Controlador?menu=Muebles&accion=Listar").forward(request, response);
                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }

                break;

                case "Agregar":
                try {
                    String fecha = request.getParameter("txtFecha");
                    String precio = request.getParameter("txtPre");
                    String ensamblador = request.getParameter("txtEnsamblador");
                    int cant = Integer.parseInt(request.getParameter("txtCant"));
                    String nom = request.getParameter("txtMueble");
                    mueble.setFecha(fecha);
                    mueble.setPrecio(precio);
                    mueble.setEnsamblador(ensamblador);
                    mueble.setStock(cant);
                    mueble.setNombre(nom);
                    muebleBD.Agregar(mueble);
                    request.getRequestDispatcher("Controlador?menu=Muebles&accion=Listar").forward(request, response);
                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
                break;

                case "Actualizar":
                    try {
                    String fecha1 = request.getParameter("txtFecha");
                    String precio1 = request.getParameter("txtPre");
                    String ensamblador1 = request.getParameter("txtEnsamblador");
                    int cant1 = Integer.parseInt(request.getParameter("txtCant"));
                    String nom1 = request.getParameter("txtMueble");
                    mueble.setFecha(fecha1);
                    mueble.setPrecio(precio1);
                    mueble.setEnsamblador(ensamblador1);
                    mueble.setStock(cant1);
                    mueble.setNombre(nom1);
                    mueble.setId(ideM);
                    muebleBD.Actualizar(mueble);
                    request.getRequestDispatcher("Controlador?menu=Muebles&accion=Listar").forward(request, response);
                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
                break;

                case "Eliminar":
                try {
                    ideM = Integer.parseInt(request.getParameter("id"));
                    muebleBD.Eliminar(ideM);
                    request.getRequestDispatcher("Controlador?menu=Muebles&accion=Listar").forward(request, response);

                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }

                break;

                case "Ordenar ASC":
                    List listaASC = muebleBD.ListarASC();
                    request.setAttribute("muebles", listaASC);
                    break;

                case "Ordenar DESC":
                    List listaDESC = muebleBD.ListarDESC();
                    request.setAttribute("muebles", listaDESC);
                    break;

                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("Muebles.jsp").forward(request, response);
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
