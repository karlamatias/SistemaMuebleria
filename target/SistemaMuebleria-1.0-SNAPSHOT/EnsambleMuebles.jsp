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

        <title>Ensamblar Muebles </title>


    </head>
    <body>
        <div class="d-flex">

            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=EnsambleMuebles" method="POST">
                        <div class="card-body">

                            <div class="form-group">
                                <label>Datos:</label>
                            </div>
                            <div class="form-group">
                                <label> Ingrese Nombre Mueble </label>
                                <input type="text" value="" name = "txtMueble" class= "form-control">                        
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" >
                                    <input type="text" name="CodigoPieza" class="form-control" placeholder="CodigoPieza">
                                    <input type="submit" name="accion" value="BuscarPieza" class="btn btn-outline-info" placeholder="Nombre Pieza">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombrePieza" value="${pieza.getTipoPieza()}" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="precio" value="${pieza.getPrecio()}" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" value="1" name="cantidad" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock" value="${pieza.getCantidadExistenteP()}" class="form-control">
                                </div>

                            </div>
                            <div class="form-group">
                                <input type="submit" name="accion" value="Agregar" class="btn-outline-info">
                            </div>

                        </div>
                    </form>
                </div>

            </div>

            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Precio Pieza (c/u)</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">SubTotal</th>
                                    <th scope="col" class="accion">Acciones</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdPiza()}</td>
                                        <td>${list.getDescripcionPieza() }</td>                              
                                        <td>${list.getPrecio()}</td>
                                        <td>${list.getCantNecesaria()} </td>
                                        <td>${list.getSubtotal()}</td>
                                        <td>
                                            <a href="#" class="btn btn-warning">Editar</a>
                                            <a href="#" class="btn btn-danger">Eliminar</a>


                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=EnsambleMuebles&accion=Generar" " class="btn btn-success">Ensamblar Mueble</a>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="${total}" class="form-control"> 
                        </div>

                    </div>

                </div>

            </div>

        </div>





        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        -->
    </body>
</html>
