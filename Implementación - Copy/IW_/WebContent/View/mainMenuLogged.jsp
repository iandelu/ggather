<!DOCTYPE html>
<html lang="es">
<%@ page import = "java.time.LocalDate" %>
<%@ page import = "java.time.format.DateTimeFormatter" %>
<%
												LocalDate localDate = LocalDate.now();
												DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
												String hoy = localDate.format(formatter);
												
												%>
<%@page import = "com.mycompany.iw.javabean.JugadorBean" %>
<jsp:useBean id="jugadorBean" class = "com.mycompany.iw.javabean.JugadorBean" scope="session"/>
<head>
	<title>Menu Principal</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   
    <body style="overflow-x:hidden; overflow-y:hidden">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>

<header id="main-header">
            
    <a id="logo-header" href="../mainMenu.jsp">
    <span class="header-pic"><img src="images/icons/logo3.png"></span>
        <span class="site-name">GGather</span>
    </a> 

    <nav>
        <ul>
            <li><a href="mainMenuLogged.jsp">Inicio</a></li>
            <li><a href="crearPartido.jsp">Crear Partido</a></li>
            <li><a href="menuPerfil.jsp"  >Mi Perfil</a></li>
            <li><a href="../LogoutController">Cerrar Sesión</a></li>
        </ul>
    </nav>

</header>

<video class=video  loop autoplay muted>
    <source src="videos/video1_Trim.mp4" type="video/mp4">
</video>

<body>
    <div class="limiter-menu">
                        <div class="b-busqueda">
                            <form class="menu-form" action="/IW_/busquedaPartidosController" method = "post">
                                        <a id="barra-busqueda">
                                            <select name = "localidad" class="busqueda-menu">
                                            
                                                    <optgroup label="Localidades"> 
                                                            <option selected="true" value="Cordoba">Córdoba</option> 
                                                            <option value="Malaga">Málaga</option> 
                                                            <option value="Sevilla">Sevilla</option> 
                                                    </optgroup>    
                                                </select>

                                                <select name = "deporte" class="busqueda-menu2">
                                               
                                                    <optgroup label="Deportes"> 
                                                            <option selected="true" value="1">Pádel</option> 
                                                            <option value="2">Fútbol 11</option> 
                                                            <option value="3">Fútbol 7</option> 
                                                    </optgroup>
                                                </select>


                                                <input class="busqueda-menu3" type="date" name="fecha" placeholder="Fecha" value=<%=hoy %>>

                                                <input class="busqueda-menu4" type="number" name="jugadores" placeholder="Jugadores" value="1">

                                                <span class="focus-input100"></span>
                                                <span class="symbol-busqueda">
                                                <i class="fa fa-search" aria-hidden="true"></i>
                                                </span>

                                                <span class="busqueda-menu5">
                                                <button class="menu-form-btn">
                                                    Buscar
                                                </button>
                                                </span>
                                
                            
                                            </a>
                            </form>

                                <div class="texto-menu">
                                    <span class="menu-form-title">
                                        ENCUENTRA TU PARTIDO!
                                    </span>    
                                </div> 
                </div>  
        
    </div>    
</body>