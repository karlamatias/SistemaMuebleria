<%-- 
    Document   : ReporteVentas
    Created on : 3/09/2021, 10:58:20
    Author     : karlamatias
--%>

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

        <title>Reporte Ventas</title>
    </head>
    <body>
       <div class="d-flex">
            <div class="card col-sm-4 ">
                <div class="card-body">
                    <form action="ControladorFinanciera?menu=Financiera&accion=ReporteVentas" method="POST">
                        <div class = "form-group">
                            <label> Fehca Inicio </label>
                            <input type="text" value = "" name = "txtfechai" class= "form-control">                        
                        </div>
                        <div class = "form-group">
                            <label> Fecha Final </label>
                            <input type="text" value = "" name = "txtfechaf" class= "form-control">                        
                        </div>
                     
                        <input type="submit" name="accion" value="ReporteVentas" class="btn btn-info">
                      
                    </form>
                </div>
            </div>
    </body>
</html>
