<%-- 
    Document   : Reportes
    Created on : 2/09/2021, 00:58:00
    Author     : karlamatias
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>


        <title>Reportes</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container-fluid">

                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Reportes</a>
                        </li>
                        <li class="nav-item">

                            <a style ="margin-left: 10 px; border: none;" class="btn btn-outline-light" href="ControladorFinanciera?menu=Financiera&accion=default" target="myFrame">Reporte Ventas</a>
                        </li>
                        <li class="nav-item">
                            <a style ="margin-left: 10 px; border: none;" class="btn btn-outline-light" href="ControladorFinanciera?menu=Administracion&accion=default" target="myFrame">Reporte Devoluciones</a>
                        </li>


                        <li class="nav-item">
                            <a style ="margin-left: 10 px; border: none;" class="btn btn-outline-light" href="ControladorFinanciera?menu=CargarDatos" target="myFrame">Reporte Usuarios</a>
                        </li>

                        <li class="nav-item">
                            <a style ="margin-left: 10 px; border: none;" class="btn btn-outline-light" href="ControladorFinanciera?menu=CargarDatos" target="myFrame">Reporte Muebles</a>
                        </li>
                    </ul>
                </div>
                

        </nav>

        <div class="m-4" style="height: 550px;">

            <iframe name="myFrame"  style="height: 100%; width: 100%"; border: none > </iframe>

        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
