<%-- 
    Document   : Piezas
    Created on : 23/08/2021, 16:21:56
    Author     : karlamatias
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

        <title>Piezas</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4 ">
                <div class="card-body">
                    <form action="Controlador?menu=Piezas" method="POST">
                        <div class = "form-group">
                            <label> Tipo Pieza </label>
                            <input type="text" value = "${pieza.getTipoPieza()}" name = "txtPieza" class= "form-control">                        
                        </div>
                        <div class = "form-group">
                            <label> Cantidad Existente </label>
                            <input type="text" value = "${pieza.getCantidadExistenteP()}"  name = "txtCantidad" class= "form-control">                        
                        </div>
                        <div class = "form-group">
                            <label> Precio </label>
                            <input type="text" value = "${pieza.getPrecio()}" name = "txtPrecio" class= "form-control">                        
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        <input type="submit" name="accion" value="Ordenar DESC" class="btn btn-success">
                        <input type="submit" name="accion" value="Ordenar ASC" class="btn btn-success">
                        

                    </form>
                </div>
            </div>

            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Tipo de Piezas</th>
                            <th scope="col">Cantidad en Stock</th>
                            <th scope="col">Precio</th>


                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pi" items="${piezas}">
                            <tr>
                                <th scope="row">${pi.getIDPieza() }</th>
                                <td>${pi.getTipoPieza() }</td>
                                <td>${pi.getCantidadExistenteP() }</td>
                                <td>${pi.getPrecio() }</td>

                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Piezas&accion=Editar&id=${pi.getIDPieza()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Piezas&accion=Eliminar&id=${pi.getIDPieza()}">Eliminar</a>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
