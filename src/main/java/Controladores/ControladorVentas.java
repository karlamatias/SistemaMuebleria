/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Cliente;
import Modelos.ClienteBD;
import Modelos.Devolucion;
import Modelos.DevolucionBD;
import Modelos.Muebles;
import Modelos.MueblesBD;
import Modelos.Venta;
import Modelos.VentaBD;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControladorVentas", urlPatterns = {"/ControladorVentas"})
public class ControladorVentas extends HttpServlet {

    Cliente cliente = new Cliente();
    ClienteBD clientebd = new ClienteBD();
    Muebles mueble = new Muebles();
    MueblesBD muebleBD = new MueblesBD();

    Venta ve = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int codigoV;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalPagar;
    NumberFormat formatoNumero1;
    String total1;

    VentaBD ventabd = new VentaBD();
    int numeroSerie = 0;

    Devolucion dv = new Devolucion();
    DevolucionBD dbd = new DevolucionBD();

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
//buscamos el menu y la accion y que deseamos realizar 
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":

                    String nit = request.getParameter("CodigoCliente");
                    if (nit == null) {
                        request.setAttribute("cliente", cliente);
                    }
                    cliente.setNit(nit);
                    cliente = clientebd.buscar(nit);
                    request.setAttribute("cliente", cliente);
                    break;

                case "BuscarProducto":
                    try {
                    int id = Integer.parseInt(request.getParameter("CodigoProducto"));
                    mueble.setId(id);
                    mueble = muebleBD.listarporID(id);
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("mueble", mueble);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", total1);

                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
                break;

                case "Agregar":
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("numSerie", numeroSerie);
                    totalPagar = 0.0;
                    try {
                        item++;
                        codigoV = mueble.getId();
                        descripcion = request.getParameter("nombreProducto");
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cantidad"));
                        subtotal = precio * cant;
                        ve = new Venta();
                        ve.setItem(item);
                        ve.setIdMueble(codigoV);
                        ve.setDescripcionProducto(descripcion);
                        ve.setPrecio(precio);
                        ve.setCantidad(cant);
                        ve.setSubtotal(subtotal);
                        lista.add(ve);
                        for (int i = 0; i < lista.size(); i++) {
                            totalPagar += lista.get(i).getSubtotal();
                        }
                        formatoNumero1 = NumberFormat.getNumberInstance();
                        total1 = formatoNumero1.format(totalPagar);
                        request.setAttribute("totalPagar", total1);
                        request.setAttribute("lista", lista);

                    } catch (NumberFormatException e) {
                        // Send back error message to the client, for example:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                    }
                    break;

                case "GenerarVenta":
                    //metodo para actualizar el Stock despues de realizada una compra
                    for (int i = 0; i < lista.size(); i++) {
                        Muebles mb = new Muebles();
                        int cantidad = lista.get(i).getCantidad();
                        int ideMueble = lista.get(i).getIdMueble();
                        MueblesBD mbd = new MueblesBD();
                        mb = mbd.buscar(ideMueble);
                        int act = mb.getStock() - cantidad;
                        mbd.ActualizarStock(ideMueble, act);
                    }

                    //Guardar la venta
                    ve.setIdCliente(cliente.getNit());
                    ve.setIdUsuario("Fmatias");
                    ve.setNumeroFactura(numeroSerie);
                    ve.setFecha("2020-02-03");
                    ve.setMonto(totalPagar);
                    ventabd.guardarVenta(ve);

                    //Guardar la factura en el sistema
                    ve.setNumeroFactura(numeroSerie);
                    ve.setIdVenta(item);
                    ve.setIdCliente(cliente.getNit());
                    ve.setMonto(totalPagar);
                    ventabd.GenerarFactura(ve);

                    //Guardar el detalle de la venta realizada
                    int idv = ventabd.ObtenerMaximoIdVentas();
                    for (int i = 0; i < lista.size(); i++) {
                        ve = new Venta();
                        ve.setIdVenta(idv);
                        ve.setIdMueble(lista.get(i).getIdMueble());
                        ve.setCantidad(lista.get(i).getCantidad());
                        ve.setPrecio(lista.get(i).getPrecio());
                        ventabd.GuardarDetalleVenta(ve);
                    }

                    break;

                default:
                    //generar el numero de serie de la Factura. 
                    try {
                    String factura = ventabd.GenerarSerie();

                    if (factura == null) {
                        factura = "1";
                    } else {
                        numeroSerie = Integer.parseInt(factura) + 1;
                    }

                    request.setAttribute("numerofactura", numeroSerie);

                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }

            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }

        //para registrar nuestras devoluciones
        if (menu.equals("Devoluciones")) {
            switch (accion) {
                case "Listar":
                    List lista = dbd.Listar();
                    request.setAttribute("devolucion", lista);
                    
                    break;

                case "Agregar":
                    try {
                    int noFactura = Integer.parseInt(request.getParameter("txtnum"));
                    String cliente = request.getParameter("txtnit");
                    String monto = request.getParameter("txtmonto");
                    String fech = request.getParameter("txtfecha");
                    dv.setNoFactura(noFactura);
                    dv.setNitcliente(cliente);
                    dv.setMonto(monto);
                    dv.setFecha(fech);
                    dbd.Agregar(dv);
                    request.getRequestDispatcher("ControladorVentas?menu=Devoluciones&accion=Listar").forward(request, response);

                } catch (NumberFormatException e) {
                    // Send back error message to the client, for example:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;

                }

                break;
                default:
            }
            request.getRequestDispatcher("Devoluciones.jsp").forward(request, response);
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
